package com.sfm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.bean.Register;
import com.sfm.dao.impl.LoginDaoImpl;
import com.sfm.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		LoginDaoImpl impl=new LoginDaoImpl();
		PrintWriter pw=response.getWriter();
		int sno=Integer.parseInt(request.getParameter("sno"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String type=request.getParameter("type");
		
		Register r=new Register(sno,name,email,password,type);
		RequestDispatcher rd=null;
		int count=impl.RegisterImpl(r);
		if(count!=0){
			pw.println("<h2 align='center' color='red'>user successfully registered</h2>");
			rd=request.getRequestDispatcher("/Login.html");
			rd.include(request, response);
		}else{
				pw.println("user not registered");
				
		}
	}
	

}
