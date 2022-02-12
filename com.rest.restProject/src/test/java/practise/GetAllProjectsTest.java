package practise;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllProjectsTest {
	@Test
	public void getAllProj() {
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().statusCode(200)
			.assertThat().time(Matchers.lessThan(1000L), TimeUnit.MILLISECONDS)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
