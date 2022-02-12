package waysToPostRequest;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjUsingJSONFileTest {

	@Test
	public void createProjFile() {
		File fl=new File("./dataBabu.json");
		
		given()
			.body(fl)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
