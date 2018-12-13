package com.cg.donar.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection() {
		
			try {
				
			FileInputStream fs=new FileInputStream ("resources/Db.properties");
			Properties pro=new Properties();
			pro.load(fs);
			String driver1=pro.getProperty("driver");
			String url=pro.getProperty("url");
			String username=pro.getProperty("username");
			String password=pro.getProperty("password");
			Class.forName(driver1);
			Connection con=DriverManager.getConnection(url,username,password);
			return con;
			}catch(Exception e)
			{
				System.out.println(e);
				e.printStackTrace();
			}
			return null;
			
			
		
	}

}
