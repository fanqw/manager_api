package com.fqw.manager.vo;

import com.alibaba.fastjson.JSON;

public class Result {

	private Integer code;
	private String msg;
	private Object data;
	private String status;
	private String currentAuthority;
	private String type;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCurrentAuthority() {
		return currentAuthority;
	}
	public void setCurrentAuthority(String currentAuthority) {
		this.currentAuthority = currentAuthority;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Result() {
		super();
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
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
	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	public String toJson() {
		return JSON.toJSONString(this);
	}
}
