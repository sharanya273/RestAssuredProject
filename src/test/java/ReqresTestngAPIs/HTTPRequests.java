package ReqresTestngAPIs;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.*;


import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.DataExtractor;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class HTTPRequests {
	int cusID;
	
//@Test(priority = 1)
	public void getUsers(){
		
		//https://reqres.in/api/users/2
		Response res=
				given()
				.contentType(ContentType.JSON)
		
		.when()
			.get("https://reqres.in/api/users?page=2");

		JSONObject jo =new JSONObject(res.asString());
	       for(int i=0;i<jo.getJSONArray("data").length();i++) 
	       {
 	   String cusName=jo.getJSONArray("data").getJSONObject(i).get("email").toString();
 	   System.out.println(cusName);
    }
		//res.prettyPrint();;
					
}

@Test(dataProviderClass = DataExtractor.class, dataProvider = "dataExtractor")
public void createUser(String name,String email, String desc) 
{
//	HashMap<String, String> reqBody = new HashMap<String, String>();
//	reqBody.put("name", "sharanya");
//	reqBody.put("email", "trainer");
	
//	String reqBody = "{\"name\":name, \"job\":email}";
	JSONObject requestParams = new JSONObject();
	requestParams.put("name",name);
	requestParams.put("email",email);
	requestParams.put("description",desc);
	
	Response res=given()
	.contentType("application/json")
	.body(requestParams)
	
	
	.when()			
	
		.post("https://reqres.in/api/users");
	
	String custID = res.jsonPath().get("id");
	System.out.println("Customer id is:"+ custID);
	
//	
//	.then()
//	.statusCode(201)
//	.log().all();
}

//@Test(priority = 3,dependsOnMethods = {"createUser"})
public void updateUser() 
{
	HashMap<String, String> reqBody = new HashMap<String, String>();
	reqBody.put("name", "sharanya");
	reqBody.put("job", "QA Engineer");
	
	Response res=given()
	.contentType("application/json")
	.body(reqBody)
	
	
	.when()			
	
		.put("https://reqres.in/api/users/"+cusID);
	AssertJUnit.assertEquals(res.getStatusCode(), 200);
	
	
	
	
}
//@Test(priority = 4)
public void deleteUser() 
{
	
	
	given()
	
	
	.when()			
	
		.delete("https://reqres.in/api/users/"+cusID)

	.then()
	    .statusCode(204);
	
	
	
}


}