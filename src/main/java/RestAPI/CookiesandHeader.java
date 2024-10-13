package RestAPI;


import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Set;

public class CookiesandHeader {
	
	
	
	
	@Test(priority=1)
	public void setUpGoogle() {
		
		given()
		.when()
		.get("https://google.com")
		.then().and()
         .log().all();
		
		
		
		
	}
	
	
  @Test(priority=2)	
  private void sout() {
	System.out.println("################################");

}
	
	@Test(priority=3)
	
	public void storeCookie() {
		
		
		Response res=given()
		.when().get("https://google.com");
		
	String AECValue=res.getCookie("AEC");
	System.out.println(AECValue);
	
	
	Map<String,String> data=res.getCookies();
		
		System.out.println(data);
		
		Set<String> keys=data.keySet();
		
		for(String key :keys) {
			
			String kookie_value=res.getCookie(key);
			System.out.println(kookie_value);
			
			System.out.println("################################");
		}
	}
		@Test(priority=4)
		public void verifyHeaders() {
			
			Response res=given()
					.when().get("https://google.com");
			
			String headerDetails=res.header("Content-Type");
			System.out.println(headerDetails);
			
		
//			given()
//			.when()
//			.get("https://google.com")
//			.then().statusCode(200).header("", expectedValueMatcher);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
	}
	
	
