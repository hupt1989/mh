package com.mh.vo;

import com.mh.vo.ResultEnum;

/**
 * 操作结果
 * @author Jani
 * @date 2016年1月19日15:14:22
 */
public class OperateResult {

	private int status;
	
	private String msg;
	
	private Object data;

	public OperateResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperateResult(ResultEnum operateResultEnum)
	{
		this.status = operateResultEnum.getIndex();
		this.msg = operateResultEnum.getMsg();
		this.data = null;
	}

	public OperateResult(int status,String msg,Object data){
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public OperateResult(ResultEnum operateResultEnum, Object data){
		this.status = operateResultEnum.getIndex();
		this.msg = operateResultEnum.getMsg();
		this.data = data;
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
