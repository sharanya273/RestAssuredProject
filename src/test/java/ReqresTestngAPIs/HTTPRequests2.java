package ReqresTestngAPIs;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class HTTPRequests2 {
	int cusID;

	@Test(priority = 2)

	public void createUser() {
		JSONObject reqBody = new JSONObject();
		reqBody.put("name", "priya");
		reqBody.put("location", "sydney");
		reqBody.put("phone", "12345");
		String coursesArr[] = { "C", "C++" };
		reqBody.put("courses", "courseArr");

		Response res = given().contentType("application/json").body(reqBody)

				.when()

				.post("https://reqres.in/api/users");
		System.out.println(res.toString());

//	
//	.then()
//	.statusCode(201)
//	.log().all();
	}

}