package APIStepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;

    @Given("a JWT token is generated")
    public void a_jwt_token_is_generated() {
        RequestSpecification generateTokenRequest = given().
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"email\": \"adminEmail@test.com\",\n" +
                        "    \"password\": \"test123\"\n" +
                        "}");

        Response response = generateTokenRequest.when().post("/generateToken.php");

        // Storing a token in a global variable
        token = "Bearer " + response.jsonPath().getString("token");
        System.out.println(token);

    }

}
