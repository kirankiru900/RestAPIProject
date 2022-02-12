package practiseCRUDwithBDD;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProj {

	@Test
	public void updateProj() {
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
			.put("http://localhost:8084/projects/TY_PROJ_403")
		.then()
			.assertThat().statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();
			
	}
}
