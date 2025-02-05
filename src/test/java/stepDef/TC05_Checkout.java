package stepDef;

import config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC05_Checkout extends env {
    @And("User click checkout")
    public void userClickCheckout() {
        driver.findElement(By.className("checkout_button")).click();
    }

    @Then("User direct to checkout info page")
    public void userDirectToCheckoutInfoPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(checkoutInfoUrl),
                        ExpectedConditions.textToBe(By.className("subheader"), "Checkout: Your Information")
                )
        );
    }

    @When("User input first name {string} and last name {string} and postal code {string}")
    public void userInputFirstNameAndLastNameAndPostalCode(String firstname, String lastname, String postcode) {
        driver.findElement(By.id("first-name")).sendKeys(firstname);
        driver.findElement(By.id("last-name")).sendKeys(lastname);
        driver.findElement(By.id("postal-code")).sendKeys(postcode);
    }

    @And("User click continue")
    public void userClickContinue() {
        driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")).click();
    }

    @Then("User direct to checkout overview page and product displayed")
    public void userDirectToCheckoutOverviewPageAndProductDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(checkoutOverviewUrl),
                        ExpectedConditions.textToBe(By.className("subheader"), "Checkout: Overview"),
                        ExpectedConditions.textToBePresentInElementLocated(By.className("inventory_item_name"), "Sauce Labs Backpack"),
                        ExpectedConditions.textToBePresentInElementLocated(By.className("inventory_item_desc"), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."),
                        ExpectedConditions.textToBePresentInElementLocated(By.className("inventory_item_price"), "29.99"),
                        ExpectedConditions.textToBePresentInElementLocated(By.className("summary_total_label"), "32.39")
                )
        );
    }

    @When("User click finish")
    public void userClickFinish() {
        driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]")).click();
    }

    @Then("User direct to checkout complete page")
    public void userDirectToCheckoutCompletePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
            ExpectedConditions.urlToBe(checkoutCompleteUrl)
        );

        driver.close();
        driver.quit();
    }

    @Then("User cannot direct to checkout info page")
    public void userCannotDirectToCheckoutInfoPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.urlToBe(cartUrl)
        );

        driver.close();
        driver.quit();
    }

    @Then("User get error message first name required")
    public void userGetErrorMessageFirstNameRequired() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(checkoutInfoUrl),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/h3"), "Error: First Name is required")
                )
        );

        driver.close();
        driver.quit();
    }

    @Then("User get error message last name required")
    public void userGetErrorMessageLastNameRequired() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(checkoutInfoUrl),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/h3"), "Error: Last Name is required")
                )
        );

        driver.close();
        driver.quit();
    }

    @Then("User get error message postal code required")
    public void userGetErrorMessagePostalCodeRequired() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(checkoutInfoUrl),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/h3"), "Error: Postal Code is required")
                )
        );

        driver.close();
        driver.quit();
    }

    @Then("User get error message postal code must be number")
    public void userGetErrorMessagePostalCodeMustBeNumber() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(checkoutInfoUrl),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/h3"), "Error: Postal Code must be number")
                )
        );

        driver.close();
        driver.quit();
    }

    @When("User click cancel")
    public void userClickCancel() {
        driver.findElement(By.className("cart_cancel_link")).click();
    }

    @Then("Cancel checkout success and direct to cart page")
    public void cancelCheckoutSuccessAndDirectToCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.urlToBe(cartUrl)
        );

        driver.close();
        driver.quit();
    }
}
