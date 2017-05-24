package com.fb.hack.common;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 上午11:12
 * To change this template use File | Settings | File Templates.
 */
public enum FBAccountStatus {

    /**
     * post 锁定
     */
    POST_LOCK,
    /**
     * ip 锁定
     */
    LOCK_IP,
    /**
     * 密码错误
     */
    PASS_INVALIDATE,
    /**
     * 可以使用
     */
    OK
}
