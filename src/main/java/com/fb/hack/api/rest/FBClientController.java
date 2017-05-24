package com.fb.hack.api.rest;

import com.fb.hack.domain.FBAccountDto;
import com.fb.hack.domain.FBClientDto;
import com.fb.hack.domain.in.FBClientRegRequest;
import com.fb.hack.domain.in.RecordRequest;
import com.fb.hack.service.FBClientService;
import com.fb.hack.vo.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Device manager controller.
 */
@RestController
@RequestMapping(value = "/fb/client/api")
@Api(value = "超级客户端的API")
public class FBClientController extends AbstractRestHandler {

    private final Logger log = LoggerFactory.getLogger(FBClientController.class);

    @Autowired
    private FBClientService fbClientService;


    /**
     * Register base response.
     *
     * @param regRequest the reg request
     * @param request    the request
     * @return the base response
     */
    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "注册Client")
    @Transactional
    public BaseResponse register(@RequestBody FBClientRegRequest regRequest, HttpServletRequest request) {
        FBClientDto fbClientDto = new FBClientDto();
        fbClientDto.setIp(request.getRemoteHost());
        fbClientDto.setOnline(true);
        fbClientDto.setMacAddress(regRequest.getMacAddress());
        fbClientDto.setHostName(regRequest.getHostName());
        this.fbClientService.registeClient(fbClientDto);
        return new BaseResponse(RESPONSE_SUCCESS);
    }


    /**
     * Register base response.
     *
     * @param fbAccountDto the fb account dto
     * @return the base response
     */
    @RequestMapping(value = "/account/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "更新FBAccount信息和好友列表")
    @Transactional
    public BaseResponse updateAccout(@RequestBody FBAccountDto fbAccountDto) {
        this.fbClientService.updateFBAccount(fbAccountDto);
        return new BaseResponse(RESPONSE_SUCCESS);
    }

    /**
     * Register base response.
     *
     * @param mac the mac
     * @return the base response
     */
    @RequestMapping(value = "/task/get/{mac}",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "获取Post任务")
    @Transactional
    public BaseResponse getTask(@PathVariable String mac) {
        BaseResponse response = new BaseResponse(RESPONSE_SUCCESS);
        response.setData(this.fbClientService.findAllTasks(mac));
        return response;
    }


    /**
     * Create record base response.
     *
     * @param recordRequest the record request
     * @return the base response
     */
    @RequestMapping(value = "/record/add",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "添加一条Post记录")
    @Transactional
    public BaseResponse createRecord(@RequestBody RecordRequest recordRequest) {
        BaseResponse response = new BaseResponse(RESPONSE_SUCCESS);
        this.fbClientService.recordPostResult(recordRequest);
        return response;
    }


}
