package RestPractise;

import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;




public class GetBooking {
	
	@Test
	public void booking() {
		
           RequestSpecification req= RestAssured.given();
           req.baseUri("https://restful-booker.herokuapp.com")
           .basePath("booking/{id}");
		
           req.pathParam("id", 1);
           
         Response res=  req.get();
         
         ValidatableResponse val=res.then().statusCode(200).log().all();
         
         
        Map<String,Object> vadr= val.extract().as(Map.class);
        
        for(Entry<String,Object> v:vadr.entrySet()){
        	
        	System.out.println(v.getKey() + ":" +  v.getValue());
        	
        }
           
		
          {
        	 
         }
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
