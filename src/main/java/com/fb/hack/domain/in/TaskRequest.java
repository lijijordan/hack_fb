package com.fb.hack.domain.in;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 下午4:34
 * To change this template use File | Settings | File Templates.
 */
public class TaskRequest {
    /**
     * 账户ID
     */
    private Long accountId;

    /**
     * 好友ID ","分割
     */
    private List<Long> friendIds;

    /**
     * 执行程序设备
     */
    private String macAddress;

    /**
     * 执行时间
     */
    private Date executeTime;


    private String imageUrl;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public List<Long> getFriendIds() {
        return friendIds;
    }

    public void setFriendIds(List<Long> friendIds) {
        this.friendIds = friendIds;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
