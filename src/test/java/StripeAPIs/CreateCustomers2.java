package StripeAPIs;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class CreateCustomers2 {
	
@Test
	public void CreateCustomers() {
		
       Response res=given().auth().basic("sk_test_51MioahLAeG7FHEfYSAqjBK1QHfT70a6etVQ852SEyrYqxNssD7oT7hsLOtPFhrh6AU5KJKOShyh7sTwpcPcZHt1g00DBwQpTGX", "")
		.formParam("name", "Priya")
		.formParam("invoice_settings[footer]", "This is footer")
		.formParam("address[country]", "Australia")
		.formParam("preferred_locales[0]", "Telugu")
		.formParam("preferred_locales[1]", "English")
		.formParam("invoice_settings[custom_fields][0][name]", "Jhon")
		.formParam("invoice_settings[custom_fields][0][value]", "1234")
		.post("https://api.stripe.com/v1/customers");
       String custID = res.jsonPath().get("id");
       System.out.println(custID);
       
       //res.prettyPrint();
	 
	}


}
