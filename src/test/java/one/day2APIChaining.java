package one;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class day2APIChaining {
	
	//Subsequent API
    @Test
	    public void APIChain() {

	        // Set the base URI for the API
	        RestAssured.baseURI = "https://reqres.in";

	        // Make a get request
	        Response response = given()
	            .queryParam("page", 2)
	            .when().get("/api/users")
	            .then()
	            .log().all()
	            .extract()
	            .response();

	        // Print the response body to inspect it
	        System.out.println("Response Body: " + response.getBody().asString());

	        int id = response.jsonPath().getInt("data[0].id"); 
	        System.out.println(id); //7
	        
	        int id2 = response.jsonPath().getInt("total");
	        System.out.println(id2);
	        String firstName = response.jsonPath().getString("data[5].first_name");
	        System.out.println(firstName);  //Rachel
	        String text = response.jsonPath().getString("support.text");
	        System.out.println(text);

	        Response res = given()
	            .pathParam("userId", id)
	            .when()
	            .get("/api/users/{userId}");

	        // Print the response body of the second API call to inspect it
	        System.out.println("Second API Response Body: " + res.getBody().asString());

	        res.then().statusCode(200);
	        res.then().assertThat()
	            .body("data.id", equalTo(id))
	            .body("data.email", equalTo("michael.lawson@reqres.in"))
	            .body("data.first_name", equalTo("Michael"))
	            .body("data.last_name", equalTo("Lawson"))
	            .body("data.avatar", equalTo("https://reqres.in/img/faces/7-image.jpg"));
	    }
	}

