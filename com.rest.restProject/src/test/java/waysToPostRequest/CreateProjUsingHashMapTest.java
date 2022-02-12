package waysToPostRequest;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjUsingHashMapTest {

	@Test
	public void createProjHasMap() {
		HashMap hmap = new HashMap();
		hmap.put("createdBy", "ajay");
		hmap.put("projectName", "tyss");
		hmap.put("status", "created");
		hmap.put("teamSize", 44);
		
		given()
			.body(hmap)
			.contentType(ContentType.JSON)
		.when()
			.post("https://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
