package Api.com.api;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Unit test for simple App.
 */
public class DashboardTest
{
	@Test(description = "To get the details of list projects", priority = 0)
    public void getProjects() {
 
        // Given
        given().headers("X-Request-Id","7b5f5872-e87e-462f-ade7-2322256a5127","X-Request-Timestamp","1655025028.464"
                        )

         
        // When
        .when()
              .get("https://lk-api-stg.awaed.co/v1/projects?page=1")
                 
         // Then
         .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON);
//                .statusLine("HTTP/1.1 200 OK");
//                // To verify booking id at index 3
//                .body("data.employee_name", equalTo("Garrett Winters"))
//                .body("message", equalTo("Successfully! Record has been fetched."));
    }
    @Test(priority = 2)
    public void GetBodyProjects()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://lk-api-stg.awaed.co/v1";

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        // Make a GET request call directly by using RequestSpecification.get() method.
        // Make sure you specify the resource name.
        Response response = httpRequest.get("/projects?page=1");

        // Response.asString method will directly return the content of the body
        // as String.
        System.out.println("Response Body is =>  " + response.asString());
    }
    @Test(description = "To create a new employee", priority = 1)
    public void createProject() {
 
        JSONObject data = new JSONObject();
 
//        data.put("step", "1");
        data.put("phone", "+966556117531");
//        data.put("phone_country_code", "EG");
    //    data.put("email", "mohammed.h.fares2@gmail.com");
 
         
        // GIVEN
        given()
               .baseUri("https://lk-api-test.awaed.co/v1")
               .contentType(ContentType.JSON)
               .body(data.toString())
 
        // WHEN
        .when()
               .post("/register/verifyPhoneEmail")
 
        // THEN
        .then()
               .statusCode(200).body("code",equalTo("2201"));
//               .body("data.employee_name", equalTo("APITest"))
//               .body("message", equalTo("Successfully! Record has been added."));
 
    }
 
}
	


