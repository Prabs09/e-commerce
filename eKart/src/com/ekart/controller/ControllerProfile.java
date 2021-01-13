package com.ekart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ekart.bean.Bean_info;
import com.ekart.model.Model_info;

@WebServlet("/profile")
public class ControllerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Bean_info infoB;
	private Model_info infoM;
	boolean chk;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		infoM=new Model_info();
		ServletContext cg=getServletContext();
		infoM.setDbDriver(cg.getInitParameter("dbDriver"));
		infoM.setDbUser(cg.getInitParameter("dbUser"));
		infoM.setDbURL(cg.getInitParameter("dbURL"));
		infoM.setDbPassword(cg.getInitParameter("dbPassword"));
		
		HttpSession session= request.getSession(false);
		String str=(String) session.getAttribute("user");
		System.out.println(str);
		infoB=infoM.getprofile(str);
		session.setAttribute("info", infoB);
		RequestDispatcher rd=request.getRequestDispatcher("/showprofile.jsp");
		rd.forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		infoB=new Bean_info();
		infoM=new Model_info();
		infoB.setAddress(request.getParameter("address"));
		infoB.setContact(request.getParameter("contact"));
		infoB.setFirstname(request.getParameter("fname"));
		infoB.setLastname(request.getParameter("lname"));
		infoB.setPincode(request.getParameter("pincode"));
		chk=infoM.addprofile(infoB);
		if(chk)
		{
			RequestDispatcher rd= request.getRequestDispatcher("login_succ.jsp");
			rd.forward(request, response);
		}
	}
}
