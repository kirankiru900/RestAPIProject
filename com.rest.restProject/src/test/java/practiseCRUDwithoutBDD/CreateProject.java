package practiseCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	public void createProject() {
		
		//step1: create test data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "adharsh");
		jObj.put("projectName", "adharsh");
		jObj.put("status", "created");
		jObj.put("teamSize", 12);
		
		//step2: provide request specification
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);
		
		//step3: perform action
		Response resp = req.post("http://localhost:8084/addProject");
		
		//step4:print in console and verify
		System.out.println(resp.toString());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.getContentType());
	}

}
