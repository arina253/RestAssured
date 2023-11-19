package one;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured; // Import RestAssured
import io.restassured.response.Response;

public class day5bCookies {
	
/*When a user visits a website, the web server creates small blocks of data 
called cookies and stores them on the user's computer or device via their web
browser.
Cookies are small pieces of data (usually text) that are sent by a web server
and stored on the client's device in a cookie file.
Multiple cookies may be placed on the device during a session. 
When the user revisits the website, it loads faster because the cookies are
already stored on their device.*/
	

	@Test
	public void getCookieInfo() {
		Response res = RestAssured.given() // Use RestAssured.given() to build the request
				.when().get("https://www.google.com/");
		

// You can now work with the 'res' object to extract information about cookies
// or perform other assertions.
// For example, you might want to extract and print all cookies:
		Map<String, String> cookies = res.getCookies();
		for (Map.Entry<String, String> entry : cookies.entrySet()) {
			System.out.println("Cookie Name: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}

	@Test
	   public void testCookie() {
		   
		  Response response = RestAssured.given()
	                .when()
	                .get("https://www.google.com/")
	                .then()
//	                .expect()
//	                .cookie("AEC", "Ackid1Qiul2eXUm27Czyk4XjjlD-N9lD_JOJ8XBE3tX2Kv6PChDvOaC4Wm")
	                .assertThat()
	                .cookie("1P_JAR", "2023-11-10-04")
	                
	                .log().all()      // Logging the response for better visibility (optional)
	                .statusCode(200) // Example: additional assertion on status code
	                .extract().response();
	   
	   
	   }

}

/*The cookie() method in RestAssured is typically used within the expect() clause.
For cookie assertions, you can use expect().cookie()

The expect().cookie() method is used to assert the presence of the specified 
cookie and its value.

We can also use .assertThat().cookie() to properly assert the presence of the specified cookie.

extract(): This method is used to extract information from the response.
For example, you can use extract().response() to get the entire response and 
then perform additional assertions or validations.

The extract() method is used for extracting information from the response, but 
it's not directly related to asserting cookies.*/
