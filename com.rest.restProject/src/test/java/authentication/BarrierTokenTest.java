package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BarrierTokenTest {

	@Test
	public void barrierToken() {
		given()
			.auth().oauth2("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kirankiru900")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.assertThat().statusCode(202)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
