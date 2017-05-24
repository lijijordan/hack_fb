package com.fb.hack.api.rest;

import com.fb.hack.domain.FBAccountDto;
import com.fb.hack.domain.in.FindAccountsRequest;
import com.fb.hack.domain.in.FindTasksRequest;
import com.fb.hack.domain.in.TaskRequest;
import com.fb.hack.service.FBManager;
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

/**
 * The type Device manager controller.
 */
@RestController
@RequestMapping(value = "/fb/manager/api")
@Api(value = "FB Cloud")
public class FBManagerController extends AbstractRestHandler {

    private final Logger log = LoggerFactory.getLogger(FBManagerController.class);

    @Autowired
    private FBManager fbManager;

    @RequestMapping(value = "/account/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "创建账号")
    @Transactional
    public BaseResponse createAccount(@RequestBody FBAccountDto fbAccountDto) {
        this.fbManager.createFBAccount(fbAccountDto);
        return new BaseResponse(RESPONSE_SUCCESS);
    }


    @RequestMapping(value = "/account/import",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "导入账号")
    @Transactional
    public BaseResponse importAccount() {
        return new BaseResponse(RESPONSE_SUCCESS);
    }

    @RequestMapping(value = "/account/findAll",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "查找账号")
    @Transactional
    public BaseResponse findAllAccount(@RequestBody FindAccountsRequest request) {
        BaseResponse response = new BaseResponse(RESPONSE_SUCCESS);
        response.setData(this.fbManager.findAllFBAccounts(request));
        return response;
    }


    @RequestMapping(value = "/task/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "创建任务")
    @Transactional
    public BaseResponse createTask(@RequestBody TaskRequest request) {
        BaseResponse response = new BaseResponse(RESPONSE_SUCCESS);
        this.fbManager.createTask(request);
        return response;
    }


    @RequestMapping(value = "/task/findAll",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "查询所有任务")
    @Transactional
    public BaseResponse findAllTasks(@RequestBody FindTasksRequest request) {
        BaseResponse response = new BaseResponse(RESPONSE_SUCCESS);
        response.setData(this.fbManager.findAllPostTasks(request));
        return response;
    }
}
