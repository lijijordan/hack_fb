package com.fb.hack.entity;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 下午2:21
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class FBPostTask extends BaseEntity {

    /**
     * 账户ID
     */
    private Long accountId;

    /**
     * 好友ID ","分割
     */
    private String friendIds;

    /**
     * 执行程序设备
     */
    private String macAddress;

    /**
     * 执行时间
     */
    private Date executeTime;


    private String imageUrl;

    private String message;
    /**
     * 任务被领取
     */
    private Boolean isSigned;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSigned() {
        return isSigned;
    }

    public void setSigned(Boolean signed) {
        isSigned = signed;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getFriendIds() {
        return friendIds;
    }

    public void setFriendIds(String friendIds) {
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
}
