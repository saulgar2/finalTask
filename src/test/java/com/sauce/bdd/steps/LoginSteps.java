package com.sauce.bdd.steps;

import com.sauce.bdd.pages.InventoryPage;
import com.sauce.bdd.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSteps {
    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    private final LoginPage login = new LoginPage();
    private InventoryPage inventory;

    @Given("I launch the SauceDemo site {string}")
    public void i_launch_the_sauce_demo_site(String url) {
        log.info("Opening URL: {}", url);
        login.open(url);
    }

    @When("I type any credentials into username and password")
    public void i_type_any_credentials_into_username_and_password() {
        log.info("Typing dummy credentials");
        login.typeUsername("anyUser");
        login.typePassword("anyPass");
    }

    @And("I clear the inputs")
    public void i_clear_the_inputs() {
        log.info("Clearing username and password inputs");
        login.clearUsername();
        login.clearPassword();
        Assertions.assertTrue(login.isUsernameEmpty(), "Username should be empty after clear");
        Assertions.assertTrue(login.isPasswordEmpty(), "Password should be empty after clear");
    }

    @And("I click the Login button")
    public void i_click_the_login_button() {
        log.info("Clicking Login");
        login.clickLogin();
    }

    @Then("I should see username required error")
    public void i_should_see_username_required_error() {
        String err = login.getErrorText();
        log.info("Error shown: {}", err);
        Assertions.assertTrue(err.toLowerCase().contains("username is required"),
                "Expected 'Username is required' but got: " + err);
    }

    @When("I type {string} into username")
    public void i_type_into_username(String user) {
        log.info("Typing username: {}", user);
        login.typeUsername(user);
    }

    @And("I type {string} into password")
    public void i_type_into_password(String pass) {
        log.info("Typing password: ****");
        login.typePassword(pass);
    }

    @And("I clear only the password input")
    public void i_clear_only_the_password_input() {
        log.info("Clearing only the password input");
        login.clearPassword();
        Assertions.assertTrue(login.isPasswordEmpty(), "Password should be empty after clear");
    }

    @Then("I should see password required error")
    public void i_should_see_password_required_error() {
        String err = login.getErrorText();
        log.info("Error shown: {}", err);
        Assertions.assertTrue(err.toLowerCase().contains("password is required"),
                "Expected 'Password is required' but got: " + err);
    }

    @When("I login with accepted username {string} and password {string}")
    public void i_login_with_accepted_username_and_password(String user, String pass) {
        log.info("Logging in with user {}", user);
        login.typeUsername(user);
        login.typePassword(pass);
        login.clickLogin();
    }

    @Then("I should be on the dashboard with title {string}")
    public void i_should_be_on_the_dashboard_with_title(String expectedTitle) {
        inventory = new InventoryPage();
        String actual = inventory.getAppTitle();
        log.info("Dashboard title: {}", actual);
        Assertions.assertEquals(expectedTitle, actual, "Dashboard title mismatch");
    }
}