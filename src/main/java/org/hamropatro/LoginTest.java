package org.hamropatro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class LoginTest {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginTest(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String URL) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(URL);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/switch/div/div/div/button")).click();
    }
    public void enterCredentials(String Email, String password) {
        String parentHandle = driver.getWindowHandle();
        System.out.println("parent window -" + parentHandle);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            System.out.println(handle);

            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                System.out.println("User is on the new window");


                By xpathSelector = By.xpath("//*[@id='identifierId']");
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpathSelector));
                element.sendKeys(Email);

                driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();


                By cssSelector = By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input");
                WebElement Password = wait.until(ExpectedConditions.presenceOfElementLocated(cssSelector));

                Password.sendKeys(password);

                driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();
                System.out.println("User logged in successfully");
                driver.switchTo().window(parentHandle);
                System.out.println(parentHandle);
                System.out.println("user is on the parent window");

            }
        }
    }
}


