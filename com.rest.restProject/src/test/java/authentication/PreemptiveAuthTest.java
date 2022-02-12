package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PreemptiveAuthTest {

	@Test
	public void preemptiveAuth() {
		given()
			.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
			.get("http://localhost:8084/login")
		.then()
			.assertThat().statusCode(202)
			.contentType(ContentType.JSON)
			.log().all();
		
	}
}
