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
 * Servlet implementation class Addshop
 */
@WebServlet("/Addshop")
public class VendorAddshop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorAddshop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno=Integer.parseInt(request.getParameter("sno"));
		String sname=request.getParameter("shopname");
		String Add=request.getParameter("sadd");
		long contact=Long.parseLong(request.getParameter("contact"));
		String em=request.getParameter("email");
		int vid=Integer.parseInt(request.getParameter("vid"));
		String vname=request.getParameter("vname");
		int ag=Integer.parseInt(request.getParameter("age"));
		String gen=request.getParameter("gender");
		long mb=Long.parseLong(request.getParameter("mob"));
		int ino=Integer.parseInt(request.getParameter("itno"));
		String iname=request.getParameter("itemname");
		double pr=Double.parseDouble(request.getParameter("price"));
		String tp=request.getParameter("type1");
		PrintWriter pw=response.getWriter();
	
		
		Shops s=new Shops(sno,sname,Add,contact,em,vid,vname,ag,gen,mb,ino,iname,pr,tp);
		VendorDao Impl=new VendorDaoImpl();
		int count=Impl.addShop(s);
		if(count!=0)
		{
			pw.println("data inserted");
			pw.println("<a href=>HOME</a>");
			//pw.println("<a href="ViewServlet.java">VIEW</a>");
		}
		else
			pw.println("not inserted");
		
	}

}
