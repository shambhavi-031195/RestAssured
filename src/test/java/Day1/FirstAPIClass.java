package Day1;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import  io.restassured.RestAssured;
import  static  io.restassured.RestAssured.given;



public class FirstAPIClass {
  @Test
  public void f() {
//	  RestAssured.given()
	  Response response = RestAssured.given()
			  .proxy("192.168.100.1", 8081)
			  .get("https://parabank.parasoft.com/parabank/services/bank/customers/12212");
	  
	  
	  // Http status code
	  int status = response.statusCode();
	  System.out.println("Status code is "+ status);
	  System.out.println(response.prettyPrint().toString());
	  System.out.println(response.getTime());
	  Assert.assertEquals(status, 201);
  
/* give() > precondition> proxy
When() > user does something get()
 Then()  > Verification*/


  given()
   .proxy("192.168.100.1",8081)
   .when()
   .get("https://parabank.parasoft.com/parabank/services/bank/customers/12212")
   		.then()
   		.statusCode(200);
  }
  }
