package com.rest.apitests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

public class HTTPRequestTest {
	
	int id;

	@Test(priority = 1)
	public void getUsers() {
		given()

				.when()

				.get("https://reqres.in/api/users?page=2")

				.then().statusCode(200)

				.body("page", equalTo(2))
				.log().all();
	}
	
	@Test(priority = 2)
	public void createUser() {
		
		HashMap data=new HashMap();
		data.put("name", "viswa");
		data.put("job", "Hunter");
		
		 id = given()
		.contentType("application/.json")
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
	}
	
	@Test(priority = 3, dependsOnMethods = {"createUser"})
	public void updateUser() {
		
		HashMap data=new HashMap();
		data.put("name", "viswa");
		data.put("job", "Savior");
		
		 given()
		.contentType("application/.json")
		
		.when()
		.put("https://reqres.in/api/users/2"+id)
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	@Test(priority = 4)
	public void deleteUser() {
		
		when()
		.delete("https://reqres.in/api/users/2"+id)
		
		.then()
		.statusCode(204)
		.log().all();
		
	}
}
