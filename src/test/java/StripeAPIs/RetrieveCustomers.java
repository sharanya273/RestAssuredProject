package StripeAPIs;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;


import io.restassured.response.Response;

public class RetrieveCustomers {

	public static void main(String[] args) {

		// Rest API of Retrieve Customer
		// get method
		// https://api.stripe.com/v1/customers?limit=2
		// no body
		// authorization

		// Step1-> rest assured - import rest assured package
		// Step2-> specify your request
		// Step3-> Capture the response

//		Response res = given().get("https://api.stripe.com/v1/customers");	

//		Response res = given()
//				.auth()
//				.basic("sk_test_51MioahLAeG7FHEfYSAqjBK1QHfT70a6etVQ852SEyrYqxNssD7oT7hsLOtPFhrh6AU5KJKOShyh7sTwpcPcZHt1g00DBwQpTGX", "")
//				.get("https://api.stripe.com/v1/customers");

//		Response res = given().queryParam("limit", "2")
//				.queryParam("email", "sharanya1@test.com")
//				.auth()
//				.basic("sk_test_51MioahLAeG7FHEfYSAqjBK1QHfT70a6etVQ852SEyrYqxNssD7oT7hsLOtPFhrh6AU5KJKOShyh7sTwpcPcZHt1g00DBwQpTGX", "")
//				.get("https://api.stripe.com/v1/customers");
//		
		// headers
//		
		Response res = (given()
		// .queryParam("email", "sharanya1@test.com")
				
		)
				// .auth()
				// .basic("sk_test_51MioahLAeG7FHEfYSAqjBK1QHfT70a6etVQ852SEyrYqxNssD7oT7hsLOtPFhrh6AU5KJKOShyh7sTwpcPcZHt1g00DBwQpTGX",
				// "")
				.header("Authorization",
						"Basic c2tfdGVzdF81MU1pb2FoTEFlRzdGSEVmWVNBcWpCSzFRSGZUNzBhNmV0VlE4NTJTRXlyWXF4TnNzRDdvVDdoc0xPdFBGaHJoNkFVNUtKS09TaHloN3NUd3BjUGNaSHQxZzAwREJ3UXBUR1g6")
				 .header("Content-Type","application/json")
				.get("https://api.stripe.com/v1/customers");

		String custID = res.jsonPath().get("data[0].id");
		 System.out.println(custID);
		 res.prettyPrint();
		JSONObject jo = new JSONObject(res.asString());

		for (int i = 0; i < jo.getJSONArray("data").length(); i++) {
			String cusName = jo.getJSONArray("data").getJSONObject(i).get("name").toString();
			System.out.println(cusName);
		}

		 System.out.println(res);

	}

}
