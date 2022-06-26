package Api.com.api;


import io.restassured.http.ContentType;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Unit test for simple App.
 */
public class AuthTest {
    @Test(description = "To get the details of list projects", priority = 0)
    public void getUser() {

        // Given
        given()

                // When
                .when()
                .get("https://lk-api-test.awaed.co/v1/projects?page=1")

                // Then
                .then()
                .statusCode(200);
//                .statusLine("HTTP/1.1 200 OK")
//                // To verify booking id at index 3
//                .body("data.employee_name", equalTo("Garrett Winters"))
//                .body("message", equalTo("Successfully! Record has been fetched."));
    }

    @Test(description = "To create a new employee", priority = 1)
    public void createUser() {
        java.util.Date date = new java.util.Date();
        Timestamp ts = Timestamp.from(ZonedDateTime.now().toInstant());
        Long timestamp=ts.getTime()/1000;
        String dateTimeEpoch =String.valueOf(timestamp);//1655112901595  1655120073000

        JSONObject data = new JSONObject();
        data.put("phone", "+966538772716");
        data.put("password", "1111");
//        data.put("employee_name", "APITest","");
//        data.put("employee_salary", "99999","");
//        data.put("employee_age", "30","");


        // GIVEN
        HashMap map = new HashMap();
        map.put("X-Request-Timestamp", dateTimeEpoch);
        map.put("Accept-language", "ar");
        map.put("X-Request-id", "089534e3-7780-4957-b1b4-5b9323ce71bc");


        System.out.println(dateTimeEpoch);
        map.put("X-Client-Referrer", "api");


        given()
                .baseUri("https://lk-api-test.awaed.co")
                .contentType(ContentType.JSON)
                .headers(map)
                .body(data.toString())

                // WHEN
                .when()
                .post("/v1/login")

                // THEN
                .then().statusCode(200).log().all();
//                .statusCode(200)
        //.body("code",equalTo("900")
        System.out.println();
        ;
//
//               .body("data.employee_name", equalTo("APITest"))
//               .body("message", equalTo("Successfully! Record has been added."));

    }

}
	


