package RestPractise;

import org.testng.Assert;
import  org.testng.annotations.*;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class SendPostRequest {
	
	HashMap<String, Object> data=new HashMap<>();
	
	Map<String, Object> map=new HashMap<>();
	
	public ValidatableResponse resp;
	
	
	
	
	@Test
	public void createreq() {
		
		
		
		data.put("name", "Mahajan");
		data.put("location", "Seattle");
		data.put("phone",9810906082L);
		
		String [] courses= {"Math","Science"};
		data.put("subjects", courses);
		
		
		
		resp =  given().contentType("application/json")
		.log().all()
		.baseUri("http://localhost:3000")
		.basePath("students")
		.body(data)
		.when().post()
		.then().statusCode(201).log().all();
		

						
		
	}
	
	@Test
	public void getCreatedRequest() {
		
		
	Map<String,Object>	storeid= resp.extract().as(Map.class);
	
	Object value=storeid.get("id");
		
	ValidatableResponse res=	 given().
		log().all()
		.baseUri("http://localhost:3000")
		.basePath("students/{id}")
		.pathParam("id", value)
		.when().get()
		.then().statusCode(200).log()
		.all();
	
	Map<String,Object>  hash= res.extract().as(Map.class);
	
	for(Map.Entry<String, Object>  h:hash.entrySet()) {
		
		System.out.println(h.getKey() + " :" + h.getValue());
		
	}
	
     // Assert.assertEquals(res, data);
		
		
	}
	
	@Test
	public void updateCreatedRequest() {
		
		Map<String,Object>	storeid= resp.extract().as(Map.class);
		
		Object value=storeid.get("id");
		
		HashMap<String, Object> newdata=new HashMap<>();
		
		newdata.put("name", "Trosa");
		
		
		map.put("id", value);
		map.put("basepath", "students");
		
		
		given().contentType("application/json")
		.log().all()
		.baseUri("http://localhost:3000")
		.basePath("{basepath}/{id}")
		.pathParams(map)
		.body(newdata)
		.when().put()
		.then().statusCode(200).log().all();
	
	
	}
	
	
}
