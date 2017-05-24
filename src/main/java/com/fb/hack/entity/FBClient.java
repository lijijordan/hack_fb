package com.fb.hack.entity;

import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 上午11:28
 * To change this template use File | Settings | File Templates.
 * 超级客户端
 */
@Entity
public class FBClient extends BaseEntity {

    private String hostName;

    private String ip;

    private String macAddress;

    private String node;

    private boolean isOnline;


    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }
}
