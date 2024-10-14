package RestPractise;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

public class DeleteRequest {
	
	public SendPostRequest send;
	
	
	Map<String, Object> map=new HashMap<>();
	
	
//	Map<String,Object>	storeid= resp.extract().as(Map.class);
//	
//	Object value=storeid.get("id");
	
	
	@Test
	public void deleteCreatedRequest() {
		
		map.put("id", "34f7");
		map.put("basepath", "students");
		
	ValidatableResponse res=	 given().
		log().all()
		.baseUri("http://localhost:3000")
		.basePath("{basepath}/{id}")
		.pathParams(map)
		.when().delete()
		.then().statusCode(200)
		.log().all();

	
	}
	
	
	

}
