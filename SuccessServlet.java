package com.of.apex.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.of.apex.practice.MYSQLDBAccess;

/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MYSQLDBAccess mdb = new MYSQLDBAccess();
		try {
			ResultSet rs_cf = mdb.getContactInfo();
			ResultSet rs_pi = mdb.getPersonalInfo();
			ResultSet rs_bf = mdb.getBankInfo();
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("-----------------------------------------------------------" + "<br>");
			pw.println("FirstName    "  + "	   LastName" + "   Gender" + "<br>");
			while(rs_pi.next())
			{
			pw.println(rs_pi.getString(1)+"|	"+rs_pi.getString(2) + "|	" + rs_pi.getString(3) + "|<br>");
			}
			pw.println("--------------------------------------------------------------------<br>");
			pw.println("Address     "+ "    City " +"     State" +"    Country"+"    Phone Number" + "<br>");
			while(rs_cf.next())
			{
			pw.println(rs_cf.getString(1)+" "+rs_cf.getString(2) + " " + rs_cf.getString(3)+" " + rs_cf.getString(4)+" " +rs_cf.getString(5)+" "+ "<br>");
			}
			pw.println("--------------------------------------------------------------------<br>");
			pw.println("    Bank Name "+ "   Account Number" +"    SSN" + "<br>");
			while(rs_bf.next())
			{
				pw.println(rs_bf.getString(1)+""+rs_bf.getString(2) + " " + rs_bf.getString(3) + "<br>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
