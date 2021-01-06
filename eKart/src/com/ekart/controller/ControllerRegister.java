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

import com.ekart.bean.*;
import com.ekart.model.Model_log;


@WebServlet("/register")
public class ControllerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
   Model_log logM;
   Bean_log logB;
   private int inschk=0;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletContext ct=getServletContext();
		logM.setDbDriver(ct.getInitParameter("dbDriver"));
		logM.setDbURL(ct.getInitParameter("dbURL"));
		logM.setDbUser(ct.getInitParameter("dbUser"));
		logM.setDbPassword(ct.getInitParameter("dbPassword"));
		
		logB.setUser(req.getParameter("user"));
		logB.setEmail(req.getParameter("email"));
		logB.setPassword(req.getParameter("pass"));
		String useremail=req.getParameter("email");
		inschk=logM.create(logB);
		if(inschk==1)
		{
			HttpSession session=req.getSession();
			session.setAttribute("reg", true);
			session.setAttribute("login", "1");
			session.setAttribute("email", useremail);
			RequestDispatcher rd=req.getRequestDispatcher("login_succ.jsp");
			rd.forward(req, res);
		}
		else
		{	
			req.setAttribute("reg", false);
			RequestDispatcher rd=req.getRequestDispatcher("homepage.jsp");
			rd.forward(req, res);
		}
		
	}

}
