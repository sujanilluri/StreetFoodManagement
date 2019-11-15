package com.sfm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.bean.Shops;
import com.sfm.dao.VendorDao;
import com.sfm.dao.impl.VendorDaoImpl;

/**
 * Servlet implementation class VendorOne
 */
@WebServlet("/VendorOne")
public class VendorView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno=Integer.parseInt(request.getParameter("sno"));
		Shops s=null;
		VendorDao impl=new VendorDaoImpl();
		s=impl.viewShop(sno);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<div>");
		request.getRequestDispatcher("Header.html").include(request, response);;
		pw.println("</div>");
		pw.println("<div>");
		pw.println("<head><style>th, td {  border-bottom: 1px solid #ddd;} th{color:white; background-color:'black';}</style></head>");
		pw.println("<table cellpadding='10px'>");
		pw.println("<tr><th>SNO</th><th>SHOP NAME</th><th>SHOP ADDR</th><th>SHOP NUM</th><th>SHOP EMAIL</th><th>VEN ID</th><th>VEN NAME</th><th>AGE</th><th>GENDER</th><th>VEN NUM</th><th>ITEMNO</th><th>ITEMNAME</th><th>PRICE</th><th>TYPE</TH><TH colspan='2'>"+"<a href=AdminViewAll>ViewAll</a>"+"</TH></TR>");
		if(s!=null)
		{
		
			pw.println("<tr><td>"+s.getSno()+"</td><td>"+s.getShopName()+"</td><td>"+s.getShopAdd()+"</td><td>"+s.getContact()+"</td><td>"+s.getEmail()+"</td><td>"+s.getVenId()+"</td><td>"+s.getVenName()+"</td><td>"+s.getAge()+"</td><td>"+s.getGender()+"</td><td>"+s.getMobile()+"</td><td>"+s.getItemName()+"</td><td>"+s.getItemPrice()+"</td></tr></table>");
		}	
		pw.println("</table>");
		pw.println("</div>");
		pw.println("<div>");
		request.getRequestDispatcher("Footer.html").include(request, response);;
		pw.println("</div>");
	}

}
