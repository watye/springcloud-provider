package com.talelife.myproject.vo;

public class UserUpdate {
	/**
	 * 用户id
	 */
	private Long id;
	
	/**
	 * 姓名
	 */
	private String username;
	
	/**
	 * 年龄
	 */
	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
