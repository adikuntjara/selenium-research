package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class Login {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        driver = new ChromeDriver();

        // Initialize WebDriverWait instance with a 5-second timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open the saucedemo website
        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void loginSuccess() {
        // Print the page title
        System.out.println("Title of the page is: " + driver.getTitle());

        // Find the username field and enter the username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Find the password field and enter the password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Assert that the login was successful by checking if the inventory container is displayed
        WebElement inventoryContainer = driver.findElement(By.id("inventory_container"));
        Assert.assertTrue(inventoryContainer.isDisplayed(), "Inventory container is not displayed");

        // Assert that the page title is correct
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "The page title is incorrect!");
    }

    @Test(priority = 2)
    public void loginFailed() {
        // Print the page title
        System.out.println("Title of the page is: " + driver.getTitle());

        // Find the username field and enter the username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Find the password field and enter the password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("12345");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Assert that the login was unsuccessful by checking if the inventory container is displayed
        WebElement errorLogin = driver.findElement(By.xpath("//h3[@data-test='error'][contains(.,'Epic sadface: Username and password do not match any user in this service')]"));
        Assert.assertTrue(errorLogin.isDisplayed(), "Error Login is not displayed");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after each test method
        if (driver != null) {
            driver.quit();
        }
    }
}
