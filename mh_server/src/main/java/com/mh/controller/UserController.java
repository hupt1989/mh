package com.mh.controller;

import com.mh.service.UserService;
import com.mh.vo.OperateResult;
import com.mh.vo.ResultEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2016/7/25.
 */
@Controller
public class UserController extends BaseController{
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getUserById", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getUserById(Long userId){
        return new OperateResult(ResultEnum.SUCCESS, userService.getEntity(userId));
    }
}
