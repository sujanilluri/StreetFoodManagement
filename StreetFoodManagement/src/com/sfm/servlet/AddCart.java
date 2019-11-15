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

import com.sfm.bean.Cart;
import com.sfm.bean.Shops;
import com.sfm.dao.UserDao;
import com.sfm.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Shops s=null;
		int item=Integer.parseInt(request.getParameter("itemno"));
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		String email=(String) session.getAttribute("u");
		PrintWriter pw=response.getWriter();
		UserDao imp=new UserDaoImpl();
		s=imp.shopItem(item);
		pw.println("<table border='3px' align='center' bgcolor='#4d4d00' cellspacing='10px' cellpadding='5px'>");
		pw.println("<form action=AddCart1>");
		pw.println("<tr><th>SHOP NAME</th><th>SHOP ADDR</th><th>ItemName</th><th>ItemPrice</th><th>Qty</th><th>UserName</th><th>UserADD</th></TR>");
		if(s!=null)
		{
			
			
			
			pw.println("<tr><td><input type='text' readonly name=shopName value="+s.getShopName()+"></td>");
			pw.println("<td><input type='text' readonly name=shopAdd value="+s.getShopAdd()+"></td>");
			pw.println("<td><input type='text' readonly name=ItemName value="+s.getItemName()+"></td>");
			pw.println("<td><input type='text' readonly name=price value="+s.getItemPrice()+"></td>");
			pw.println("<td><input type='text'  name=qty value="+1+"></td>");
			//pw.println("<tr><td>Total:</td><td><input type='text'  name=tt value="+s.getMobile()+"></td></tr>");
			pw.println("<td><input type='text' name=name value="+email+"></td>");
			pw.println("<td><input type='text'  name=add value="+""+"></td>");
			pw.println("<td><input type='submit' name=submit value=Add></td></tr>");
			pw.print("</form></table>");
		}
		

	}

}
