package com.fb.hack.domain;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 下午1:02
 * To change this template use File | Settings | File Templates.
 */
public class FBFriendsDto {

    private Long ID;

    private String name;
    /**
     * 好友链接地址
     */
    private String url;
    private FBAccountDto fbAccount;

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

    public FBAccountDto getFbAccount() {
        return fbAccount;
    }

    public void setFbAccount(FBAccountDto fbAccount) {
        this.fbAccount = fbAccount;
    }
}
