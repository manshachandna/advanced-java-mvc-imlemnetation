package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class logindao {

//	public bollogindao(String uname, String pass) {
//		// TODO Auto-generated constructor stub
//	}

	public boolean check(String uname,String pass) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/login", "mansha", "mansha123");
			PreparedStatement pst=(PreparedStatement) con.prepareStatement("select * from login where uname=? and pass=?");
			pst.setString(1, uname);
			pst.setString(2,pass);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				return true;

			}

		} 	
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
