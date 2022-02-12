package parametersAndAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class QueryParameterTest {

	@Test
	public void queryParam() {
		given()
			.queryParam("page","2")
		.when()
			.get("https://reqres.in/api/users")
		.then()
			.assertThat().statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
