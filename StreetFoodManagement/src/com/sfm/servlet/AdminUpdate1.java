package com.sfm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.dao.impl.AdminDaoImpl;

/**
 * Servlet implementation class AdminUpdate1
 */
@WebServlet("/AdminUpdate1")
public class AdminUpdate1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdate1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		AdminDaoImpl impl=new AdminDaoImpl();
		int count=0;
		RequestDispatcher rd=null;
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		int sno=Integer.parseInt(request.getParameter("sno"));
		String sname=request.getParameter("shopName");
		String sadd=request.getParameter("shopAdd");
		long contact=Long.parseLong(request.getParameter("contact"));
		String email=request.getParameter("email");
		String name=request.getParameter("venName");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		count=impl.updateShop(sname,sadd,contact,email,name,mobile,sno);
		if(count!=0)
		{
		//pw.println("<a href=AdminViewAll>Home</a>");
		pw.println("<tr><td><h1>Successfully updated" +count+"rows</h1></td></tr>");
		//	"<a href=AdminViewAll>VIEW ALL</a>"
			rd=request.getRequestDispatcher("/AdminViewAll");
			rd.include(request, response);
	}
		else
		{
			pw.println("Data not Deleted");
			rd=request.getRequestDispatcher("/AdminViewAll");
			rd.include(request, response);
		}
	}

}
