package org.hamropatro;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import java.util.Properties;

import static java.lang.Thread.sleep;

public class SegmentTest {
    private Properties properties;
    private  String url;
    private  String email;
    private  String password;

    public SegmentTest() {
       setLoginProperties();
    }
    void setLoginProperties(){
        properties = PropertiesProvider.getProperties();
        url= (String) properties.get("pushchimp.url");
        email=(String) properties.get("pushchimp.email");
        password=(String) properties.get("pushchimp.password");
    }
    @Test(priority = 1, alwaysRun = true)
    public void loginTest() throws InterruptedException {
        PropertiesProvider.loadProperties();
        setLoginProperties();
        var driver = DriverProvider.initializeChromeDriver();
        final LoginTest loginTest1 = new LoginTest(driver);
        loginTest1.login(url);
        loginTest1.enterCredentials(email, password);
        Thread.sleep(500);

    }
    @Test(priority = 2, alwaysRun = true, dependsOnMethods = "loginTest")
    public void createSegment() throws InterruptedException {
        System.out.println("Testing create segment");
        var driver = DriverProvider.initializeChromeDriver();
        driver.findElement(By.className("var driver = DriverProvider.initializeChromeDriver(url);")).click();

        sleep(5000);
        driver.findElement(By.className("ant-tabs-tab-btn")).click();

        // Click on the "Create Segment" button
        driver.findElement(By.xpath("//*[@id=\"rc-tabs-0-panel-segment\"]/div/div[1]/div/div/div/a")).click();


        // Fill in segment details
        driver.findElement(By.id("name")).sendKeys("Today");

        // Click on the "Save" button
        driver.findElement(By.className("ant-btn-primary")).click();

    }

    }



