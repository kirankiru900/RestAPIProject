package responseValidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResponseValidationDynamic {

	@Test
	public void respValidation() {
		String expProjName="tys";
		Response resp = when().get("http://localhost:8084/projects");
		
		List<String> projNames=resp.jsonPath().get("projectName");
		boolean flag=false;
		for(String pNames:projNames) {
			try {
				if(pNames.equalsIgnoreCase(expProjName)) {
					flag=true;
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		resp.then()
			.assertThat()
			.contentType(ContentType.JSON).and().statusCode(200)
			.log().all();
		Assert.assertEquals(flag, true);
	}
}
