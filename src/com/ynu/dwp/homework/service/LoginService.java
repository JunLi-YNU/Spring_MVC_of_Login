package com.ynu.dwp.homework.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ynu.dwp.homework.dao.UserDAO;
import com.ynu.dwp.homework.vo.User;

public class LoginService {
	
	//��¼
	public boolean loginService(String name,String password) {
		//ʵ����DAO��
		UserDAO userDAO = new UserDAO();
		boolean b = userDAO.loginDAO(name, password);
		return b;
	}
	
	//��ѯ�����û�
	public ArrayList<User> queryAllUserService() throws ClassNotFoundException, SQLException{
		//ʵ����DAO��
		UserDAO userDAO = new UserDAO();
		ArrayList<User> arrayList = userDAO.queryAllUserDAO();
		
		return arrayList;
	}

}
