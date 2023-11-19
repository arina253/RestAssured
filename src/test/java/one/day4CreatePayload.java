package one;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class day4CreatePayload {
	
	/*Multiple ways to create payload
	1.Using HashMap
	2.Using org.json
	3.Using pojo
	4.Using external json file*/
	
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
	public void createUser() throws FileNotFoundException {
		
    	//1)Using HashMap
		String email = getSaltString() + "@gmail.com";
//		HashMap <String,String>payload = new HashMap<String, String>();
//		
//		//Add key-value pairs to the payload
//		payload.put("name", "Ari Joshi");
//		payload.put("gender", "female");
//		payload.put("email",email);
//		payload.put("status","active");
		
		
		//2) Creating a payload using org.json
//		JSONObject jsonPayload = new JSONObject();
//		jsonPayload.put("name", "Ari Joshi");
//		jsonPayload.put("gender", "female"); 
//		jsonPayload.put("email",email);      
//		jsonPayload.put("status","active");  
//		
//		String payload = jsonPayload.toString();
		                                 
	    //3) Using POJO class(Plain old Java object)
//		Students payload = new Students("arina joshi","female",email,"active");
	  
		//4)Using external json
		
		//Create a FileReader to read the JSON file
		
		
	FileReader fileReader = new FileReader("C:\\Users\\joshi\\eclipse-workspace\\restAssured\\src\\test\\java\\one\\obj.json");
		
		
		//Create a JSONTokener to parse the JSON data
		JSONTokener tokener = new JSONTokener(fileReader);
		
		//Create a JSONObject from the parsed data
		JSONObject jsonpayload = new JSONObject(tokener);
		String payload = jsonpayload.toString();
		
		
		
		//String requestBody = "{\"name\":\"Ari Joshi\", \"gender\":\"Female\", \"email\":\"" + email + "\", \"status\":\"active\"}";
		RestAssured.baseURI = "https://gorest.co.in/public/v2/users" ;
		
		Response response = RestAssured.given()
				   .header("Accept","application/json")
		           .header("Content-Type","application/json")
		           .header("Authorization",token)
		           .body(payload)
                   .when()
                   .post();
		response.then().log().all();
		response.then().statusCode(201);
	}
		}


		
		