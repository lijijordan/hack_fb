package com.fb.hack.domain.in;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 下午3:39
 * To change this template use File | Settings | File Templates.
 */
public class RecordRequest {

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
    private String macAddress;
    /**
     * 使用的IP地址
     */
    private String ip;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
