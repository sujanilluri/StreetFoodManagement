package com.sfm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sfm.dao.impl.VendorDaoImpl;

/**
 * Servlet implementation class VendorUpdate1
 */
@WebServlet("/VendorUpdate1")
public class VendorUpdate1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorUpdate1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		VendorDaoImpl impl=new VendorDaoImpl();
		int count=0;
		RequestDispatcher rd=null;
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		int vid=Integer.parseInt(request.getParameter("vid"));
		String vname=request.getParameter("vname");
		String age=request.getParameter("age");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String gen=request.getParameter("gender");
		String iname=request.getParameter("itemname");
		double price=Double.parseDouble(request.getParameter("price"));
		String type=request.getParameter("type");
		int ino=Integer.parseInt(request.getParameter("itno"));
		count=impl.updateShop(vid,vname,age,gen,mobile,iname,price,type,ino);
		if(count!=0)
		{
		//pw.println("<a href=AdminViewAll>Home</a>");
		pw.println("<tr><td><h1>Successfully updated" +count+"rows</h1></td></tr>");
		//	"<a href=AdminViewAll>VIEW ALL</a>"
			rd=request.getRequestDispatcher("/ViewAll");
			rd.include(request, response);
	}
		else
		{
			pw.println("Data not Deleted");
			rd=request.getRequestDispatcher("/ViewAll");
			rd.include(request, response);
		}
	}
	

}
