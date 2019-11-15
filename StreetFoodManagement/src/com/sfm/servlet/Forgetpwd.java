package com.sfm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.dao.impl.LoginDaoImpl;

/**
 * Servlet implementation class Forgetpwd
 */
@WebServlet("/Forgetpwd")
public class Forgetpwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgetpwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=response.getWriter();
		LoginDaoImpl impl=new LoginDaoImpl();
		RequestDispatcher rd=null;
		response.setContentType("text/html");
		int s=0;
		pw.println("<head><style>th, td { border-bottom: 3px solid #ddd;color:white;} th{color:white; background-color:'black';} body{background-image: url('./img/pwd.gif');background-repeat: no-repeat;background-size: 100% 100%;}</style></head>");
		pw.println("<table align='center' cellspacing='20px' cellpadding='10px'>");
		pw.println("<form action=Forgetpwd1>");
		pw.println("<tr><td colspan='2'><h2>Please Use Your Email To Reset Your Password</h2></td></tr>");
		
		pw.println("<tr><td><h3>Email:</h3></td><td><input type='text' name='email'></td></tr>");
		pw.println("<tr><td colspan='2'><h2>Please Enter Your New Password</h2></td></tr>");
		pw.println("<tr><td><h3>New Password:</h3></td><td><input type='text' name='pwd'></td></tr>");
		
		pw.println("<tr><td colspan='2' align='center'><input type='submit' name=submit value=update></td></tr>");
		pw.println("</form></table>");
		
		
	}

}
