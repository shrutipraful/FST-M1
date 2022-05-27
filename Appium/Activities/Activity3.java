package activities;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity3 {
    // Declare Android driver
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "106c3126");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.miui.calculator");
        caps.setCapability("appActivity", ".cal.CalculatorActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
    }

    @Test
    public void add() {
        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_plus_s").click();
        driver.findElementById("btn_9_s").click();
        // Perform Calculation
        driver.findElementById("btn_equal_s").click();

        // Display Result
        String result = driver.findElementByXPath("//android.widget.LinearLayout[1]//android.widget.TextView[@resource-id='com.miui.calculator:id/result']").getText();
//        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println(result);
        Assert.assertEquals(result, "= 14");
    }

    @Test
    public void subtract() {
        driver.findElementById("btn_1_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_minus_s").click();
        driver.findElementById("btn_5_s").click();
        // Perform Calculation
        driver.findElementById("btn_equal_s").click();

        // Display Result
        String result = driver.findElementByXPath("//android.widget.LinearLayout[4]//android.widget.TextView[@resource-id='com.miui.calculator:id/result']").getText();
//        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println(result);
        Assert.assertEquals(result, "= 5");
    }

    @Test
    public void multiply() {
        driver.findElementById("btn_5_s").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementById("btn_1_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_0_s").click();
        // Perform Calculation
        driver.findElementById("btn_equal_s").click();

        // Display Result
        String result =driver.findElementByXPath("//android.widget.LinearLayout[3]//android.widget.TextView[@resource-id='com.miui.calculator:id/result']").getText();
        System.out.println(result);
        Assert.assertEquals(result, "= 500");
    }

    @Test
    public void divide() {
        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_div_s").click();
        driver.findElementById("btn_2_s").click();
        // Perform Calculation
        driver.findElementById("btn_equal_s").click();

        // Display Result
        String result = driver.findElementByXPath("//android.widget.LinearLayout[2]//android.widget.TextView[@resource-id='com.miui.calculator:id/result']").getText();
        System.out.println(result);
        Assert.assertEquals(result, "= 25");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}