package com.fb.hack.entity;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 上午9:59
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class FBPostRecord extends BaseEntity {

    /**
     * 任务ID
     */
    private Long taskId;
    /**
     * 发送者
     */
    private String sender;

    /**
     * 接受者
     */
    private Long friendId;
    /**
     * 是否发送成功
     */
    private boolean isSuccessed;
    /**
     * Post 的客户端
     */
    private Long fbClient;
    /**
     * 使用的IP地址
     */
    private String ip;
    /**
     * 上次投递时间
     */
    private Date lastSendTime;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getFbClient() {
        return fbClient;
    }

    public void setFbClient(Long fbClient) {
        this.fbClient = fbClient;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public boolean isSuccessed() {
        return isSuccessed;
    }

    public void setSuccessed(boolean successed) {
        isSuccessed = successed;
    }

    public Date getLastSendTime() {
        return lastSendTime;
    }

    public void setLastSendTime(Date lastSendTime) {
        this.lastSendTime = lastSendTime;
    }
}
