package com.sfm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.tomcat.util.http.parser.Cookie;

import com.sfm.bean.Shops;
import com.sfm.dao.VendorDao;
import com.sfm.dao.impl.VendorDaoImpl;


/**
 * Servlet implementation class ViewAll
 */
@WebServlet("/ViewAll")
public class VendorViewAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorViewAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VendorDao impl=new VendorDaoImpl();
		HttpSession session=request.getSession(false);
		String email=(String) session.getAttribute("v");
		//String email="sl@gmail.com";
		System.out.println(email);
		List<Shops>viewShops=impl.viewAllShops(email);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<div>");
		request.getRequestDispatcher("Header.html").include(request, response);
		pw.println("<a href='AddShop.html'><h3>AddShop</h3></a>");
		pw.println("</div>");
		pw.println("<div>");
		pw.println("<head><style>th, td {  border-bottom: 1px solid #ddd;} th{color:white; background-color:'black';}</style></head>");
		pw.println("<table cellpadding='10px'>");
		
		
		
		pw.println("<tr><th>SNO</th><th>SHOP NAME</th><th>SHOP ADDR</th><th>SHOP NUM</th><th>SHOP EMAIL</th><th>VEN ID</th><th>VEN NAME</th><th>AGE</th><th>GENDER</th><th>VEN NUM</th><th>ITEMNO</th><th>ITEMNAME</th><th>PRICE</th><th>TYPE</TH>");
		pw.println("<th><form action='VendorOne' method='post'>"+"<input type='text' placeholder='Search' name='sno'>"+"</th><th>"+"<input type='submit' value='search'>"+"</form></th></tr>");
		for(Shops s:viewShops)
		{
			pw.println("<tr><td>"+s.getSno()+"</td><td>"+s.getShopName()+"</td><td>"+s.getShopAdd()+"</td><td>"+s.getContact()+"</td><td>"+s.getEmail()+"</td><td>"+s.getVenId()+"</td><td>"+s.getVenName()+"</td><td>"+s.getAge()+"</td><td>"+s.getGender()+"</td><td>"+s.getMobile()+"</td><td>"+s.getItemno()+"</td><td>"+s.getItemName()+"</td><td>"+s.getItemPrice()+"</td><td>"+s.getType()+"</td>");
			pw.println("<td>"+"<a href=VendorDelete?itemno="+s.getItemno()+">Delete</a>"+"</td><td>"+"<a href=VendorUpdate?itemno="+s.getItemno()+">Update</a>"+"</td></tr>");
		}
		pw.println("</table>");
		pw.println("</div>");
		pw.println("<div>");
		request.getRequestDispatcher("Footer.html").include(request, response);;
		pw.println("</div>");
	}

}
