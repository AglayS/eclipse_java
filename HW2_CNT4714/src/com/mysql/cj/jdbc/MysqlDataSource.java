package com.mysql.cj.jdbc;

import java.sql.Connection;

public class MysqlDataSource {
	{
	
	try {

		//Class.forName("com.mysql.jdbc.Driver");
	    Class.forName("com.mysql.jdbc.MysqlDataSource");//the class driver

	} catch (ClassNotFoundException e) {

	    e.printStackTrace();

	}

}

	public Connection getConnection(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPassword(String property) {
		// TODO Auto-generated method stub
		
	}

	public void setUser(String property) {
		// TODO Auto-generated method stub
		
	}

	public void setURL(String property) {
		// TODO Auto-generated method stub
		
	}
}
