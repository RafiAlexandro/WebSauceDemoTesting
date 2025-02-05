package stepDef;

import config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TC01_Login extends env {
    @Given("User open sauce demo url")
    public void userOpenSauceDemoUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(loginUrl);
    }

    @When("User input username {string} and password {string}")
    public void userInputUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Login successful")
    public void loginSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                    ExpectedConditions.urlToBe(inventoryUrl),
                    ExpectedConditions.textToBe(By.className("product_label"), "Products")
                )
        );
        driver.close();
        driver.quit();
    }

    @Then("Login failed with null data")
    public void loginFailedWithNullData() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(loginUrl),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"), "Epic sadface: Username is required")
                )
        );
        driver.close();
        driver.quit();
    }

    @Then("Login failed with null username")
    public void loginFailedWithNullUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(loginUrl),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"), "Epic sadface: Username is required")
                )
        );
        driver.close();
        driver.quit();
    }

    @Then("Login failed with null password")
    public void loginFailedWithNullPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(loginUrl),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"), "Epic sadface: Password is required")
                )
        );
        driver.close();
        driver.quit();
    }

    @Then("Login failed with wrong username")
    public void loginFailedWithWrongUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(loginUrl),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"), "Epic sadface: Username and password do not match any user in this service")
                )
        );
        driver.close();
        driver.quit();
    }

    @Then("Login failed with wrong password")
    public void loginFailedWithWrongPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(loginUrl),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"), "Epic sadface: Username and password do not match any user in this service")
                )
        );
        driver.close();
        driver.quit();
    }
}
