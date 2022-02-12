package practiseCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	public void updateProject() {
		//step1: create test data
				JSONObject jObj = new JSONObject();
				jObj.put("createdBy", "adharsh");
				jObj.put("projectName", "tysss");
				jObj.put("status", "created");
				jObj.put("teamSize", 12);
				
				RequestSpecification req = RestAssured.given();
				req.contentType(ContentType.JSON);
				req.body(jObj);
				
				Response resp = req.put("http://localhost:8084/projects/TY_PROJ_005");
				
				
				ValidatableResponse validate = resp.then();
				validate.assertThat().statusCode(200);
				validate.log().all();
				
	}
}
