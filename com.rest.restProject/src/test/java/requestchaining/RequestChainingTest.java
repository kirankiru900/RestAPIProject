package requestchaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainingTest {

	@Test
	public void requestChaining() {
		Response resp = when()
			.get("http://localhost:8084/projects");
		String prjName=resp.jsonPath().get("[0].projectId");
		given()
			.pathParam("projectId", prjName)
		.when()
			.delete("http://localhost:8084/projects/{projectId}")
		.then()
			.assertThat().statusCode(204)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
