package com.sfm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.bean.Shops;
import com.sfm.dao.UserDao;
import com.sfm.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class UserView
 */
@WebServlet("/UserView")
public class UserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String SName=request.getParameter("sname");
		
		UserDao impl=new UserDaoImpl();
		List<Shops> view=impl.viewshops(SName);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		//pw.println("<table border=3px");
		pw.println("<div>");
		request.getRequestDispatcher("Header.html").include(request, response);;
		pw.println("</div>");
		pw.println("<div>");
		pw.println("<head><style>th, td {  border-bottom: 1px solid #ddd;} th{color:white; background-color:'black';}</style></head>");
		pw.println("<table cellpadding='10px'>");
		pw.println("<tr><th>SNO</th><th>SHOP NAME</th><th>SHOP ADDR</th><th>SHOP NUM</th><th>SHOP EMAIL</th><th>VEN ID</th><th>VEN NAME</th><th>AGE</th><th>GENDER</th><th>VEN NUM</th><th>ITEMNO</th><th>ITEMNAME</th><th>PRICE</th><th>TYPE</TH><TH colspan='2'>"+"<a href=UserViewAll>ViewAll</a>"+"</TH></TR>");
		
		for(Shops s:view){
			System.out.println((s).getSno()+"\t"+s.getShopName()+"\t"+s.getShopAdd()+"\t"+s.getContact()+"\t"+s.getEmail()+"\t"+s.getVenId()+"\t"+s.getVenName()+"\t"+s.getAge()+"\t"+s.getGender()+"\t"+s.getMobile()+"\t"+s.getItemno()+"\t"+s.getItemName()+"\t"+s.getItemPrice()+"\t"+s.getType());
		
			pw.println("<tr><td>"+s.getSno()+"</td><td>"+s.getShopName()+"</td><td>"+s.getShopAdd()+"</td><td>"+s.getContact()+"</td><td>"+s.getEmail()+"</td><td>"+s.getVenId()+"</td><td>"+s.getVenName()+"</td><td>"+s.getAge()+"</td><td>"+s.getGender()+"</td><td>"+s.getMobile()+"</td><td>"+s.getItemno()+"</td><td>"+s.getItemName()+"</td><td>"+s.getItemPrice()+"</td><td>"+s.getType()+"</td>");
			//pw.println("<td>"+"<a href=CDeleteServlet?sno="+s.getSno()+">Delete</a>"+"</td><td>"+"<a href=CUpdateServlet?itemno="+s.getItemno()+">Update</a>"+"</td></tr>");
		
			pw.println("<td>"+"<a href=AddCart?itemno="+s.getItemno()+">AddCart</a>"+"</td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.println("</div>");
		pw.println("<div>");
		request.getRequestDispatcher("Footer.html").include(request, response);;
		pw.println("</div>");
	}

}
