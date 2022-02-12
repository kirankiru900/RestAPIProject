package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Oauth2Test {

	@Test
	public void aAuthTest() {
		  Response resp = given()
			.formParams("client_id", "Babu Bangaram")
			.formParams("client_secret", "3f651422b21fa30093b219e11e3b1e5d")
			.formParams("grant_type","client_credentials")
			.formParams("redirect_uri","https://babubangaram.com")
		
		.when()

		.post("http://coop.apps.symfonycasts.com/token");
		  
	String token = resp.jsonPath().get("access_token");
	
	given()
		.auth().oauth2(token)
		.pathParam("User Id", 2796)
	.when()
		.post("http://coop.apps.symfonycasts.com/api/{User Id}/me")
	.then()
		.log().all();
}
}