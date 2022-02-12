package practise;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.rest.restProject.PojoClassTest;

import io.restassured.http.ContentType;

public class CreateProjectWithOnGoingStatus {

	@Test
	public void createProjWithOngoingStatus() {
		PojoClassTest pOjO = new PojoClassTest("deepak", "deepak_pro-2", "On Going", 10);
		
		given()
			.body(pOjO)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
