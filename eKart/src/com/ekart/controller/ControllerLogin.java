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


import com.ekart.model.Model_log;

@WebServlet("/login")
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String useremail;
	String userpass;
	Model_log logM;
	HttpSession session;
	String str;
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					
		ServletContext cd=getServletContext();
		logM.setDbURL(cd.getInitParameter("dbURL"));
		logM.setDbPassword(cd.getInitParameter("dbPassword"));
		logM.setDbUser(cd.getInitParameter("dbUser"));
		logM.setDbDriver(cd.getInitParameter("dbDriver"));
		
				useremail=req.getParameter("email");
				userpass=req.getParameter("pass");
				
				if(logM.validate(useremail, userpass))
				{	
					str=logM.user(useremail, userpass);
					session=req.getSession();
					session.setAttribute("logchk", true);
					session.setAttribute("login", 1);
					session.setAttribute("user", str);
					RequestDispatcher rd=req.getRequestDispatcher("login_succ.jsp");
					rd.forward(req, res);
				}
				else
				{
					session=req.getSession();
					session.setAttribute("logchk", false);
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					rd.forward(req, res);
				
				}
			
			}
	}