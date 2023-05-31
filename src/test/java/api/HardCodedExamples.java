package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ4ODc4MzksImlzcyI6ImxvY2FsaG9zdCIs" +
                   "ImV4cCI6MTY4NDkzMTAzOSwidXNlcklkIjoiNTIyNyJ9.rg0j_T46wq3OrnUXjV2S8LXIUpHXmUrmnKDxkPoxJaQ";

    @Test
public void createEmployee() {
    // prepare request
    RequestSpecification preparedRequest = given().
            header("Content-Type","application/json").
            header("Authorization",token).
            body("{\n" +
                    "  \"emp_firstname\": \"Moaz\",\n" +
                    "  \"emp_lastname\": \"Teach\",\n" +
                    "  \"emp_middle_name\": \"Mr\",\n" +
                    "  \"emp_gender\": \"F\",\n" +
                    "  \"emp_birthday\": \"2000-01-88\",\n" +
                    "  \"emp_status\": \"Confirmed\",\n" +
                    "  \"emp_job_title\": \"SDET Engineer\"\n" +
                    "}");

    // hitting the endpoint / send the request
    Response response = preparedRequest.when().post("/createEmployee.php");

    //verifying the assertions / get response
    response.then().assertThat().statusCode(201);

    response.prettyPrint();

}
}
