package Day1;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Auth {
  @Test(enabled=false)
  public void f() 
	  
  {
	   given().proxy("192.168.100.1",8081)
	   .auth()
	   .oauth2("c6974eb74c67cd3b360b401c5abe79060230a5a6")
	 .when()
	 .post("http://coop.apps.symfonycasts.com/api/425/chickens-feed")
	 .then()
	   .statusCode(200);
	  
	  
	  
  }
  @Test(enabled=true)
  public void f2()
  {
  
  Response R=  given()
			.proxy("192.168.100.1",8081)
	  .formParam("client_id", "Ramsy")
	  .formParam("client_secret","4b6eef3aff2d26d28a8f2d033f8ec5e6")
	  .formParam("grant_type","client_credentials")
	 .when()
	   .post("http://coop.apps.symfonycasts.com/token");
	  System.out.println(R.jsonPath().prettify());
	  
	 String token= R.jsonPath().get("access_token");
	 System.out.println("Token is"+token);
	 
	 // Using generated token
	 
	 given()
		.proxy("192.168.100.1",8081)
		.auth()
		.oauth2(token)
		.when()
		 .post("http://coop.apps.symfonycasts.com/api/425/chickens-feed")
		 .then()
		   .statusCode(200);
	 
	 
	 

}
}
