package com.fb.hack.domain;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 下午2:54
 * To change this template use File | Settings | File Templates.
 */
public class FBPostTaskDto {

    private FBAccountDto fbAccountDto;

    private String imageUrl;

    private String message;

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

    public FBAccountDto getFbAccountDto() {
        return fbAccountDto;
    }

    public void setFbAccountDto(FBAccountDto fbAccountDto) {
        this.fbAccountDto = fbAccountDto;
    }

}
