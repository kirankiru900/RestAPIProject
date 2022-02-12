package waysToPostRequest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.rest.restProject.PojoClassTest;

import io.restassured.http.ContentType;

public class CreateProjUsingPojoTest {

	@Test
	public void createProjPojo() {
		PojoClassTest poj=new PojoClassTest("babu", "KF Strong", "created", 650);
		
		given()
			.body(poj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
