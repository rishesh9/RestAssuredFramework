package RestPractise;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AirLinesTests {
	
	
	@Test
	public void airLinestest() {
		
		Response res=given().baseUri("https://api.instantwebtools.net/v1/airlines")
		.contentType(ContentType.JSON)
		.body("{\r\n" + 
				"    \"id\": 15457657234,\r\n" + 
				"    \"name\": \"Rishesh Airways\",\r\n" + 
				"    \"country\": \"Sri Lanka\",\r\n" + 
				"    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\r\n" + 
				"    \"slogan\": \"From Sri Lanka\",\r\n" + 
				"    \"head_quaters\": \"Katunayake, Sri Lanka\",\r\n" + 
				"    \"website\": \"www.srilankaaairways.com\",\r\n" + 
				"    \"established\": \"1990\"\r\n" + 
				"}")
		.post()
		.then().log().all().extract().response();
		
		Assert.assertEquals(res.statusCode(), 200);

	}
	
	
	
	
	
	
	
	
	

}
