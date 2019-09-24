package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class BasicAuthentication {
  @Test
  public void preemptiveAuthentication() {
	  
/*	  given()
	  .proxy("192.168.100.1",8081)
	  .auth()
	  .preemptive()
	  .basic("ToolsQA" ,  "TestPassword")
	  .when()
	         .get("http://restapi.demoqa.com/authentication/CheckForAuthentication/")
	         .then()
	            .statusCode(200);
  */
	  given()
	  .proxy("192.168.100.1",8081)
	  .when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication/")
	  .then()
	    .statusCode(200);
  }
}
