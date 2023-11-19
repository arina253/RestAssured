package one;

public class Misc {
	
	/*1)import static io.restassured.RestAssured.given; // Import the given method
     
	@Test
	public void getCookieInfo() {
		Response res = given()
			.when()
			.get("https://www.google.com/");
			
			2)import io.restassured.RestAssured; // Import RestAssured
	@Test
		public void getCookieInfo() {
		Response res = RestAssured.given() // Use RestAssured.given() to build the request
			.when()
			.get("https://www.google.com/");
			
RestAssured provides a set of common methods for constructing and sending HTTP
request
the Response class in RestAssured offers methods for extracting information and
performing assertions on the HTTP response. 
 
Here are common methods for both classes:

RestAssured Class (Static methods):
Request Specification:
given(): Starts building a request specification.

HTTP Methods:
get(String path): Sends a GET request.
post(String path): Sends a POST request.
put(String path): Sends a PUT request.
delete(String path): Sends a DELETE request.

Request Configuration:
param(String name, Object value): Adds a query parameter to the request.
header(String name, Object value): Adds a header to the request.
body(Object body): Sets the request body.

Authentication:
auth().basic(String username, String password): Adds basic authentication.
auth().oauth(...): Adds OAuth authentication.

Logging:
log().all(): Logs all details of the request and response.

Cookies:
cookie(String name, String value): Adds a cookie to the request.

Assertions:
expect(): Initiates the assertion section of the response.

Response Class:

Status Code:
statusCode(int expectedStatusCode): Asserts the response status code.
getStatusCode(): Retrieves the response status code.

Body:
body(): Obtains the response body.
asString(): Converts the response body to a String.
jsonPath(): Provides access to JSON response using JSONPath expressions.

Headers:
header(String headerName): Retrieves the value of a specific header.
headers(): Retrieves all headers as a map.

Cookies:
cookie(String cookieName): Retrieves the value of a specific cookie.
getCookies(): Retrieves all cookies as a map.

Assertions:
assertThat(): Initiates the assertion section of the response.
assertThat().body(...): Asserts on the response body.
assertThat().statusCode(...): Asserts on the status code.
assertThat().header(...): Asserts on headers.
assertThat().cookie(...): Asserts on cookies.

Logging:
log().all(): Logs the entire response.
log().body(): Logs the response body.
log().headers(): Logs the response headers.
log().cookies(): Logs the response cookies.

Extracting values:
path(String path) or jsonPath().get(String path): Extracts values using a given path.

Time Measurement:
time(): Returns the response time in milliseconds.

//IMPORTS
 
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
			
			
*/
}
