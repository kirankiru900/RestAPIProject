package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DigestiveAuthTest {

	@Test
	public void digestiveAuth() {
		given()
			.auth().digest("rmgyantra", "rmgy@9999")
		.when()
			.get("http://localhost:8084/login")
		.then()
			.assertThat().statusCode(202)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
