package com.bookit.step_definitions;

import com.bookit.pages.HomePage;
import com.bookit.pages.LogInPage;
import com.bookit.utilities.Driver;
import com.bookit.utilities.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UIStepDefs {
    @Given("User logged in to Bookit app as teacher role")
    public void user_logged_in_to_Bookit_app_as_teacher_role() {
        Driver.getDriver().get(Environment.URL);
        LogInPage logInPage = new LogInPage();
        logInPage.logIn(Environment.TEACHER_EMAIL,  Environment.TEACHER_PASSWORD);
    }

    @Given("User is on self page")
    public void user_is_on_self_page() {
        HomePage homePage = new HomePage();
        homePage.gotoSelf();
    }
}
