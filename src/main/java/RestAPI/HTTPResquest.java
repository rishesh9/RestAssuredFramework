package RestAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPResquest {
	
	int id;
	
	
	@Test(priority=1)
	public void getUsers() {
		
		
		/**
		 * given()-- Represent to present pre- requisite of API like Headers,QueryParameters
		 */
		
		
		
		given()
		
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
		
		
	}

	
	@Test(priority=2)
	public void createUser() {
		 
		
		
		HashMap<String, String> data=new HashMap<String, String>();
		data.put("name", "Rishesh");
		data.put("job", "QA");
		
		id=given()
		.contentType("application/json").body(data)
		
	
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		System.out.println(id);
	}
//		.then().statusCode(201)
//		.log().all();
		
		@Test(priority=3 ,dependsOnMethods= {"createUser"})
		public void updateUser() {
			
			
			HashMap<String, String> data=new HashMap<String, String>();
			data.put("name", "Sundar");
			data.put("job", "Manager");
			
			given()
			.contentType("application/json").body(data)
			
				
			.when()
			.put("https://reqres.in/api/users"+id)
			
			
			.then()
			.log().all();
			
		}
		
		
		@Test
		public void deleteUser() {
			
			((RestAssured) given().auth())
			.when()
			.delete("https://reqres.in/api/users"+id)
			
			
			.then()
			.statusCode(204);
			
			
			
			
			
			
			
			
			
		}
		
		

}
