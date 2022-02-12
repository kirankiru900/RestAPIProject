package waysToPostRequest;

import static io.restassured.RestAssured.*;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJSONObjTest {

	@Test
	public void createProj() {
		JSONObject jObj = new JSONObject();
		jObj.put("created", "jayama");
		jObj.put("projectName","testProj");
		jObj.put("status", "completed");
		jObj.put("teamSize", 55);
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
