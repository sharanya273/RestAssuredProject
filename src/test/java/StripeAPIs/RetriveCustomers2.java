package StripeAPIs;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;

import org.testng.annotations.Test;

import Utility.DataExtractor;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


public class RetriveCustomers2 {
	
	@Test
	public void getAllCustomers() {
		Response response =
		RestAssured
			.given()
				.contentType(ContentType.JSON)
				.baseUri("https://api.stripe.com/v1/customers")
				.auth().basic("sk_test_51MioahLAeG7FHEfYSAqjBK1QHfT70a6etVQ852SEyrYqxNssD7oT7hsLOtPFhrh6AU5KJKOShyh7sTwpcPcZHt1g00DBwQpTGX", "")
				.param("limit", 2)
			.when()
				.get()
			.then()
				.assertThat()
				.statusCode(200).log().all()
				.header("Content-Type", "application/json")
				.body("data[0].object", equalTo("customer"))
				.extract()
					.response();
		AssertJUnit.assertTrue(response.getBody().asString().contains("email"));
			
			
				
	}

}
