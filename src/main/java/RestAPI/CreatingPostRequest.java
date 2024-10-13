package RestAPI;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreatingPostRequest {

	
	@Test
	public void testPostUsingJSONLibrary() {
		
		
		JSONObject data=new JSONObject();
		data.put("name", "Scott");
		data.put("location","France");
		data.put("phone", "123456");
		
		String [] courses= {"C", "JAVA"};
		data.put("course", courses);
		
		
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		
		
		.when()
		.post("http://localhost:3000/students")
		
		
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Scott"));
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
