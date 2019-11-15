package com.sfm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.dao.AdminDao;
import com.sfm.dao.VendorDao;
import com.sfm.dao.impl.AdminDaoImpl;
import com.sfm.dao.impl.VendorDaoImpl;

/**
 * Servlet implementation class VendorDelete
 */
@WebServlet("/VendorDelete")
public class VendorDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int sno=Integer.parseInt(request.getParameter("itemno"));
		
		VendorDao impl=new VendorDaoImpl();
		int count=impl.deleteShop(sno);
		RequestDispatcher rd=null;
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.println("<table border='3px' align='center' bgcolor='green' cellspacing='8px' cellpadding='5px'>");
		if(count!=0)
		{
			pw.println("<tr><td><h1>Successfully deleted :" +count+" row</h1></td></tr>");
		//	"<a href=AdminViewAll>VIEW ALL</a>"
			rd=request.getRequestDispatcher("/ViewAll");
			rd.include(request, response);
		}
		else
		{
			pw.println("Data not Deleted");
			rd=request.getRequestDispatcher("/ViewAll");
			rd.include(request, response);
			
			//pw.println("<a href=AdminViewAll>VIEW ALL</a>");
			
		}
		
	}

}
