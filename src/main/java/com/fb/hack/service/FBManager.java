package com.fb.hack.service;

import com.fb.hack.dao.jpa.FBAccountRepository;
import com.fb.hack.dao.jpa.FBClientRepository;
import com.fb.hack.dao.jpa.FBFriendsRepository;
import com.fb.hack.dao.jpa.FBPostTaskRepository;
import com.fb.hack.domain.FBAccountDto;
import com.fb.hack.domain.FBClientDto;
import com.fb.hack.domain.in.FindAccountsRequest;
import com.fb.hack.domain.in.FindTasksRequest;
import com.fb.hack.domain.in.PageDto;
import com.fb.hack.domain.in.TaskRequest;
import com.fb.hack.entity.FBAccount;
import com.fb.hack.entity.FBClient;
import com.fb.hack.entity.FBPostTask;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 上午11:34
 * To change this template use File | Settings | File Templates.
 */
@Service
public class FBManager {

    @Autowired
    private FBAccountRepository fbAccountRepository;

    @Autowired
    private FBFriendsRepository fbFriendsRepository;

    @Autowired
    private FBClientRepository fbClientRepository;

    @Autowired
    private FBPostTaskRepository fbPostTaskRepository;

    /**
     * Create fb account.
     *
     * @param fbAccountDto the fb account dto
     */
    public void createFBAccount(FBAccountDto fbAccountDto) {
        FBAccount fbAccount = new FBAccount();
        BeanUtils.copyProperties(fbAccountDto, fbAccount);
        fbAccountRepository.save(fbAccount);
    }


    /**
     * Find all fb accounts page.
     *
     * @param request the request
     * @return the page
     */
    public Page<FBAccount> findAllFBAccounts(FindAccountsRequest request) {
        PageDto pageDto = request.getPageDto();
        PageRequest pageRequest = new PageRequest(pageDto.getPage() - 1, pageDto.getSize());
        List<FBAccountDto> accountDtoList = new ArrayList<>();
        Page<FBAccount> page = fbAccountRepository.findAll(pageRequest);
        page.forEach(fbAccount -> {
            FBAccountDto fbAccountDto = new FBAccountDto();
            BeanUtils.copyProperties(fbAccount, fbAccountDto, "fbFriends");
            fbAccountDto.setSumFriends(fbAccount.getFbFriends().size());
            accountDtoList.add(fbAccountDto);
        });
        return new PageImpl(accountDtoList, pageRequest, page.getTotalElements());
    }


    /**
     * Create fb client.
     *
     * @param fbClientDto the fb client dto
     */
    public void createFBClient(FBClientDto fbClientDto) {
        FBClient fbClient = new FBClient();
        BeanUtils.copyProperties(fbClientDto, fbClient);
        this.fbClientRepository.save(fbClient);
    }

    /**
     * Find all fb client list.
     *
     * @return the list
     */
    public List<FBClientDto> findAllFBClient() {
        List<FBClientDto> fbClientDtos = new ArrayList<>();
        this.fbClientRepository.findAll().forEach(fbClient -> {
            FBClientDto fbClientDto = new FBClientDto();
            BeanUtils.copyProperties(fbClient, fbClientDto);
            fbClientDtos.add(fbClientDto);
        });
        return fbClientDtos;
    }


    /**
     * Create task.
     *
     * @param request the request
     */
    public void createTask(TaskRequest request) {
        FBPostTask fbPostTask = new FBPostTask();
        BeanUtils.copyProperties(request, fbPostTask, "friendIds");
        if (request.getFriendIds() != null) {
            StringBuffer sb = new StringBuffer();
            request.getFriendIds().forEach(aLong -> {
                sb.append(String.valueOf(aLong)).append(",");
            });
            fbPostTask.setFriendIds(sb.toString());
        }
        fbPostTask.setSigned(false);
        this.fbPostTaskRepository.save(fbPostTask);
    }

    /**
     * Find all post tasks page.
     *
     * @param request the request
     * @return the page
     */
    public Page<FBPostTask> findAllPostTasks(FindTasksRequest request) {
        PageDto pageDto = request.getPageDto();
        PageRequest pageRequest = new PageRequest(pageDto.getPage() - 1, pageDto.getSize());
        return this.fbPostTaskRepository.findAll(pageRequest);
    }
}
