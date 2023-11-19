package one;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIUtilities {
	
	 private String accessToken;
	public APIUtilities( String accessToken) {
		this.accessToken = accessToken;
		RestAssured.baseURI = "https://gorest.co.in/public/v2";
	}

	//GET
	@Test
	public Response sendGETRequest(String endpoint){
		return RestAssured
			.given()
		    .header("Accept","application/json")
		    .header("Content-Type","application/json")
		    .header("Authorization", "Bearer " + accessToken)
		    .when()
		    .get(endpoint);
		}
	
	
	//POST
	@Test
	public Response sendPOSTRequest(String endpoint,HashMap<String, String> payload) {
		return RestAssured
				.given()
				.header("Accept","application/json")
			    .header("Content-Type","application/json")
			    .header("Authorization", "Bearer " + accessToken)
			    .body(payload)
			    .when()
			    .post(endpoint);
		}
	
	//UPDATE
	@Test
	public Response sendPUTRequest(String endpoint,HashMap<String,String>payload) {
		return RestAssured
				.given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " + accessToken)
				.body(payload)
				.when()
				.put(endpoint);
	}
	
	//DELETE
	@Test
	public Response sendDELETERequest(String endpoint) {
		return RestAssured
				.given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization","Bearer " + accessToken)
				.when()
				.delete(endpoint);
	}

	
	}
	

