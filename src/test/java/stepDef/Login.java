package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
    @Given("User open sauce demo url")
    public void userOpenSauceDemoUrl() {
    }

    @When("User input username {string} and password {string}")
    public void userInputUsernameAndPassword(String arg0, String arg1) {
    }

    @And("User click login button")
    public void userClickLoginButton() {
    }

    @Then("Login successful")
    public void loginSuccessful() {
    }
}
