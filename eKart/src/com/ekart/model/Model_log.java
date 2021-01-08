package com.ekart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ekart.bean.Bean_log;
public class Model_log {
private String dbURL;
private String dbPassword;
private String dbUser;
private String dbDriver;
private Connection con;
private PreparedStatement st;

public String getDbURL() {
	return dbURL;
}
public void setDbURL(String dbURL) {
	this.dbURL = dbURL;
}
public String getDbPassword() {
	return dbPassword;
}
public void setDbPassword(String dbPassword) {
	this.dbPassword = dbPassword;
}
public String getDbUser() {
	return dbUser;
}
public void setDbUser(String dbUser) {
	this.dbUser = dbUser;
}
public String getDbDriver() {
	return dbDriver;
}
public void setDbDriver(String dbDriver) {
	this.dbDriver = dbDriver;
}


public boolean validate(String email, String pass)
{	boolean rs=false;
	String query="Select email,password from log where email=? and password=? ";
	try
	{
		Class.forName(dbDriver);
		con=DriverManager.getConnection(dbURL,dbUser,dbPassword);
		st=con.prepareStatement(query);
		st.setString(1, email);
		st.setString(2, pass);
		rs=st.execute();
		st.close();
		con.close();
		return rs;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Model_log-> validate()");
	}
	return rs;
}

public int create(Bean_log b)
{		
		int rs=0;
		String query="insert into log value ?,?,?";
		try
		{
			Class.forName(dbDriver);
			Connection con=DriverManager.getConnection(dbURL,dbUser,dbPassword);
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1, b.getUser());
			st.setString(2, b.getEmail());
			st.setString(3, b.getPassword());
			rs=st.executeUpdate();
			st.close();
			con.close();
			return rs;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Model_log()-> create()");
		}
		return rs;
}

public String user(String email, String pass)
{
	String str=null;
	String query="Select user from log where email=? and password=? ";
	try
	{
		Class.forName(dbDriver);
		con=DriverManager.getConnection(dbURL,dbUser,dbPassword);
		st=con.prepareStatement(query);
		st.setString(1, email);
		st.setString(2, pass);
		ResultSet rs=st.executeQuery();
		str=rs.getString(1);
		st.close();
		con.close();
		return str;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Model_log-> validate()");
	}
	return str;
}
}