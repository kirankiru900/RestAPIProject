package practise;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddProjWithInValidStatus {

	@Test
	public void createProj() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "hulk");
		jObj.put("projectName", "tys");
		jObj.put("status", "created");
		jObj.put("teamSize", 12);
		
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
