package restassuredday2;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ThirdWayofPostPOJO {
	@Test(priority = 1)
	void createUser() {
		
		POJO_PostRequest data = new POJO_PostRequest();
		data.setName("Jathin");
		data.setPhone("567353");
		data.setLocation("Hydera");

		String courseArr[] = { "Sele", "Salesforce" };
		data.setCoursesArr(courseArr);
		
		 ValidatableResponse res = given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Jathin"))
		.log().all();

	}
	
	@Test(priority = 2)
	void getuserData() {
		
		given()
		
		.when()
		.get("http://localhost:3000/students/b902")
		
		.then()
		.statusCode(200)
//		.body("location", equalTo("India"))
		.log().all();
	
	}
}
