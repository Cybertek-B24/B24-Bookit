package com.bookit.step_definitions;


import com.bookit.utilities.BookItApiUtil;
import com.bookit.utilities.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ApiStepDefs {

    String accessToken;
    Response response;

    @Given("User logged in to Bookit api as teacher role")
    public void user_logged_in_to_Bookit_api_as_teacher_role() {
        accessToken = BookItApiUtil.getAccessToken(Environment.TEACHER_EMAIL, Environment.TEACHER_PASSWORD);
        System.out.println("Teacher email = " + Environment.TEACHER_EMAIL);
        System.out.println("Teacher password = " +  Environment.TEACHER_PASSWORD);
    }

    @Given("User sends GET request to {string}")
    public void user_sends_GET_request_to(String path) {
        response = given().accept(ContentType.JSON)
                .and().header("Authorization", accessToken)
                .when().get(Environment.BASE_URL + path);
        System.out.println("API Endpoint = " + Environment.BASE_URL + path);
        response.prettyPrint();
    }

    @Then("status code should be {int}")
    public void status_code_should_be(int expStatusCode) {
        assertThat(response.statusCode(), equalTo(expStatusCode));
    }

    @Then("content type is {string}")
    public void content_type_is(String expContentType) {
        assertThat(response.contentType(), equalTo(expContentType));
    }
}
