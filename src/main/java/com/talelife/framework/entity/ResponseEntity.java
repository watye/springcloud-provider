package com.talelife.framework.entity;

import io.swagger.annotations.ApiModelProperty;

public final class ResponseEntity<T> {
	
	@ApiModelProperty(value = "是否成功")
	private boolean success = false;
	
	@ApiModelProperty(value = "错误信息")
	private String message;
	
	@ApiModelProperty(value = "错误编号")
	private String code;
	
	@ApiModelProperty(value = "返回对象")
	private T data;

	private ResponseEntity() {
	}

	private static <T> ResponseEntity<T> getInstance() {
		return new ResponseEntity<>();
	}

	public static <T> ResponseEntity<T> ok() {
		ResponseEntity<T> rs = getInstance();
		rs.setSuccess(true);
		return rs;
	}

	public static <T> ResponseEntity<T> fail() {
		ResponseEntity<T> rs = getInstance();
		rs.setSuccess(false);
		return rs;
	}

	public static <T> ResponseEntity<T> fail(String code) {
		ResponseEntity<T> rs = getInstance();
		rs.setSuccess(false);
		rs.setCode(code);
		return rs;
	}

	public static <T> ResponseEntity<T> fail(String code, String msg) {
		ResponseEntity<T> rs = getInstance();
		rs.setSuccess(false);
		rs.setCode(code);
		rs.setMessage(msg);
		return rs;
	}

	public static <T> ResponseEntity<T> ok(T data) {
		ResponseEntity<T> rs = getInstance();
		rs.setSuccess(true);
		rs.setData(data);
		return rs;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
