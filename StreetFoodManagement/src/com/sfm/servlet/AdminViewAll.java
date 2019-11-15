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

import com.sfm.bean.Shops;
import com.sfm.dao.AdminDao;
import com.sfm.dao.impl.AdminDaoImpl;

/**
 * Servlet implementation class AdminViewAll
 */
@WebServlet("/AdminViewAll")
public class AdminViewAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		AdminDao impl=new AdminDaoImpl();
		HttpSession session=request.getSession(false);
		String email=(String) session.getAttribute("a");
		pw.println(email);
		List<Shops>viewShops=impl.viewAllShops();
		System.out.println(viewShops);
		response.setContentType("text/html");
		
		pw.println("<head><style>th, td {  border-bottom: 1px solid #ddd;} th{color:white; background-color:'black';}</style></head>");
		pw.println("<div>");
		request.getRequestDispatcher("Header.html").include(request, response);;
		pw.println("</div>");
		pw.println("<div>");
		pw.println("<table cellpadding='10px'>");
		pw.println("<tr><th>SNO</th><th>SHOP NAME</th><th>SHOP ADDR</th><th>SHOP NUM</th><th>SHOP EMAIL</th><th>VEN ID</th><th>VEN NAME</th><th>AGE</th><th>GENDER</th><th>VEN NUM</th><th>ITEMNO</th><th>ITEMNAME</th><th>PRICE</th><th>TYPE</TH>");
		pw.println("<th><form action='AdminViewShop' method='post'>"+"<input type='text' placeholder='Search' name='sno'>"+"</th><th>"+"<input type='submit' value='search'>"+"</form></th></tr>");
		for(Shops s:viewShops)
		{
			
			
			//System.out.println(s.getSno()+"\t"+s.getShopName()+"\t"+s.getShopAdd()+"\t"+s.getCotact()+"\t"+s.getEmail()+"\t"+s.getVenId()+"\t"+s.getVenName()+"\t"+s.getAge()+"\t"+s.getGender()+"\t"+s.getMobile()+"\t"+s.getItemno()+"\t"+s.getItemName()+"\t"+s.getItemPrice()+"\t"+s.getType());
			pw.println("<tr><td>"+s.getSno()+"</td><td>"+s.getShopName()+"</td><td>"+s.getShopAdd()+"</td><td>"+s.getContact()+"</td><td>"+s.getEmail()+"</td><td>"+s.getVenId()+"</td><td>"+s.getVenName()+"</td><td>"+s.getAge()+"</td><td>"+s.getGender()+"</td><td>"+s.getMobile()+"</td><td>"+s.getItemno()+"</td><td>"+s.getItemName()+"</td><td>"+s.getItemPrice()+"</td><td>"+s.getType()+"</td>");
			pw.println("<td>"+"<a href=AdminDelete?sno="+s.getSno()+">Delete</a>"+"</td><td>"+"<a href=AdminUpdate?sno="+s.getSno()+">Update</a>"+"</td></tr>");
		}
		pw.println("</table>");
		pw.println("</div>");
		pw.println("<div>");
		request.getRequestDispatcher("Footer.html").include(request, response);;
		pw.println("</div>");
	}

}
