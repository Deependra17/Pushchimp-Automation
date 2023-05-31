package org.hamropatro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverProvider {
    public static WebDriver initializeChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-aligns=*");
       WebDriver driver = new ChromeDriver(options);
       return driver;

    }
}
