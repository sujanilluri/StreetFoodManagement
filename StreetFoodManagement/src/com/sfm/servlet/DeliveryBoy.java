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
import com.sfm.dao.DeliveryDao;
import com.sfm.dao.impl.DeliveryDaoImpl;

/**
 * Servlet implementation class DeliveryBoy
 */
@WebServlet("/DeliveryBoy")
public class DeliveryBoy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryBoy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		double gt=0;
		PrintWriter pw=response.getWriter();
		DeliveryDao imp=new DeliveryDaoImpl();
		List<Cart> view=imp.viewOrders();
		pw.println("<table border='3px'  cellspacing='8px' cellpadding='5px' align='center'>");
		pw.println("<tr><th>SHOP NAME</th><th>SHOP ADDR</th><th>ItemName</th><th>ItemPrice</th><th>Qty</th><th>Total</th><th>UserName</th><th>UserADD</th></TR>");
			for (Cart s:view){
			//System.out.println(s.getSno()+"\t"+s.getShopName()+"\t"+s.getShopAdd()+"\t"+s.getContact()+"\t"+s.getEmail()+"\t"+s.getVenId()+"\t"+s.getVenName()+"\t"+s.getAge()+"\t"+s.getGender()+"\t"+s.getMobile()+"\t"+s.getItemno()+"\t"+s.getItemName()+"\t"+s.getItemPrice()+"\t"+s.getType());
		
			pw.println("<tr style='color:#ffffcc' bgcolor='#4d4d00'><td>"+s.getShopName()+"</td><td>"+s.getShopAdd()+"</td><td>"+s.getItemName()+"</td><td>"+s.getItemPrice()+"</td><td>"+s.getQty()+"</td><td>"+s.getTotal()+"</td><td>"+s.getUname()+"</td><td>"+s.getUadd()+"</td>");
			//pw.println("<td>"+"<a href=CDeleteServlet?sno="+s.getSno()+">Delete</a>"+"</td><td>"+"<a href=CUpdateServlet?itemno="+s.getItemno()+">Update</a>"+"</td></tr>");
			gt=gt+s.getTotal();
			//pw.println("<td>shop no:</td>"+"<td><input type='text' name=sno value="+s.getSno()+"</td>");
			//pw.println("<td>"+"<input type=\"button\" value=\"DeleteCart\" onclick=\"impl.delCart(s.getItemno)\">"+"</td>");
			pw.println("</tr>");
		}
			
			pw.println("<tr><td colspan='5' align='right'>GrandTotal</td><td>"+gt+"</td><td>"+"<a href='DeliveryBoy1'>Delivered</a>"+"</td></tr>");
	}

}
