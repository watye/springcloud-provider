package com.talelife.util;

public final class Result<T> {
	private boolean success = false;
	private String message;
	private String code;
	private T data;

	private Result() {
	}

	private static <T> Result<T> getInstance() {
		return new Result<>();
	}

	public static <T> Result<T> success() {
		Result<T> rs = getInstance();
		rs.setSuccess(true);
		return rs;
	}

	public static <T> Result<T> success(String code) {
		Result<T> rs = getInstance();
		rs.setSuccess(true);
		rs.setCode(code);
		return rs;
	}

	public static <T> Result<T> fail() {
		Result<T> rs = getInstance();
		rs.setSuccess(false);
		return rs;
	}

	public static <T> Result<T> fail(String code) {
		Result<T> rs = getInstance();
		rs.setSuccess(false);
		rs.setCode(code);
		return rs;
	}

	public static <T> Result<T> fail(String code, String msg) {
		Result<T> rs = getInstance();
		rs.setSuccess(false);
		rs.setCode(code);
		rs.setMessage(msg);
		return rs;
	}

	public static <T> Result<T> success(T data) {
		Result<T> rs = getInstance();
		rs.setSuccess(true);
		rs.setData(data);
		return rs;
	}

	public static <T> Result<T> success(String code, T data) {
		Result<T> rs = getInstance();
		rs.setSuccess(true);
		rs.setCode(code);
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
