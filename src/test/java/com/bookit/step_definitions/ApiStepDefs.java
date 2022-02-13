package com.bookit.step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static io.restassured.RestAssured.*;

public class ApiStepDefs {
    @Given("User logged in to Bookit api as teacher role")
    public void user_logged_in_to_Bookit_api_as_teacher_role() {

    }

    @Given("User sends GET request to {string}")
    public void user_sends_GET_request_to(String path) {

    }

    @Then("status code should be {int}")
    public void status_code_should_be(int expStatusCode) {

    }

    @Then("content type is {string}")
    public void content_type_is(String expContentType) {

    }
}
