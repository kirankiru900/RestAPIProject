package practise;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.rest.restProject.PojoEmpClassTest;

import io.restassured.http.ContentType;

public class CreateEmpWithInvalidEmail {

	@Test
	public void createEmpWithInvalidEmail() {
PojoEmpClassTest emp_Pojo = new PojoEmpClassTest("SDET", "25/05/1999", "nithesh", "nithesh", 15, "9888777657", "hdfc", "ROLE_ADMIN", "nithesh123");
		
		given()
			.body(emp_Pojo)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/employees")
		.then()
			.assertThat().statusCode(422)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
