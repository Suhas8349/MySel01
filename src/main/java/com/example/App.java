package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        // Configure Chrome for Jenkins/Linux
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");          // modern headless mode
        options.addArguments("--no-sandbox");            // required in Jenkins/Linux
        options.addArguments("--disable-dev-shm-usage"); // avoids crashes
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // Pass options here
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        System.out.println("Login successful");

        driver.quit();
    }
}
