package com.of.apex.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MYSQLDBAccess {

	/**
	 * No Argument Constructor
	 */
	public MYSQLDBAccess() {
		super();
	}

	//Getting Connection

	public static Connection getConnection() throws Exception{
		Connection dbConn = null;
		try{
			//step1:
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step2
			String url = "jdbc:mysql://localhost:3306/WebAppData?autoReconnect=true&useSSL=false&serverTimezone=UTC";
			//step3
			dbConn = DriverManager.getConnection(url, "root", "$Ekhar1988");
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return dbConn;
	}



	// Queries

	/*public static void getAllGroups() throws Exception{

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		try{

			dbConn = getConnection();
			pStmt = dbConn.prepareStatement("SELECT * FROM `groups`");
			rs = pStmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
		}catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			rs.close();
			pStmt.close();	
			dbConn.close();
		}
		return;
	}*/


	public static ResultSet getPersonalInfo() throws SQLException, Exception{

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		try{
			dbConn = getConnection();

			pStmt = dbConn.prepareStatement("SELECT * From PersonalInfo");
			rs = pStmt.executeQuery();
			if(rs != null) {
				return rs;
			}
		}
		catch (SQLException sqe) {
			return rs;

		}
		catch (Exception e) {
			return rs;
			// TODO: handle exception
		}
		return rs;
		
	}
	
	public static ResultSet getContactInfo() throws SQLException, Exception{

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		try{
			dbConn = getConnection();

			pStmt = dbConn.prepareStatement("SELECT * From ContactInfo");
			rs = pStmt.executeQuery();
			if(rs != null) {
				return rs;
			}
		}
		catch (SQLException sqe) {
			return rs;
			// TODO: handle exception
		}
		catch (Exception e) {
			return rs;
			// TODO: handle exception
		}
		return rs;
		
	}
	
	
	public static ResultSet getBankInfo() throws SQLException, Exception{

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		try{
			dbConn = getConnection();

			pStmt = dbConn.prepareStatement("SELECT * From BankInfo");
			rs = pStmt.executeQuery();
			if(rs != null) {
				return rs;
			}
		}
		catch (SQLException sqe) {
			return rs;
			// TODO: handle exception
		}
		catch (Exception e) {
			return rs;
			// TODO: handle exception
		}
		return rs;
		
	}
}