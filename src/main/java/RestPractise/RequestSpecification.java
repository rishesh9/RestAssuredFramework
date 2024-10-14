package RestPractise;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;




public class RequestSpecification {
	
	
	
	@Test
	public void request() {
		
	io.restassured.specification.RequestSpecification res= RestAssured.given();
	res.baseUri("https://reqres.in/");
	res.basePath("/api/users");
	
res.body("{\r\n" + 
			"    \"name\": \"morpheus\",\r\n" + 
			"    \"job\": \"leader\"\r\n" + 
			"}");
res.contentType(ContentType.JSON);

          Response resp=res.post();
          
       ValidatableResponse vr=   resp.then().statusCode(201).log().all().contentType(ContentType.JSON);
       
       @SuppressWarnings("unchecked")
	Map<String, Object> responseBody = vr.extract().as(Map.class);
       

       for (Map.Entry<String, Object> entry : responseBody.entrySet()) {
           System.out.println("Key of: " + entry.getKey() + ": " + "Value of: " +entry.getValue());
       }
	
	
	}
	
	

}
