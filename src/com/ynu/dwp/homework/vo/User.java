package com.ynu.dwp.homework.vo;

/**
 * 用户的实体类
 * @author 12068
 *其中包含的参数有用户ID、用户姓名、用户密码
 */
public class User {
	
	private int id;
	private String name;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
