package Utility;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DataExtractor {
	
	//create 1 test case for post api
	
	@Test(dataProvider = "dataExtractor")
	public void CreateCustomer(String name, String email, String desc)
	
	{
		
		Response res = given().auth()
				.basic("sk_test_51MioahLAeG7FHEfYSAqjBK1QHfT70a6etVQ852SEyrYqxNssD7oT7hsLOtPFhrh6AU5KJKOShyh7sTwpcPcZHt1g00DBwQpTGX", "")
				.formParam("name", name)
				.formParam("email", email)
				.formParam("description",desc)
				.post("https://api.stripe.com/v1/customers");
		
		
		//res.prettyPrint();
		
		
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
	//	System.out.println("after 1");
		AssertJUnit.assertEquals(res.getStatusLine(), "HTTP/1.1 200 OK");
	//	System.out.println("after 2");
				
		
	}
	
	
	//create data provider method
	@DataProvider
	public String[][] dataExtractor() {
		
		//name, email, description
		
		//excels - rows and column
		// 3 rows and 2 column(name,email)
		
		//two dimensional array[][]
		
		//datatype- String, int, float, boolean
		//Object
		//String data
		
//		String testdata[][] = new String[2][3];
//		
//		//1st row 1st column - vaibhav
//		testdata[0][0] = "vaibhav";
//		
//		//1st row 2nd column - vaibhav@testing.com
//		testdata[0][1] = "vaibhav@testing.com";
//		
//		testdata[0][2] ="this is desc1";
//
//		//2 row 1st column - raj
//		
//		testdata[1][0] = "raj";
//		//2 row 2nd column - raj@testing.com
//		
//		testdata[1][1] = "raj@testing.com";
//		testdata[1][2] ="this is desc2";
		
		
		//add dependency for excel sheet
		//Java code to read a data from excel
		
		//Excel path(file)
		//get the sheetname
		//get the row count
		//get the col count
		//get the cell data
		ExcelReader excel = new ExcelReader("/Users/sharanyakadarla/eclipse-workspace/FirstProject/src/test/resources/TestData/CustomerDetails.xlsx");
		String sheetname = "Sheet1";
		
		int rowCount = excel.getRowCount(sheetname);
		int colCount = excel.getColumnCount(sheetname);
		
		String[][] testdata = new String[rowCount-1][colCount];
		
//		
//		testdata[0][0] = "";
//		testdata[0][1] = "";
//		testdata[0][2] = "";
//		
//		testdata[1][0] = "";
//		testdata[1][2] = "";
//		testdata[1][3] = "";
//		
//		testdata[1][0] = "";
//		testdata[1][2] = "";
//		testdata[1][3] = "";
//		
		//rows (2; 2<=9;2++)
		
		for(int rowNum=2; rowNum<=rowCount; rowNum++)
		{	
			//columns(0; 0<3 ; 0++)
			for(int colNum=0; colNum<colCount ; colNum++)
			{	
			
				testdata[rowNum-2][colNum] = excel.getCellData(sheetname, colNum, rowNum);				
				
			}
			
		}
		
//		
		
		
//		for(int i =1 ; i<10; i++)
//		{
//			System.out.println(i);
//			
//			//1
//		}
		
		
		
		
		
		
		
		return testdata;
		
	}
	

}
