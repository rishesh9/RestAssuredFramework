package RestPractise;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;



public class TestPostRequest {

	public static void main(String[] args) {
		
		
		 
	Response res=	given()
		.baseUri("https://reqres.in/")
		.basePath("/api/users")
		.accept("application/json")
		.body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}")
		.when()
		.post();
	
	res.then().statusCode(201).log().all();
		
		
		
		
		
		
		
		

	}

}
