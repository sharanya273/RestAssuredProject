package ReqresAPIs;

import static io.restassured.RestAssured.*;
import java.io.File;

import io.restassured.response.Response;

public class CreateCustomer {
	

	public static void main(String[] args) {
		
//		String reqBody = "{\"name\":\"Sharanya\", \"job\":\"tester\"}"; 
//		
//		Response res = given().body(reqBody).header("Content-Type","application/json")
//				.post("https://reqres.in/api/users");
//		

		
		// request body using json file
				
		Response res = given().body(new File(System.getProperty("user.dir")+"/src/test/java/ReqresAPIs/text.json"))
				.header("Content-Type","application/json")
		.post("https://reqres.in/api/users");
		
		res.prettyPrint();
	 
	}


}
