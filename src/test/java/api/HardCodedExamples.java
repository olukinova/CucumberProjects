package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

// FixMethodOrder is part of junit and sued to change order of method execution
// We will use a better approach later


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODU3NDQ2NDIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTc4Nzg0MiwidXNlcklkIjoiNTIyNyJ9.4WWvSJl_nudTO0hYqE7UqK3XblJafYPIbrkGsWiivAk";
    static String employee_id;
    @Test
public void acreateEmployee() {
    // prepare request
    RequestSpecification preparedRequest = given().
            header("Content-Type","application/json").
            header("Authorization",token).
            body("{\n" +
                    "  \"emp_firstname\": \"Moazz\",\n" +
                    "  \"emp_lastname\": \"Teach\",\n" +
                    "  \"emp_middle_name\": \"Mr\",\n" +
                    "  \"emp_gender\": \"F\",\n" +
                    "  \"emp_birthday\": \"2000-01-01\",\n" +
                    "  \"emp_status\": \"Confirmed\",\n" +
                    "  \"emp_job_title\": \"SDET Engineer\"\n" +
                    "}");

    // hitting the endpoint / send the request
    Response response = preparedRequest.when().post("/createEmployee.php");

    //verifying the assertions / get response
    response.then().assertThat().statusCode(201);

    response.prettyPrint();
        // hamcrest matchers: hamcrest is a popular framework to create matcher objects
        // it is used for writing tests and performs testing in programming.
        // Hamcrest is mainly used with other testing frameworks like junit
        // Hamcrest matchers: class that contains methods to perform assertions
        //  JsonPath vs JsonPath()
        //  JsonPath - is a Class and JsonPath() is a method that belongs to JsonPath class



        // We are capturing employee_id from response

        employee_id =  response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        response.then().assertThat().
                body("Employee.emp_firstname", equalTo("Moazz"));
        response.then().assertThat().
                body("Employee.emp_lastname", equalTo("Teach"));

        // verify the response headers
        response.then().assertThat().header("Content-Type", "application/json");
}
@Test
public void bgetCreatedEmployee() { //b letter means test will be executed in alphabetical order after
        // method that starts with letter a

        // prepare request
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id", employee_id);
// hitting the endpoint
    Response response = preparedRequest.when().get("/getOneEmployee.php");
    response.prettyPrint();
    //verify the response
    response.then().assertThat().statusCode(200);
    String tempEmpID = response.jsonPath().getString("employee.employee_id");

    // We have 2 emp ids, one is global and one is local
    Assert.assertEquals(employee_id, tempEmpID);
}

// in homework create a method to get all employee status and job title

    public void cupdateEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Steve\",\n" +
                        "  \"emp_lastname\": \"Jonahtan\",\n" +
                        "  \"emp_middle_name\": \"Mr\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2023-05-05\",\n" +
                        "  \"emp_status\": \"Fired\",\n" +
                        "  \"emp_job_title\": \"Looser\"\n" +
                        "}");
        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));

    }


    @Test
    public void dgetUpdatedEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

        // if you want to verify the body of the response
        // you can do it using hamcrest matchers

        //response.then().assertThat()
    }

}
