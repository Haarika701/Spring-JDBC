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


@WebServlet("/Cfi")
public class ContactServlet extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonalInformation personalInfo=new PersonalInformation();
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String phonenumber=request.getParameter("phonenumber");
		personalInfo.setAddress(request.getParameter("address"));
		personalInfo.setCity(city);
		personalInfo.setState(state);
		personalInfo.setCountry(country);
		personalInfo.setPhonenumber(phonenumber);
		String errors1 = " ";
		
		
		// Validation
		if(isBlank(address)){
			errors1+="Address cannot be empty";
		}
		if(isBlank(city)) {
			errors1+="City cannot be empty";
		}
		if(isBlank(state)) {
			errors1+="State cannot be empty";
		}
		if(isBlank(country)){
			errors1+="Country cannot be empty";
		}
		if(isBlank(phonenumber)) {
			errors1+="Phone number cannot be empty";
		}

		if(isBlank(errors1)) {
			MYSQLDBAccess mdb = new MYSQLDBAccess();
			try {                                    //JDBC Connection(Database)
				Connection dbConn = mdb.getConnection();
				PreparedStatement pStmt = dbConn.prepareStatement("insert into ContactInfo values(?, ?, ?, ?, ?)");
				pStmt.setString(1, address);
				pStmt.setString(2, city);
				pStmt.setString(3, state);
				pStmt.setString(4, country);
				pStmt.setString(5, phonenumber);
				pStmt.execute();
				pStmt.close();
				dbConn.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpSession ses=request.getSession();
			ses.setAttribute("pinform1", personalInfo);
			response.sendRedirect("jsp/bankinfo.jsp");
				
		}
		else {
			
			request.setAttribute("errmsgs1", errors1);
			RequestDispatcher rd=request.getRequestDispatcher("jsp/contactinfo.jsp");
			rd.forward(request, response);

		}
		
	}
		private boolean isBlank(String fieldname1) {
			return fieldname1==null||fieldname1.trim().length()==0;
	}
		
	

}
		
		
