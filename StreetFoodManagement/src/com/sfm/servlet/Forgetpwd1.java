package com.sfm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.dao.impl.LoginDaoImpl;

/**
 * Servlet implementation class Forgetpwd1
 */
@WebServlet("/Forgetpwd1")
public class Forgetpwd1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgetpwd1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int s=0;
		PrintWriter pw=response.getWriter();
		LoginDaoImpl impl=new LoginDaoImpl();
		RequestDispatcher rd=null;
		response.setContentType("text/html");
		String email=request.getParameter("email");
		String p=request.getParameter("pwd");
		
		s=impl.forgotpwd(email,p);
		if(s!=0)
		{
			pw.println(" <h2 align='center'>***your password was updated***</h2>");
			rd=request.getRequestDispatcher("/Login.html");
			rd.include(request, response);
			
		}
		else
		{
			pw.println(" your password was not updated");
			rd=request.getRequestDispatcher("/Login.html");
			rd.include(request, response);
			
		}
		
		
	}

}
