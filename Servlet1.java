package com.mvc_login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.logindao;
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Servlet1() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();

		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		logindao dao=new logindao();
		if(dao.check(uname, pass))
		{
			out.println("Your name is: " +uname);
			out.println("Welcome" +uname);
				out.println("Your password is: " +pass);
				HttpSession session=request.getSession();
				session.setAttribute("username", uname); 
			response.sendRedirect("welcome.jsp");
		}
		else
		{
			out.println("INCORRECT USERNAME OR P/W");
			//	response.sendRedirect("login.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
			rd.include(request, response);
		}
	}

}

