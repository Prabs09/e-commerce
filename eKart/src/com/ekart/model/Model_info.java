package com.ekart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ekart.bean.Bean_info;

public class Model_info {
String dbURL;
String dbPassword;
String dbUser;
String dbDriver;
Bean_info infoB;
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

public Bean_info getprofile(String usermail)
{		
		String query="Select * from info where email = usermail";
		try
		{
			Class.forName(dbDriver);
			Connection con=DriverManager.getConnection(dbURL,dbUser,dbPassword);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			infoB.setAddress(rs.getString("address"));
			infoB.setContact(rs.getString("contact"));
			infoB.setEmail(rs.getString("email"));
			infoB.setFirstname(rs.getString("firstname"));
			infoB.setLastname(rs.getString("lastname"));
			infoB.setPincode(rs.getString("pincode"));
			infoB.setUser(rs.getString("user"));
			st.close();
			con.close();
			return infoB;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Model_info--> getprofile()");
		}
		return new Bean_info();
}

public boolean addprofile(Bean_info bean)
{
	String query="insert into info(firstname, lastname, contact, address, pincode) values(?,?,?,?,?)";
	boolean rs=false;
	try
	{
		Class.forName(dbDriver);
		Connection con=DriverManager.getConnection(dbURL,dbUser,dbPassword);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, bean.getFirstname());
		st.setString(2, bean.getLastname());
		st.setString(3, bean.getContact());
		st.setString(4, bean.getAddress());
		st.setString(5, bean.getPincode());
		rs=st.execute();
		st.close();
		con.close();
		return rs;
	}
	catch (Exception e)
	{
		e.printStackTrace();
		System.out.println("Model_info-> addprofile()");
	}
	return rs;
}

}
