package one;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class day3GoRestAPI {
	
	String token = "Bearer 4a47e7c2ccb5a001d4a4baee7831e5c91dc24999dbdeb53ad11b7aa394995b5e";
	
	protected String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
		
	}
		
		@Test

	public void listUsers() {
		RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		
		//curl -i -H "Accept:application/json" -H "Content-Type:application/json" -H "Authorization: Bearer 4a47e7c2ccb5a001d4a4baee7831e5c91dc24999dbdeb53ad11b7aa394995b5e" -XGET "https://gorest.co.in/public/v2/users"
		Response response = RestAssured.given()
				           .header("Accept","application/json")
				           .header("Content-Type","application/json")
				           .header("Authorization",token)
		                   .when()
		                   .get();
		                  
		response.then().statusCode(200);
		System.out.println("Response Body: " + response.getBody().asString());
		}
		
		
		@Test
	public void createUser() {
			
		String email = getSaltString() + "@gmail.com";
		String requestBody = "{\"name\":\"Ari Joshi\", \"gender\":\"Female\", \"email\":\"" + email + "\", \"status\":\"active\"}";
		RestAssured.baseURI = "https://gorest.co.in/public/v2/users" ;
		
		Response response = RestAssured.given()
				   .header("Accept","application/json")
		           .header("Content-Type","application/json")
		           .header("Authorization",token)
		           .body(requestBody)
                   .when()
                   .post();
		response.then().log().all();
		response.then().statusCode(201);
	}
		
		
		@Test
		public void updateUser() {
			
			String email = getSaltString() + "@gmail.com";
			String requestBody = "{\"name\":\"Avi Joshi\", \"email\":\"" + email + "\", \"status\":\"active\"}";
			
			RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
			
			Response response = RestAssured.given()
					            .header("Accept", "application/json")
					            .header("Content-Type","application/json")
					            .header("Authorization",token)
					            .body(requestBody)
					            .when()
					            .patch("/5702932");
					            response.then().log().all();
					            response.then().statusCode(200);
		}
		
		@Test
		public void deleteUser() {
RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
			
			Response response = RestAssured.given()
					            .header("Accept", "application/json")
					            .header("Content-Type","application/json")
					            .header("Authorization",token)
					            .when()
					            .delete("/5672238");
			response.then().log().all();
			response.then().statusCode(404);
			
		}

}


