package com.sfm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.bean.Cart;
import com.sfm.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class AddCart1
 */
@WebServlet("/AddCart1")
public class AddCart1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		UserDaoImpl impl=new UserDaoImpl();
		int count=0;
		RequestDispatcher rd=null;
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		int id=impl.getorid();
		int orid=id+1;
		System.out.println(orid+"\t"+id);
		String sname=request.getParameter("shopName");
		String sadd=request.getParameter("shopAdd");
		String iname=request.getParameter("ItemName");
		Double price=Double.parseDouble(request.getParameter("price"));
		int qty=Integer.parseInt(request.getParameter("qty"));
		Double total=price*qty;
		String name=request.getParameter("name");
		String add=request.getParameter("add");
		
		Cart c=new Cart(orid,sname,sadd,iname,price,qty,total,name,add);
		impl.cartitem.add(c);
		
		if(impl.cartitem!=null)
		{
		//pw.println("<a href=AdminViewAll>Home</a>");
		pw.println("<tr align='center'><td><h1>Successfully Item Added to Cart"+"</h1></td></tr>");
		//	"<a href=AdminViewAll>VIEW ALL</a>"
		
			rd=request.getRequestDispatcher("/UserViewAll");
			rd.include(request, response);
	}
		else
		{
			pw.println("Data not Deleted");
			rd=request.getRequestDispatcher("/UserViewAll");
			rd.include(request, response);
		}
	}
	
	

}
