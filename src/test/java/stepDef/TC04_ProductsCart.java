package stepDef;

import config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TC04_ProductsCart extends env {
    @When("User click add to cart")
    public void userClickAddToCart() {
        driver.findElement(By.className("btn_primary")).click();
    }

    @Then("User direct to cart page and product displayed in cart")
    public void UserDirectToCartPageAndProductDisplayedInCart() {

        // Selected Product
        WebElement selectedProductName = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        WebElement selectedProductDesc = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div"));
        WebElement selectedProductPrice = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/div"));

        List<String> selectedProduct = new ArrayList<>();

        selectedProduct.add(selectedProductName.getText());
        selectedProduct.add(selectedProductDesc.getText());
        selectedProduct.add(selectedProductPrice.getText().replace("Products", "29.99"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.and(

                        ExpectedConditions.textToBePresentInElementLocated(By.className("btn_secondary"), "REMOVE"),
                        ExpectedConditions.attributeContains(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"), "class", "shopping_cart_badge"),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"), "1"),
                        ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))

                )
        );

        driver.findElement(By.className("shopping_cart_link")).click();

        wait.until(
                ExpectedConditions.urlToBe(cartUrl) // Cart Page
        );

        // Displayed Product
        WebElement displayedProductName = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        WebElement displayedProductDesc = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]"));
        WebElement displayedProductPrice = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div"));

        List<String> displayedProduct = new ArrayList<>();

        displayedProduct.add(displayedProductName.getText());
        displayedProduct.add(displayedProductDesc.getText());
        displayedProduct.add(displayedProductPrice.getText());

        Assert.assertEquals(selectedProduct, displayedProduct);

        driver.close();
        driver.quit();
    }

    @And("User click remove")
    public void userClickRemove() {
        driver.findElement(By.className("btn_secondary")).click();
    }

    @And("User click cart icon")
    public void userClickCartIcon() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @And("User direct to cart page")
    public void userDirectToCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe(cartUrl),
                        ExpectedConditions.textToBe(By.className("subheader"), "Your Cart")
                )
        );
    }

    @Then("Product removed from cart")
    public void productRemovedFromCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.invisibilityOfElementLocated(By.className("inventory_item_name")),
                        ExpectedConditions.invisibilityOfElementLocated(By.className("inventory_item_desc")),
                        ExpectedConditions.invisibilityOfElementLocated(By.className("inventory_item_price"))
                )
        );

        driver.close();
        driver.quit();
    }

    @When("User continue shopping")
    public void userContinueShopping() {
        driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[1]")).click();
    }

    @And("User add more product")
    public void userAddMoreProduct() {
        driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button")).click();
    }

    @Then("Other product added in cart")
    public void otherProductAddedInCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"item_0_title_link\"]/div"), "Sauce Labs Bike Light"),
                        ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[1]"), "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."),
                        ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div"), "9.99"),
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")),
                        ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"), "2")
                )
        );

        driver.close();
        driver.quit();
    }

    @When("User select product")
    public void userSelectProduct() {
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).click();
    }

    @And("User direct to product detail page")
    public void userDirectToProductDetailPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/inventory-item.html?id=4")
                )
        );
    }

    @Then("Product added in cart")
    public void productAddedInCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"item_4_title_link\"]/div"), "Sauce Labs Backpack"),
                        ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]"), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."),
                        ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div"), "29.99")
                )
        );
    }

    @When("User click remove from product detail")
    public void userClickRemoveFromProductDetail() {
        driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/button")).click();
    }
}
