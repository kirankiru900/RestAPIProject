package com.RMGYantraTests;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.rest.GenericUtility.BaseAPIClass;
import com.rest.GenericUtility.EndPoints;
import com.rest.restProject.PojoClassTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateResourseAndVerifyInDB extends BaseAPIClass{

	@Test
	public void updateResourseAndVerifyInDB() throws Throwable {
		PojoClassTest poj=new PojoClassTest("Chaitra", "Tyss"+jLib.getRandomNum(), "completed", 10);
		
		Response resp = given()
				.body(poj)
				.contentType(ContentType.JSON)
			.when()
				.put(EndPoints.updateProjects);
		
		String expData=rLib.getJSONData(resp, "projectId");
		System.out.println(expData);
		
		String query="select * from project;";
		String actData=dLib.executeQueryAndGetData(query, 1, expData);
		Reporter.log(actData, true);
		
		Assert.assertEquals(expData, actData);
		Reporter.log("validation succesful", true);
	}
}
