package com.mh.vo;

/**
 * 操作结果枚举
 * 
 * @author Jani
 * @time 2016年1月19日16:47:20
 */
public enum ResultEnum {

	SUCCESS(600, "操作成功!"),

	SYS_ERROR(500, "系统异常");
	
	private int index;

	private String msg;

	private ResultEnum(int index, String msg) {
		this.index = index;
		this.msg = msg;
	}

	public int getIndex() {
		return index;
	}

	public String getMsg() {
		return msg;
	}
}


