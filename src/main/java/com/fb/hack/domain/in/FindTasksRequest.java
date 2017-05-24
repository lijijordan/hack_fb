package com.fb.hack.domain.in;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 下午4:44
 * To change this template use File | Settings | File Templates.
 */
public class FindTasksRequest {

    private PageDto pageDto;

    private boolean isSigned;

    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }

    public PageDto getPageDto() {
        return pageDto;
    }

    public void setPageDto(PageDto pageDto) {
        this.pageDto = pageDto;
    }
}
