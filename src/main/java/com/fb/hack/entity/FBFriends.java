package com.fb.hack.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 上午9:57
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class FBFriends {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String name;

    /**
     * 好友链接地址
     */
    private String url;

    @ManyToOne
    @JoinColumn(name = "fb_account")
    private FBAccount fbAccount;


    /**
     * 能发送
     */
    private Boolean canBeSend;

    public Boolean getCanBeSend() {
        return canBeSend;
    }

    public void setCanBeSend(Boolean canBeSend) {
        this.canBeSend = canBeSend;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public FBAccount getFbAccount() {
        return fbAccount;
    }

    public void setFbAccount(FBAccount fbAccount) {
        this.fbAccount = fbAccount;
    }
}
