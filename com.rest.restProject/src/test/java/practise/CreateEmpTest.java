package practise;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.rest.restProject.PojoEmpClassTest;

import io.restassured.http.ContentType;



public class CreateEmpTest {

	@Test
	public void createEmp() {
		PojoEmpClassTest emp_Pojo = new PojoEmpClassTest("SDET", "25/05/1999", "nithesh@gmail.com", "nithesh", 15, "9888777657", "hdfc", "ROLE_ADMIN", "nithesh");
		
		given()
			.body(emp_Pojo)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/employees")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
