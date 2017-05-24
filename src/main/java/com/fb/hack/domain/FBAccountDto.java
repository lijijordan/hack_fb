package com.fb.hack.domain;

import com.fb.hack.common.FBAccountStatus;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 下午1:02
 * To change this template use File | Settings | File Templates.
 */
public class FBAccountDto {

    private Long ID;
    /**
     * 登录账号
     */
    private String account;
    private String password;
    private String authToken;

    private int sumFriends;
    /**
     * 验证过的
     * NULL 未验证的
     * true 验证通过
     * false  未通过
     */
    private Boolean isValidate;
    /**
     * 账户的状态
     */
    private FBAccountStatus accountStatus;
    /**
     * 账户登录IP
     */
    private String loginIP;
    /**
     * 备注信息
     */
    private String note;
    /**
     * 好友列表
     */
    private List<FBFriendsDto> fbFriends;

    public int getSumFriends() {
        return sumFriends;
    }

    public void setSumFriends(int sumFriends) {
        this.sumFriends = sumFriends;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Boolean getValidate() {
        return isValidate;
    }

    public void setValidate(Boolean validate) {
        isValidate = validate;
    }

    public FBAccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(FBAccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<FBFriendsDto> getFbFriends() {
        return fbFriends;
    }

    public void setFbFriends(List<FBFriendsDto> fbFriends) {
        this.fbFriends = fbFriends;
    }
}
