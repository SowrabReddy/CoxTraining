package restassuredday2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class FirstwayToCreatePostReqHashMap {

	
	/*
	 Different ways to create Post request
	   • Using Hash map 
	   • Using org.json 
	   • Using POJO Class (Plain Old Java Object) which is widely used
	   • Using external JSON file
	 */

	
	/*Using Hash Map Approach*/

	
	@Test
	void getUsers() {
		
		HashMap data=new HashMap();
		
		data.put("name", "Sameera");
		data.put("location", "KKD");
		data.put("phone", "7893434767");
		
		String courseArr[]= {"C++","Javaw"};
		data.put("courses",courseArr);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		
		.body("name",equalTo("Sameera") )
		.body("location",equalTo("KKD") )
		.body("phone", equalTo("7893434767"))
		.body("courses[0]", equalTo("C++"))
		
//		.header("Content-Type", "application/json; charset=utf-8")
		
		.log().all();		
	}
}
