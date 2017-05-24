package com.fb.hack.service;

import com.fb.hack.common.CopyNotNullBeanUtils;
import com.fb.hack.dao.jpa.FBAccountRepository;
import com.fb.hack.dao.jpa.FBClientRepository;
import com.fb.hack.dao.jpa.FBFriendsRepository;
import com.fb.hack.dao.jpa.FBPostTaskRepository;
import com.fb.hack.domain.FBAccountDto;
import com.fb.hack.domain.FBClientDto;
import com.fb.hack.domain.FBFriendsDto;
import com.fb.hack.domain.FBPostTaskDto;
import com.fb.hack.domain.in.RecordRequest;
import com.fb.hack.entity.FBAccount;
import com.fb.hack.entity.FBClient;
import com.fb.hack.entity.FBFriends;
import com.fb.hack.entity.FBPostRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 上午11:33
 * To change this template use File | Settings | File Templates.
 */
@Service
public class FBClientService {

    @Autowired
    private FBClientRepository fbClientRepository;


    @Autowired
    private FBPostTaskRepository fbPostTaskRepository;

    @Autowired
    private FBAccountRepository fbAccountRepository;

    @Autowired
    private FBFriendsRepository fbFriendsRepository;


    /**
     * Register.
     *
     * @param fbClientDto the fb client dto
     */
    public void registeClient(FBClientDto fbClientDto) {
        FBClient fbClient = new FBClient();
        BeanUtils.copyProperties(fbClientDto, fbClient);
        fbClient.setUpdateTime(new Date());
        this.fbClientRepository.save(fbClient);
    }

    /**
     * Find all tasks list.
     *
     * @param mac the mac
     * @return the list
     */
    @Transactional
    public List<FBPostTaskDto> findAllTasks(String mac) {
        List<FBPostTaskDto> fbPostTaskDtos = new ArrayList<>();
        this.fbPostTaskRepository.findAllByMacAddress(mac).forEach(fbPostTask -> {
            // 标记已经分配了任务
            fbPostTask.setSigned(true);
            FBPostTaskDto taskDto = new FBPostTaskDto();
            FBAccount fbAccount = this.fbAccountRepository.findOne(fbPostTask.getAccountId());
            FBAccountDto fbAccountDto = new FBAccountDto();
            BeanUtils.copyProperties(fbAccount, fbAccountDto, "fbFriends");
            // 查找任务中好友
            if (fbPostTask.getFriendIds() != null) {
                String[] friendsId = fbPostTask.getFriendIds().split(",");
                if (friendsId.length > 0) {
                    List<FBFriendsDto> fbFriendsDtos = new ArrayList<>();
                    Arrays.asList(friendsId).forEach(s -> {
                        long friendId = Long.valueOf(s.trim());
                        FBFriends fbFriends = fbFriendsRepository.findOne(friendId);
                        if (fbFriends != null) {
                            FBFriendsDto fbFriendsDto = new FBFriendsDto();
                            fbFriendsDto.setID(fbFriends.getID());
                            fbFriendsDto.setName(fbFriends.getName());
                            fbFriendsDto.setUrl(fbFriends.getUrl());
                            fbFriendsDtos.add(fbFriendsDto);
                        }
                    });
                    fbAccountDto.setFbFriends(fbFriendsDtos);
                }
            }
            taskDto.setFbAccountDto(fbAccountDto);
            taskDto.setImageUrl(fbPostTask.getImageUrl());
            taskDto.setMessage(fbPostTask.getMessage());
            fbPostTaskDtos.add(taskDto);
        });
        return fbPostTaskDtos;
    }

    /**
     * Update fb account.
     *
     * @param fbAccountDto the fb account dto
     */
    public void updateFBAccount(FBAccountDto fbAccountDto) {
        if (fbAccountDto.getID() != null) {
            FBAccount fbAccount = this.fbAccountRepository.findOne(fbAccountDto.getID());
            BeanUtils.copyProperties(fbAccountDto, fbAccount, CopyNotNullBeanUtils.getNullPropertyNames(fbAccountDto));
            // 更新好友列表
            if (fbAccountDto.getFbFriends() != null) {
                List<FBFriends> fbFriendsList = this.addFriends(fbAccountDto.getID(), fbAccountDto.getFbFriends());
                fbAccount.setFbFriends(fbFriendsList);
            }
            this.fbAccountRepository.save(fbAccount);
        }
    }

    /**
     * Record.
     *
     * @param recordRequest the record request
     */
    public void recordPostResult(RecordRequest recordRequest) {
        FBPostRecord fbPostRecord = new FBPostRecord();
        BeanUtils.copyProperties(recordRequest, fbPostRecord);
        fbPostRecord.setLastSendTime(new Date());
        fbPostRecord.setUpdateTime(new Date());
    }

    /**
     * Add friends.
     *
     * @param accountId     the account id
     * @param fbFriendsDtos the fb friends dtos
     */
    private List<FBFriends> addFriends(Long accountId, List<FBFriendsDto> fbFriendsDtos) {
        FBAccount fbAccount = this.fbAccountRepository.findOne(accountId);
        List<FBFriends> fbFriendsArrayList = new ArrayList<>();
        fbFriendsDtos.forEach(fbFriendsDto -> {
            FBFriends fbFriends = new FBFriends();
            BeanUtils.copyProperties(fbFriendsDto, fbFriends);
            fbFriends.setFbAccount(fbAccount);
            fbFriendsRepository.save(fbFriends);
//            fbFriendsArrayList.add(fbFriends);
        });
        return fbFriendsArrayList;
//        fbAccount.setFbFriends(fbFriendsArrayList);
    }
}
