package responseValidation;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rest.restProject.PojoClassTest;

import io.restassured.http.ContentType;

public class ResponseValidationForMultipleReq {

	@Test(dataProvider = "getData")
	public void validateResp(String createdBy,String projectName,String status,int teamSize) {
		PojoClassTest pojo=new PojoClassTest(createdBy, projectName, status, teamSize);
		given()
			.body(pojo)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
		}
	@DataProvider
	public Object[][] getData(){
		Object[][] objArray=new Object[2][4];
		objArray[0][0]="Adharsh Sir";
		objArray[0][1]="Adharsh Proj";
		objArray[0][2]="completed";
		objArray[0][3]=222;
		
		objArray[1][0]="Deepak Sir";
		objArray[1][1]="Deepak Proj";
		objArray[1][2]="completed";
		objArray[1][3]=222;
		
		return objArray;
	}
}
