package com.mh.vo;

import com.mh.vo.ResultEnum;

/**
 * 自定义异常抛出
 */
public class CustomException extends Exception {

    private int status;

    private String msg;

    private Object data;

    public CustomException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CustomException(ResultEnum operateResultEnum, Object data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public CustomException(ResultEnum operateResultEnum)
    {
        this.status = operateResultEnum.getIndex();
        this.data = "";
        this.msg = operateResultEnum.getMsg();
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
