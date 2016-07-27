package com.mh.controller;

import com.mh.vo.CustomException;
import com.mh.vo.OperateResult;
import com.mh.vo.ResultEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2016/7/16.
 */
public class BaseController {
    /** 基于@ExceptionHandler异常处理 */
    @ExceptionHandler
    @ResponseBody
    public Object exp(HttpServletRequest request, Exception ex) {
        //返回错误消息
        if(ex instanceof CustomException) {
            return new OperateResult(((CustomException) ex).getStatus(), ((CustomException) ex).getMsg(), null);
        } else {
            return new OperateResult(ResultEnum.SYS_ERROR);
        }
    }
}
