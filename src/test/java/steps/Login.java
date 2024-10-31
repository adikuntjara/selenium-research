package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.testng.Assert;


public class Login {

    public void loginTestCase() {

        WebDriver driver;
        WebDriverWait wait;

        // Mengatur WebDriverManager untuk menangani setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Membuat instance dari ChromeDriver
        driver = new ChromeDriver();

        // Membuat instance dari WebDriverWait dengan waktu tunggu secara explicit wait (misalnya, 5 detik)
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Full screen browser window
        driver.manage().window().maximize();

        // Membuka halaman Google
        driver.get("https://www.saucedemo.com/");

        // Print judul halaman
        System.out.println("Title of the page is: " + driver.getTitle());

        // Mencari field username dan memasukkan username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Mencari field password dan memasukkan password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Mencari button login dan click
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Assert jika login telah sukses dengan mengecek bahwa inventory container sudah tampil
        WebElement inventoryContainer = driver.findElement(By.id("inventory_container"));
        Assert.assertTrue(inventoryContainer.isDisplayed(), "Inventory container is not displayed");

        // Menutup browser
        driver.quit();
    }
}
