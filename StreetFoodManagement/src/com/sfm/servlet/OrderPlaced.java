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
import com.sfm.dao.UserDao;
import com.sfm.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class OrderPlaced
 */
@WebServlet("/OrderPlaced")
public class OrderPlaced extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderPlaced() {
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
		UserDaoImpl impl=new UserDaoImpl();
		response.setContentType("text/html");
		RequestDispatcher rd=null;
		
		int count=0;
		for(Cart c:impl.cartitem)
		{
			System.out.println();
		count=impl.AddCart(c.getOrid(),c.getShopName(),c.getShopAdd(),c.getItemName(),c.getItemPrice(),c.getQty(),c.getTotal(),c.getUname(),c.getUadd());
			
		}
		
		
		if(count!=0){
			pw.println("<head><style>img{ margin-left:300px;} </style></head>");
			pw.println("<tr><td><h1 align='center'>Successfully Your Order Was Placed</h1></td></tr>");
			pw.println("<img alt='delivery' src='./img/delivery-boy.gif' width='auto' height='500px'/><br>");
			
			
			pw.println("<tr><td><h1 align='center'><a href=UserViewAll>Order Again</a><h1></td></tr>");
				//rd=request.getRequestDispatcher("/ViewCart");
				//rd.include(request, response);
			
		}
		else
		{
			pw.println("<tr><td><h1 align='center'>Oredr not Placed Yet</h1></td></tr>");
			rd=request.getRequestDispatcher("/ViewCart");
			rd.include(request, response);
			
			//pw.println("<a href=AdminViewAll>VIEW ALL</a>");
			
		}
	}

}
