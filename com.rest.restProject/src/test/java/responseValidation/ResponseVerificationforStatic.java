package responseValidation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResponseVerificationforStatic {
	
	@Test
	public void respVerification() {
		String expProjName="tys";
		Response resp = when().get("http://localhost:8084/projects");
		String actProjName=resp.jsonPath().get("[1].projectName");
		
		resp.then()
			.assertThat()
			.contentType(ContentType.JSON).and().statusCode(200)
			.log().all();
		Assert.assertEquals(expProjName, actProjName);
		
		
		
	}
}
