package com.talelife.myproject.vo;

import javax.validation.constraints.NotEmpty;

public class UserAdd {
	/**
	 * 姓名
	 */
	@NotEmpty(message="姓名不能为空")
	private String username;
	
	/**
	 * 年龄
	 */
	private Integer age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
