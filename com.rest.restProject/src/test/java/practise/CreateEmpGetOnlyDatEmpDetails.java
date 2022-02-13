package practise;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.rest.restProject.PojoEmpClassTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class CreateEmpGetOnlyDatEmpDetails {

	@Test
	public void createEmp() {
		Random randNum = new Random();
		int ranNum=randNum.nextInt();
		String empName="nithish"+ranNum;
		PojoEmpClassTest emp_Pojo = new PojoEmpClassTest("SDET", "25/05/1999", "nithesh@gmail.com", "nithesh", 15, "9888777657", "hdfc", "ROLE_ADMIN", empName);
		
		Response resp = given()
			.body(emp_Pojo)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/employees");
		
		String userId=resp.jsonPath().get("employeeId");
		System.out.println(userId);
		
		when()
		.get("http://localhost:8084/employees/"+userId)
	.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}
}
