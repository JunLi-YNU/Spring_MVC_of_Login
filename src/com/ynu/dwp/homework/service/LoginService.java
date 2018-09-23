package com.ynu.dwp.homework.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ynu.dwp.homework.dao.UserDAO;
import com.ynu.dwp.homework.vo.User;

public class LoginService {
	
	//登录
	public boolean loginService(String name,String password) {
		//实例化DAO层
		UserDAO userDAO = new UserDAO();
		boolean b = userDAO.loginDAO(name, password);
		return b;
	}
	
	//查询所有用户
	public ArrayList<User> queryAllUserService() throws ClassNotFoundException, SQLException{
		//实例化DAO层
		UserDAO userDAO = new UserDAO();
		ArrayList<User> arrayList = userDAO.queryAllUserDAO();
		
		return arrayList;
	}

}
