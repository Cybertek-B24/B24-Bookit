package com.bookit.step_definitions;


import com.bookit.pages.SelfPage;
import com.bookit.utilities.BookItApiUtil;
import com.bookit.utilities.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Map;

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

    @And("role is {string}")
    public void roleIs(String expRole) {
        JsonPath json = response.jsonPath();
        System.out.println("role = " + json.getString("role"));
        assertThat(json.getString("role") ,  is(expRole));
    }

    /**
     * {
     *     "id": 11516,
     *     "firstName": "Barbabas",
     *     "lastName": "Lyst",
     *     "role": "teacher"
     * }
     */

    @Then("User should see same info on UI and API")
    public void user_should_see_same_info_on_UI_and_API() {
        //read values into a map from api
        Map<String, Object> apiUserMap = response.body().as(Map.class);
        String apiFullname = apiUserMap.get("firstName")+" "+apiUserMap.get("lastName");
        System.out.println("apiFullname = " + apiFullname);

        //read values from UI using POM
        SelfPage selfPage = new SelfPage();
        String uiFullname = selfPage.fullName.getText();
        String uiRole = selfPage.role.getText();

        System.out.println("uiFullname = " + uiFullname);

        assertThat(uiFullname, equalTo(apiFullname));
        assertThat(uiRole, equalTo(apiUserMap.get("role")));
    }
}
