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
 * Servlet implementation class VendorUpdate
 */
@WebServlet("/VendorUpdate")
public class VendorUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemno=Integer.parseInt(request.getParameter("itemno"));
		Shops s=null;
		VendorDao impl=new VendorDaoImpl();
		
		s=impl.viewShop(itemno);
		System.out.println(s);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		if(s!=null)
		{
		
			pw.println("<table border='3px' align='center' bgcolor='#4d4d00' cellspacing='10px' cellpadding='5px'>");
			pw.println("<form action=VendorUpdate1>");
			pw.println("<tr><td>VenId:</td><td><input type='text'  name=vid value="+s.getVenId()+"></td></tr>");
			pw.println("<tr><td>Vendor Name:</td><td><input type='text' name=vname value="+s.getVenName()+"></td></tr>");
			pw.println("<tr><td>Age:</td><td><input type='text'  name=age value="+s.getAge()+"></td></tr>");
			pw.println("<tr><td>Vendor contact:</td><td><input type='text'  name=mobile value="+s.getMobile()+"></td></tr>");
			pw.println("<tr><td>Gender:</td><td><input type='text' name=gender value="+s.getGender()+"></td></tr>");
			pw.println("<tr><td>Item Name:</td><td><input type='text'  name=itemname value="+s.getItemName()+"></td></tr>");
			pw.println("<tr><td>Price:</td><td><input type='text'  name=price value="+s.getItemPrice()+"></td></tr>");
			pw.println("<tr><td>Type:</td><td><input type='text'  name=type value="+s.getType()+"></td></tr>");
			pw.println("<tr><td>ItemNo:</td><td><input type='text'  name=itno value="+s.getItemno()+"></td></tr>");
			pw.println("<tr><td><input type='submit' name=submit value=update></td></tr>");
			pw.print("</form></table>");
		
		
			//pw.println("<tr><td>"+s.getSno()+"</td><td>"+s.getShopName()+"</td><td>"+s.getShopAdd()+"<td></td>"+s.getCotact()+"<td></td>"+s.getEmail()+"</td><td>"+s.getVenId()+"<td></td>"+s.getVenName()+"<td></td>"+s.getAge()+"<td></td>"+s.getGender()+"<td></td>"+s.getMobile()+"<td></td>"+s.getItemName()+"</td><td>"+s.getItemPrice()+"<td></td></tr>");
		
	}
	}

}
