package com.fb.hack.entity;

import com.fb.hack.common.FBAccountStatus;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 上午9:54
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class FBAccount extends BaseEntity {

    /**
     * 登录账号
     */
    private String account;

    private String password;

    private String authToken;

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
    @OneToMany(mappedBy = "fbAccount")
    private List<FBFriends> fbFriends;

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

    public Boolean getValidate() {
        return isValidate;
    }

    public void setValidate(Boolean validate) {
        isValidate = validate;
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

    public List<FBFriends> getFbFriends() {
        return fbFriends;
    }

    public void setFbFriends(List<FBFriends> fbFriends) {
        this.fbFriends = fbFriends;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
