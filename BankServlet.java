package com.of.apex.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.of.apex.practice.valueobj.PersonalInformation;


@WebServlet("/bfi")
public class BankServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonalInformation personalInfo=new PersonalInformation();
		String bankname=request.getParameter("bankname");
		String accountnumber=request.getParameter("accountnumber");
		String ssn=request.getParameter("ssn");
		personalInfo.setBankname(request.getParameter("bankname"));
		personalInfo.setAccountnumber(accountnumber);
		personalInfo.setSsn(ssn);
		
		String errors2 = " ";
		MYSQLDBAccess mdb = new MYSQLDBAccess();
		
		//Validation
		if(isBlank(bankname)){
			errors2+="Bankname cannot be empty";
		}
		if(isBlank(accountnumber)) {
			errors2+="Account Number cannot be empty";
		}
		if(isBlank(ssn)) {
			errors2+="SSn cannot be empty";
		}
		

		if(isBlank(errors2)) {	
			try {   //JDBC COnnection 
				Connection dbConn = mdb.getConnection();
				PreparedStatement pStmt = dbConn.prepareStatement("insert into BankInfo values(?, ?, ?)");
				pStmt.setString(1, bankname);
				pStmt.setString(2, accountnumber);
				pStmt.setString(3, ssn);
				pStmt.execute();
				pStmt.close();
				dbConn.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); }
			HttpSession ses=request.getSession();
			ses.setAttribute("pinform2", personalInfo);
			response.sendRedirect("jsp/success3.jsp");
		}	

		else {request.setAttribute("errmsgs2", errors2);
			RequestDispatcher rd=request.getRequestDispatcher("jsp/bankinfo.jsp");
			rd.forward(request, response);

		}
	
	}
		private boolean isBlank(String fieldname2) {
			return fieldname2==null||fieldname2.trim().length()==0;
	}
		
	

}
		
		

