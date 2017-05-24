package com.fb.hack.domain.in;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
public class FBClientRegRequest {

    private String hostName;

    private String macAddress;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
