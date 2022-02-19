package com.bookit.step_definitions;

import com.bookit.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class HelloWorldApiStepDefs {

    public static final Logger LOG = LogManager.getLogger();

    Response response;

    @Given("User sends get request to hello world api")
    public void user_sends_get_request_to_hello_world_api() {

        LOG.info("Sending GET request to " + ConfigurationReader.getProperty("hello.world.api"));

        response = given().accept(ContentType.JSON)
                .when().get(ConfigurationReader.getProperty("hello.world.api"));

        LOG.info("Completed GET request to " +ConfigurationReader.getProperty("hello.world.api") + " with response " + response.asString());

    }

    @Then("status code is {int}")
    public void status_code_is(int expStatusCode) {

        if(response.statusCode() != expStatusCode) {
            LOG.error("Status code does not match the expected = " + response.statusCode());
        }else{
            LOG.info("Status code verification passed = " + response.statusCode());
        }
        assertEquals(expStatusCode , response.statusCode());
    }

    @Then("response body contains {string}")
    public void response_body_contains(String expValue) {
        response.prettyPrint();
        assertEquals(expValue, response.path("message"));
    }

}
