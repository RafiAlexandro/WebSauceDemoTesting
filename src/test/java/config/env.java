package config;

import org.openqa.selenium.WebDriver;

public class env {
    public static WebDriver driver;
    protected String loginUrl = "https://www.saucedemo.com/v1/";
    protected String inventoryUrl = "https://www.saucedemo.com/v1/inventory.html";
    protected String aboutUrl = "https://saucelabs.com/";
    protected String cartUrl = "https://www.saucedemo.com/v1/cart.html";
    protected String checkoutInfoUrl = "https://www.saucedemo.com/v1/checkout-step-one.html";
    protected String checkoutOverviewUrl = "https://www.saucedemo.com/v1/checkout-step-two.html";
    protected String checkoutCompleteUrl = "https://www.saucedemo.com/v1/checkout-complete.html";
}



