package restassuredday2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetUserdata {
	
	@Test
	void getuserData() {
		
		given()
		
		.when()
		.get("http://localhost:3000/students/3")
		
		.then()
		.statusCode(200)
		.body("location", equalTo("India"))
		.log().all();
	}
}
