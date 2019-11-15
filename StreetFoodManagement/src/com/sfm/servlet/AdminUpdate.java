package com.sfm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.bean.Shops;
import com.sfm.dao.AdminDao;
import com.sfm.dao.VendorDao;
import com.sfm.dao.impl.AdminDaoImpl;
import com.sfm.dao.impl.VendorDaoImpl;

/**
 * Servlet implementation class AdminUpdate
 */
@WebServlet("/AdminUpdate")
public class AdminUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno=Integer.parseInt(request.getParameter("sno"));
		Shops s=null;
		AdminDao impl=new AdminDaoImpl();
		
		s=impl.viewShop1(sno);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		if(s!=null){
		pw.println("<table border='3px' align='center' bgcolor='#4d4d00' cellspacing='10px' cellpadding='5px'>");
		pw.println("<form action=AdminUpdate1>");
		pw.println("<tr><td>shop no:</td><td><input type='text' name=sno value="+s.getSno()+"></td></tr>");
		pw.println("<tr><td>shop name:</td><td><input type='text' name=shopName value="+s.getShopName()+"></td></tr>");
		pw.println("<tr><td>shop add:</td><td><input type='text'  name=shopAdd value="+s.getShopAdd()+"></td></tr>");
		pw.println("<tr><td>shop contact:</td><td><input type='text'  name=contact value="+s.getContact()+"></td></tr>");
		pw.println("<tr><td>email:</td><td><input type='text' name=email value="+s.getEmail()+"></td></tr>");
		pw.println("<tr><td>ven name:</td><td><input type='text'  name=venName value="+s.getVenName()+"></td></tr>");
		pw.println("<tr><td>mobile:</td><td><input type='text'  name=mobile value="+s.getMobile()+"></td></tr>");
		pw.println("<tr><td><input type='submit' name=submit value=update></td></tr>");
		pw.print("</form></table>");
		}
			
	}

}
