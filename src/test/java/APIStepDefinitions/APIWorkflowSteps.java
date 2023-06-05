package APIStepDefinitions;

import Utils.APIConstants;
import Utils.APIPayloadConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class APIWorkflowSteps {
    RequestSpecification request;
    Response response;
    public static String employee_id;
 // ----------------------------------------------
    // making request with usual payload
    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
       request = given().
               header(APIConstants.HEADER_KEY_CONTENT_TYPE
                       ,APIConstants.HEADER_VALUE_CONTENT_TYPE).
               header(APIConstants.HEADER_KEY_AUTHORIZATION, GenerateTokenSteps.token).
               body(APIPayloadConstants.createEmployeePayload());
    }
    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
        response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
    }
    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(Integer expectedStatusCode) {
        //argument or value is coming from feature file
        //int1 is just the name of the parameter, you can use any name
        response.then().assertThat().statusCode(expectedStatusCode);
        response.prettyPrint();
    }

    @Then("the employee contains key {string} and value {string}")
    public void the_employee_contains_key_and_value(String message, String value) {
        response.then().assertThat().body(message, equalTo(value));

    }
    @Then("the employee id {string} is  stored as a global variable to be used for the other calls")
    public void the_employee_id_is_stored_as_a_global_variable_to_be_used_for_the_other_calls(String string) {
        //this path of employee id comes from feature file
        employee_id = response.jsonPath().getString(string);
        System.out.println(employee_id);
    }


    //--------------------------------------------
    // another request using json payload

    @Given("a request is prepared to create an employee using json payload")
    public void a_request_is_prepared_to_create_an_employee_using_json_payload() {
        request = given().
                header(APIConstants.HEADER_KEY_CONTENT_TYPE
                        ,APIConstants.HEADER_VALUE_CONTENT_TYPE).
                header(APIConstants.HEADER_KEY_AUTHORIZATION, GenerateTokenSteps.token).
                body(APIPayloadConstants.createEmployeePayloadJson());
    }


}
