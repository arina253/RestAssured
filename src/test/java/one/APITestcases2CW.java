package one;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class APITestcases2CW {
	
	private String accessToken = "4a47e7c2ccb5a001d4a4baee7831e5c91dc24999dbdeb53ad11b7aa394995b5e";
	APIUtilities apiUtils = new APIUtilities(accessToken);
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
		public void testPOSTRequest() {
			
			//String payload ="{\"name\":\"Ten Ramakrishna\", \"gender\":\"male\", \"email\":\"tenali.ramakrishna@15ce.com\", \"status\":\"active\"}";
			
			String email = getSaltString() + "@gmail.com";
			HashMap <String,String>payload = new HashMap<String,String>();
			payload.put("name","Ten Ramakrishna");
			payload.put("gender", "male");
			payload.put("email", email);
			payload.put("status","active");
			
			
			Response postResponse = apiUtils.sendPOSTRequest("/users",payload);
			System.out.println("Response Body: " + postResponse.getBody().asString());
            //postResponse.then().assertThat().body("name",equalTo("Ten Ramakrishna"));
			postResponse.then().assertThat().body("name", equalTo("Ten Ramakrishna"));
		}
	}
	