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

import org.apache.jasper.TrimSpacesOption;

import com.of.apex.practice.valueobj.PersonalInformation;



import com.of.apex.practice.MYSQLDBAccess;


@WebServlet("/Pst")
public class PersonalServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PersonalInformation personalInfo=new PersonalInformation();
    	String errors="";
    	
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String gender= request.getParameter("gender");
		personalInfo.setFirstname(request.getParameter("firstname"));
		personalInfo.setLastname(lastname);
		personalInfo.setGender(gender);
		MYSQLDBAccess mdb = new MYSQLDBAccess();
		
		//Validation 
		if(isBlank(firstname)){
			errors+="First Name cannot be empty";
		}
		if(isBlank(lastname)) {
			errors+="Last Name cannot be empty";
		}
		if(isBlank(gender)) {
			errors+="Middle  Name cannot be empty";
		}
		
		

		if(isBlank(errors)) {
			try {      //JDBC Connection
				Connection dbConn = mdb.getConnection();
				PreparedStatement pStmt = dbConn.prepareStatement("insert into PersonalInfo values(?, ?, ?)");
				pStmt.setString(1, firstname);
				pStmt.setString(2, lastname);
				pStmt.setString(3, gender);
				pStmt.execute();
				pStmt.close();
				dbConn.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpSession ses=request.getSession();
			ses.setAttribute("pinform", personalInfo);
			response.sendRedirect("jsp/contactInfo.jsp");
		}	

		else {request.setAttribute("errmsgs", errors);
			RequestDispatcher rd=request.getRequestDispatcher("jsp/personal.jsp");
			rd.forward(request, response);

		}
		
	}
		private boolean isBlank(String fieldname) {
			return fieldname==null||fieldname.trim().length()==0;
	}
		
	

}
