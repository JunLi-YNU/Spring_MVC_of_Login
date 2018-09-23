package com.ynu.dwp.homework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ynu.dwp.homework.vo.User;

public class UserDAO {
	
	//判断登录是否成功
	public boolean loginDAO(String name, String password) {
		//1.加载驱动
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//2.建立连接
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "scott", "tiger");
			//3.执行SQL语句
			PreparedStatement preparedStatement = connection.prepareStatement("select * from usertest where name = ? and password = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			//4.接收返回的结果集
			ResultSet resultSet = preparedStatement.executeQuery();
			//5.关闭连接。
			if(resultSet.next()== true) {
				resultSet.close();
				preparedStatement.close();
				connection.close();	
				return true;
			}else {
				resultSet.close();
				preparedStatement.close();
				connection.close();
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}
	//查询所有用户错误信息
	public ArrayList<User> queryAllUserDAO() throws ClassNotFoundException, SQLException{
		//1.加载数据库驱动
		Class.forName("oracle.jabc.drvier.OracleDrvier");
		//2.建立连接
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "scott", "tiger");
		//3.执行SQLyuju
		PreparedStatement preparedStatement = connection.prepareStatement("select * from usertest");
		//4.接收返回的结果集
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<User> arrayList = new ArrayList<>();
		User user = new User();
		while(resultSet.next()) {
			user.setId(resultSet.getInt(1));
			user.setName(resultSet.getString(2));
			user.setPassword(resultSet.getString(3));
			arrayList.add(user);
		}
		//5.关闭连接
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return arrayList;
	}

}
