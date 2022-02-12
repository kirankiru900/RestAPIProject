package practiseCRUDwithBDD;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProject {

	@Test
	public void createProject() {
		
		Random randNum = new Random();
				int ran=randNum.nextInt();
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "hulk");
		jObj.put("projectName", "tys"+ran);
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
