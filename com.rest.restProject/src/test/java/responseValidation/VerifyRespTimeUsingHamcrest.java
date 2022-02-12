package responseValidation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class VerifyRespTimeUsingHamcrest {

	@Test
	public void verifyRespTimeUsingHamcrest() {
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().time(Matchers.lessThan(765L), TimeUnit.MILLISECONDS)
			.log().all();
		
	}
}
