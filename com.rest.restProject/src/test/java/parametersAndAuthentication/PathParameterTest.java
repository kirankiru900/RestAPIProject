package parametersAndAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PathParameterTest {

	@Test
	public void pathParam() {
		given()
			.pathParam("projectId", "TY_PROJ_006")
		.when()
			.delete("http://localhost:8084/projects/{projectId}")
		.then()
			.assertThat().statusCode(204)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
