package Day1;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

public class StudentAppAPICalls {
  @Test(enabled=false)
  public void f() {
	  given()
	  .when()
	  .get("http://localhost:9090/student/list").then().statusCode(200);
	  
	  Response R = given()
			                    .when()
			                     .get("http://localhost:9090/student/1"); // need record for one student
			                     
	  System.out.println(R.prettyPrint().toString());
	  String fname = R.jsonPath().get("firstName");
	  Assert.assertEquals((fname), "Vernon");
	  System.out.println(R.getTime());
  }
	  // FOR DELETING A RECORD
	 /* @Test
	  public void deleteCall()
	  {
		  given()
		  .when()
		  .get("http://localhost:9090/student/list").then().statusCode(200);
		  
		  Response R1 = given()
                  .when()
                   .delete("http://localhost:9090/student/100"); // need record for one student
		  System.out.println(R1.prettyPrint().toString());
		  System.out.println(R1.getTime()); 
	  }
	  
	  */
	  @Test
	  public void putCall()
	  {
		  
		 ArrayList<String> courses = new ArrayList<String>();
		 courses.add("Digital Communication");
		 courses.add("Computer Networking");
		 courses.add("Software Testing");
		 
		 Student st  =  new Student();
		 st.setFirstName("Abhimanyu");
		 st.setLastName("Singh");
		 st.setEmail("abhimanyusingh@gmail.com");
		 st.setProgramme("Photography");
		 st.setCourses(courses);
		 
		 
		 given()
		 .contentType(ContentType.JSON)
		 .when()
		    .body(st)
		    .put("http://localhost:9090/student/101")
		   .then()
		     .statusCode(200);
		 }
	  
	  
  
}
