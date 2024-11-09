package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.testng.annotations.Test;

public class FirstScript {

        @Test
        public void loginTestCase() {

        WebDriver driver;
        WebDriverWait wait;

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

    }
}