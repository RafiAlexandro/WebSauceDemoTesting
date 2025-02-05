package stepDef;

import config.env;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TC02_ProductsSort extends env {
    @Given("User already login")
    public void userAlreadyLogin() {
        TC01_Login login = new TC01_Login();
        login.userOpenSauceDemoUrl();
        login.userInputUsernameAndPassword("standard_user", "secret_sauce");
        login.userClickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(inventoryUrl),
                        ExpectedConditions.textToBe(By.className("product_label"), "Products")
                )
        );
    }

    @When("User click sort menu")
    public void userClickSortMenu() {
        driver.findElement(By.className("product_sort_container")).click();
    }

    @And("User click filter name a to z")
    public void userClickFilterNameAToZ() {
        driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[1]")).click();
    }

    @Then("Filter name a to z successful")
    public void filterNameAToZSuccessful() {
        // 1. Capture name before filtering and make ascending order
        List<WebElement> beforeFilterNameAToZ = driver.findElements(By.className("inventory_item_name"));
        // 1.1 Remove symbol if not needed and convert the string into double
        List<String> beforeFilterNameListAToZ = new ArrayList<>();

        for (WebElement atoz : beforeFilterNameAToZ) {
            beforeFilterNameListAToZ.add(atoz.getText().replace("Test.allTheThings() T-Shirt (Red)","Sauce Labs T-Shirt Red"));
        }

        // 2. Select the filter from dropdown
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Name (A to Z)");

        // 3. Capture name after filtering
        List<WebElement> afterFilterNameAToZ = driver.findElements(By.className("inventory_item_name"));
        // 3.1 Remove symbol if not needed and convert the string into double
        List<String> afterFilterNameListAToZ = new ArrayList<>();

        for (WebElement atoz : afterFilterNameAToZ) {
            afterFilterNameListAToZ.add(atoz.getText().replace("Test.allTheThings() T-Shirt (Red)","Sauce Labs T-Shirt Red"));
        }

        // Compare the values/Assert the values (sort the values of beforeFilterName
        Collections.sort(beforeFilterNameListAToZ); // It will sort the values in the list (Ascending orders)
        Assert.assertEquals(beforeFilterNameListAToZ, afterFilterNameListAToZ);

        driver.close();
        driver.quit();
    }

    @And("User click filter name z to a")
    public void userClickFilterNameZToA() {
        driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[2]")).click();
    }

    @Then("Filter name z to a successful")
    public void filterNameZToASuccessful() {
        // 1. Capture name before filtering and make ascending order
        List<WebElement> beforeFilterNameZToA = driver.findElements(By.className("inventory_item_name"));
        // 1.1 Remove symbol if not needed and convert the string into double
        List<Object> beforeFilterNameListZToA = new ArrayList<>().reversed();

        for (WebElement ztoa : beforeFilterNameZToA) {
            beforeFilterNameListZToA.add(ztoa.getText().replace("Test.allTheThings() T-Shirt (Red)","Sauce Labs T-Shirt Red"));
        }


        // 2. Select the filter from dropdown
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Name (Z to A)");

        // 3. Capture name after filtering
        List<WebElement> afterFilterNameZToA = driver.findElements(By.className("inventory_item_name"));
        // 3.1 Remove symbol if not needed and convert the string into double
        List<String> afterFilterNameListZToA = new ArrayList<>();

        for (WebElement ztoa : afterFilterNameZToA) {
            afterFilterNameListZToA.add(ztoa.getText().replace("Test.allTheThings() T-Shirt (Red)","Sauce Labs T-Shirt Red"));
        }

        // Compare the values/Assert the values (sort the values of beforeFilterName
        // Collections.reverse(beforeFilterNameListZToA); // It will sort the values in the list (Descending orders)
        Assert.assertEquals(beforeFilterNameListZToA, afterFilterNameListZToA);

        driver.close();
        driver.quit();
    }

    @And("User click filter price low to high")
    public void userClickFilterPriceLowToHigh() {
        driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[3]")).click();
    }

    @Then("Filter price low to high successful")
    public void filterPriceLowToHighSuccessful() {
        // 1. Capture name before filtering and make ascending order
        List<WebElement> beforeFilterPriceLoToHi = driver.findElements(By.className("inventory_item_price"));
        // 1.1 Remove symbol if not needed and convert the string into double
        List<Double> beforeFilterPriceListLoToHi = new ArrayList<>();

        for (WebElement lowhigh : beforeFilterPriceLoToHi) {
            beforeFilterPriceListLoToHi.add(Double.valueOf(lowhigh.getText().replace("$","")));
        }

        // 2. Select the filter from dropdown
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (low to high)");

        // 3. Capture name after filtering
        List<WebElement> afterFilterPriceLoToHi = driver.findElements(By.className("inventory_item_price"));
        // 3.1 Remove symbol if not needed and convert the string into double
        List<Double> afterFilterPriceListLoToHi = new ArrayList<>();

        for (WebElement lowhigh : afterFilterPriceLoToHi) {
            afterFilterPriceListLoToHi.add(Double.valueOf(lowhigh.getText().replace("$","")));
        }

        // Compare the values/Assert the values (sort the values of beforeFilterName
        Collections.sort(beforeFilterPriceListLoToHi); // It will sort the values in the list (Ascending orders)
        Assert.assertEquals(beforeFilterPriceListLoToHi, afterFilterPriceListLoToHi);

        driver.close();
        driver.quit();
    }

    @And("User click filter price high to low")
    public void userClickFilterPriceHighToLow() {
        driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[4]")).click();
    }

    @Then("Filter price high to low successful")
    public void filterPriceHighToLowSuccessful() {
        // 1. Capture name before filtering and make ascending order
        List<WebElement> beforeFilterPriceHiLo = driver.findElements(By.className("inventory_item_price"));
        // 1.1 Remove symbol if not needed and convert the string into double
        List<Double> beforeFilterPriceListHiLo = new ArrayList<>();

        for (WebElement highlow : beforeFilterPriceHiLo) {
            beforeFilterPriceListHiLo.add(Double.valueOf(highlow.getText().replace("$", "")));
        }

        // 2. Select the filter from dropdown
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (high to low)");

        // 3. Capture name after filtering
        List<WebElement> afterFilterPriceHiLo = driver.findElements(By.className("inventory_item_price"));
        // 3.1 Remove symbol if not needed and convert the string into double
        List<Double> afterFilterPriceListHiLo = new ArrayList<>();

        for (WebElement highlow : afterFilterPriceHiLo) {
            afterFilterPriceListHiLo.add(Double.valueOf(highlow.getText().replace("$", "")));
        }

        // Compare the values/Assert the values (sort the values of beforeFilterName
        Collections.sort(beforeFilterPriceListHiLo);
        Collections.reverse(beforeFilterPriceListHiLo); // It will sort the values in the list (Descending orders)
        Assert.assertEquals(beforeFilterPriceListHiLo, afterFilterPriceListHiLo);

        driver.close();
        driver.quit();
    }
}
