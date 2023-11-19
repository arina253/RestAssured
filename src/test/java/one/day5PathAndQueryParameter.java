package one;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class day5PathAndQueryParameter {
	
	//https://reqres.in/api/users?page=2

	@Test
	public void testPathAndQueryParameter(){
		Response response = RestAssured.given()
		           .pathParam("myPath", "users")
		           .queryParam("page","2")
		           .when()
		           .get("https://reqres.in/api/{myPath}");
		
		response.then().log().all();
	    response.then().statusCode(200);
	    
	    response.then().log().body();
	    response.then().log().headers();
	    
	    //Validating headers
	    
	    response.then().header("Content-Type",Matchers.equalTo ("application/json; charset=utf-8"));
	    response.then().header("Transfer-Encoding", Matchers.equalTo("chunked"));
	    response.then().header("Connection",Matchers.equalTo ("keep-alive"));
	    response.then().header("X-Powered-By",Matchers.equalTo("Express"));
	    response.then().header("Etag", Matchers.equalTo("W/\"406-ut0vzoCuidvyMf8arZpMpJ6ZRDw\""));
	    response.then().header("Via",Matchers.equalTo("1.1 vegur"));
	    response.then().header("Cache-Control",Matchers.equalTo ("max-age=14400"));
	    response.then().header("CF-Cache-Status", Matchers.equalTo("HIT"));
	    //response.then().header("Age",Matchers.equalTo("5265"));
	    response.then().header("Vary",Matchers.equalTo("Accept-Encoding"));
	    response.then().header("Server",Matchers.equalTo("cloudflare"));
	    //response.then().header("CF-RAY",Matchers.equalTo("823aa052c875e79a-DFW"));
	    response.then().header("Content-Encoding", Matchers.equalTo("gzip"));
	    
	   response.then().body("page",Matchers.equalTo(2));
	    response.then().body("per_page",Matchers.equalTo(6));
	    response.then().body("total",Matchers.equalTo(12));
	    response.then().body("total_pages",Matchers.equalTo(2));
	    response.then().body("data[0].id",Matchers.equalTo(7));
        response.then().body("data[0].email",Matchers.equalTo( "michael.lawson@reqres.in"));
	    response.then().body("data[0].first_name",Matchers.equalTo("Michael"));
	    response.then().body("data[0].last_name",Matchers.equalTo("Lawson"));
	    response.then().body("data[1].first_name",Matchers.equalTo ("Lindsay"));
	    	    
	    
	    }
	
	
}

/*Header "Age" & Header "CF-RAY" changes on each API hit.*/
