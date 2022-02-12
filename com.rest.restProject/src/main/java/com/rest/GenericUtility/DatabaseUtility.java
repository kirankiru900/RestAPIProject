package com.rest.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * this class contains all generic methods related to database
 * @author Kiran Kumar
 *
 */

public class DatabaseUtility {
	Connection con;
	public void connectToDB() throws Throwable {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		 con = DriverManager.getConnection(IConstants.dbURL, IConstants.dbUserName, IConstants.dbPassword);
	}


public String executeQueryAndGetData(String Query,int colIndex,String expData) throws SQLException {
	boolean flag=false;
	ResultSet res = con.createStatement().executeQuery(Query);
	while(res.next()) {
		String value=res.getString(colIndex);
		if(value.equalsIgnoreCase(expData)) {
			flag=true;
			break;
		}
	}
	if(flag) {
		System.out.println(expData+"data verified");
		return expData;
	}else {
		System.out.println("data not present");
		return "";
	}
}
	public void closeDB() throws SQLException {
		con.close();
	}
}