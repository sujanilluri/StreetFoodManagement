package com.sfm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.bean.Cart;
import com.sfm.bean.Shops;
import com.sfm.dao.UserDao;
import com.sfm.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class ViewCart
 */
@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		double gt=0;
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		UserDao imp=new UserDaoImpl();
		List<Cart> view=imp.ViewCart();
		pw.println("<div>");
		request.getRequestDispatcher("Header.html").include(request, response);;
		pw.println("</div>");
		pw.println("<div>");
		//pw.println("<table border='3px' bgcolor='green' cellspacing='8px' cellpadding='5px' align='center'>");
		pw.println("<head><style>th, td {  border-bottom: 1px solid #ddd;} th{color:white; background-color:'black';}</style></head>");
		pw.println("<table cellpadding='20px' cellspacing='10' align='center' width='900px'>");
		pw.println("<tr><th>SHOP NAME</th><th>SHOP ADDR</th><th>ItemName</th><th>ItemPrice</th><th>Qty</th><th>Total</th><th>UserName</th><th>UserADD</th></TR>");
			for (Cart s:view){
			//System.out.println(s.getSno()+"\t"+s.getShopName()+"\t"+s.getShopAdd()+"\t"+s.getContact()+"\t"+s.getEmail()+"\t"+s.getVenId()+"\t"+s.getVenName()+"\t"+s.getAge()+"\t"+s.getGender()+"\t"+s.getMobile()+"\t"+s.getItemno()+"\t"+s.getItemName()+"\t"+s.getItemPrice()+"\t"+s.getType());
		
			pw.println("<tr style='color:#ffffcc' bgcolor='#4d4d00'><td>"+s.getShopName()+"</td><td>"+s.getShopAdd()+"</td><td>"+s.getItemName()+"</td><td>"+s.getItemPrice()+"</td><td>"+s.getQty()+"</td><td>"+s.getTotal()+"</td><td>"+s.getUname()+"</td><td>"+s.getUadd()+"</td>");
			//pw.println("<td>"+"<a href=CDeleteServlet?sno="+s.getSno()+">Delete</a>"+"</td><td>"+"<a href=CUpdateServlet?itemno="+s.getItemno()+">Update</a>"+"</td></tr>");
			pw.println("<td>"+"<a href=DeleteCart?>Delete</a>");
			gt=gt+s.getTotal();
			//pw.println("<td>shop no:</td>"+"<td><input type='text' name=sno value="+s.getSno()+"</td>");
			//pw.println("<td>"+"<input type=\"button\" value=\"DeleteCart\" onclick=\"impl.delCart(s.getItemno)\">"+"</td>");
			pw.println("</tr>");
		}
			
			pw.println("<tr><td colspan='5' align='right'>GrandTotal</td><td>"+gt+"</td></tr>");
			pw.println("<tr><td colspan='8' align='center'>"+"<a href='OrderPlaced' background-color='blue'><h2>PlaceOrder</h2></a>"+"</td></tr>");
			pw.println("</table>");
			pw.println("</div>");
			pw.println("<div>");
			request.getRequestDispatcher("Footer.html").include(request, response);;
			pw.println("</div>");
			
	}

}
