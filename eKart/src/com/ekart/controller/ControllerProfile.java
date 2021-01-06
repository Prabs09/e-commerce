package com.ekart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
			
		HttpSession session= request.getSession();
		String email=(String) session.getAttribute("email");
		infoB=infoM.getprofile(email);
		session.setAttribute("info", infoB);
		RequestDispatcher rd=request.getRequestDispatcher("showprofile.jsp");
		rd.forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
