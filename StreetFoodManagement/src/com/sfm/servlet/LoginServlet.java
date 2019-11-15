package com.sfm.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sfm.dao.impl.LoginDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email =request.getParameter("username");
		String pass=request.getParameter("password");
		System.out.println(email+"\t"+pass);
		PrintWriter pw=response.getWriter();
		RequestDispatcher rd=null;
		ServletContext sc = getServletContext();
		LoginDaoImpl lg=new LoginDaoImpl();
		 HttpSession session=request.getSession();
		
		
		/*	if(email.equals("sujan.illuri@gmail.com")&pass.equals("sujan"))
			{
				rd=sc.getRequestDispatcher("/AdminImpl.html");
				rd.forward(request, response);
				
			}*/
			if (lg.login(email, pass))
			{
				 if(lg.type.equals("admin"))
					{
					session.setAttribute("a",email);
						// response.addCookie(ck);
					
						rd=sc.getRequestDispatcher("/AdminViewAll");
						rd.forward(request, response);
						
					}
				 else if(lg.type.equals("vendor"))
			{
					
					 session.setAttribute("v",email);
				// response.addCookie(ck);
				rd=sc.getRequestDispatcher("/ViewAll");
				rd.forward(request, response);
				
			}
			else if(lg.type.equals("user"))
			{
				session.setAttribute("u",email);
				//response.addCookie(ck);
				rd=sc.getRequestDispatcher("/UserViewAll");
				rd.forward(request, response);
				
			}
			
			
		else{
			 session.setAttribute("d",email);
			//response.addCookie(ck);
			rd=request.getRequestDispatcher("/DeliveryBoy");
			rd.forward(request, response);
		}
		}
		else 
		{

			pw.println("invalid credentials");
			rd=request.getRequestDispatcher("/Login.html");
			rd.include(request, response);
		}
		
		
		
		
		
	
	}

	

}
