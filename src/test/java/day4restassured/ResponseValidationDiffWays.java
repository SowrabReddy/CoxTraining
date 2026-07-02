package day4restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResponseValidationDiffWays {

	
	  @Test 
	  void reponseValidation() {
		 
	  
	  given()
	  
	  .contentType("ContentType.JSON")
	  
	  .when() .get("http://localhost:3000/book")
	  
	  .then() .statusCode(200) .body("[2].title", equalTo("Laugh Riots"))
	  
	  .log().all();	  
	  }
	  
	  @Test 
	  void reponseValidationApproachTwo() {
	  
	  Response res = given() .contentType("ContentType.JSON")
	  
	  .when()
	  
	  .get("http://localhost:3000/book");
	  
	  Assert.assertEquals(res.getStatusCode(), 200);
	  
	  String bookname = res.jsonPath().get("[2].title").toString();
	  
	  Assert.assertEquals(bookname, "Laugh Riots");
	  
	  System.out.println("Title of the book is : "+bookname);
	  
	  
	  if (res.jsonPath().get("[2].author").equals("Sameera")) {
	  
	  String price = res.jsonPath().get("[2].price").toString();
	  System.out.println(price + " : is the cost of the book");
	  
	  } else { System.out.println("Validation Failed"); }
	  
	  }
	 

	@Test
	void bodyValidationApproachThree() {

		Response response = given()

				.contentType(ContentType.JSON)

				.when().get("http://localhost:3000/book");

		/*
		 * String booktitles = response.jsonPath().get("title").toString();
		 * System.out.println("===============================================");
		 * System.out.println("Here are the book titles : "+booktitles);
		 * System.out.println("===============================================");
		 * 
		 * 
		 * System.out.println(response.body().print());
		 * 
		 * if (booktitles.contains("Sword of honour")) {
		 * 
		 * System.out.println("Sword of honour is Present in the reponse............");
		 * } else {
		 * System.out.println("Sword of honour is not present in the response........."
		 * ); }
		 */

		JSONArray jsonArray = new JSONArray(response.asString());

		for (int i = 0; i < jsonArray.length(); i++) {

			JSONObject bookObject = jsonArray.getJSONObject(i);
			String bookTitle = bookObject.getString("title");
			System.out.println(bookTitle);

//			String titles = jo.getJSONArray(".").getJSONObject(i).get("id").toString();
		}

	}
}
