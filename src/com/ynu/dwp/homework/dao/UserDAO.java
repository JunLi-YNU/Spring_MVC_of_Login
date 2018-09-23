package com.ynu.dwp.homework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ynu.dwp.homework.vo.User;

public class UserDAO {
	
	//�жϵ�¼�Ƿ�ɹ�
	public boolean loginDAO(String name, String password) {
		//1.��������
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//2.��������
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "scott", "tiger");
			//3.ִ��SQL���
			PreparedStatement preparedStatement = connection.prepareStatement("select * from usertest where name = ? and password = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			//4.���շ��صĽ����
			ResultSet resultSet = preparedStatement.executeQuery();
			//5.�ر����ӡ�
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
	//��ѯ�����û�������Ϣ
	public ArrayList<User> queryAllUserDAO() throws ClassNotFoundException, SQLException{
		//1.�������ݿ�����
		Class.forName("oracle.jabc.drvier.OracleDrvier");
		//2.��������
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "scott", "tiger");
		//3.ִ��SQLyuju
		PreparedStatement preparedStatement = connection.prepareStatement("select * from usertest");
		//4.���շ��صĽ����
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<User> arrayList = new ArrayList<>();
		User user = new User();
		while(resultSet.next()) {
			user.setId(resultSet.getInt(1));
			user.setName(resultSet.getString(2));
			user.setPassword(resultSet.getString(3));
			arrayList.add(user);
		}
		//5.�ر�����
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return arrayList;
	}

}
