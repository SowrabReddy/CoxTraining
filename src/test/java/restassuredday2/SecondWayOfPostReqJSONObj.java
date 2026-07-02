package restassuredday2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

/*Using Hash Map Approach*/

public class SecondWayOfPostReqJSONObj {

	@Test
	void createUser() {
		
		JSONObject data = new JSONObject();
		
		data.put("name", "Sowdham");
		data.put("location", "PTP");
		data.put("phone", "53533");
		
		String courseArr[]= {"MuleSoft","APigee"};
		data.put("courses",courseArr);
		
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		
		.body("name",equalTo("Sowdham"))
		.body("location",equalTo("PTP"))
		.body("phone", equalTo("53533"))
		.body("courses[0]", equalTo("MuleSoft"))
		
//		.header("Content-Type", "application/json; charset=utf-8")
		
		.log().all();		
	}

	}

