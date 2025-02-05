package stepDef;

import config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC03_ProductsMenu extends env {
    @When("User click hamburger menu button")
    public void userClickHamburgerMenuButton() {
        driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button")).click();
    }

    @And("User click all items")
    public void userClickAllItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]")),
                        ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"inventory_sidebar_link\"]"))
                )
        );
        driver.findElement(By.xpath("//*[@id=\"inventory_sidebar_link\"]")).click();
    }

    @Then("User direct to all items page")
    public void userDirectToAllItemsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/allitems.html")
                )
        );

        driver.close();
        driver.quit();
    }

    @And("User click about")
    public void userClickAbout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]")),
                        ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"about_sidebar_link\"]"))
                )
        );

        driver.findElement(By.xpath("//*[@id=\"about_sidebar_link\"]")).click();
    }

    @Then("User direct to about page")
    public void userDirectToAboutPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(aboutUrl)
                )
        );

        driver.close();
        driver.quit();
    }

    @And("User click reset app state")
    public void userClickResetAppState() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]")),
                        ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"reset_sidebar_link\"]"))
                )
        );

        driver.findElement(By.xpath("//*[@id=\"reset_sidebar_link\"]")).click();
    }

    @Then("Reset app state successful")
    public void resetAppStateSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(loginUrl)
                )
        );

        driver.close();
        driver.quit();
    }
}
