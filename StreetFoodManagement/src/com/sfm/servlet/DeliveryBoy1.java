package com.sfm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeliveryBoy1
 */
@WebServlet("/DeliveryBoy1")
public class DeliveryBoy1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryBoy1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=null;
		PrintWriter pw=response.getWriter();
		
		pw.println("<table border='3px' align='center' bgcolor='green' cellspacing='8px' cellpadding='5px'>");
		
			pw.println("<tr><td><h1>Successfully Delivered : row</h1></td></tr></table>");
		//	"<a href=AdminViewAll>VIEW ALL</a>"
			rd=request.getRequestDispatcher("/DeliveryBoy");
			rd.include(request, response);
	

}
}
