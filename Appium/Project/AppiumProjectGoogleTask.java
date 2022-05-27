package project;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AppiumProjectGoogleTask {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "106c3126");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.splendapps.splendo");
        caps.setCapability("appActivity", ".MainActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 5);

   }

    @Test
    public void googleTask() {
    	//Click on add task
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Add Task']").click();    	
        // wait for page to load
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@resource-id='com.splendapps.splendo:id/edtTaskName']")));
    	driver.findElementByXPath("//android.widget.EditText[@resource-id='com.splendapps.splendo:id/edtTaskName']").sendKeys("Complete Activity with Google Tasks");    	
    	//Save
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Save Task']").click();  
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.splendapps.splendo:id/task_name']")));
    	String task1 = driver.findElementByXPath("//android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.splendapps.splendo:id/task_name']").getText();
    	// Assertion before scrolling
        Assert.assertEquals(task1,"Complete Activity with Google Tasks");
        
       	//Click on add task
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Add Task']").click();    	
        // wait for page to load
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@resource-id='com.splendapps.splendo:id/edtTaskName']")));
    	driver.findElementByXPath("//android.widget.EditText[@resource-id='com.splendapps.splendo:id/edtTaskName']").sendKeys("Complete Activity with Google Keep");    	
    	//Save
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Save Task']").click();  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.splendapps.splendo:id/task_name']")));
    	String task2 = driver.findElementByXPath("//android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.splendapps.splendo:id/task_name']").getText();
    	// Assertion before scrolling
        Assert.assertEquals(task2,"Complete Activity with Google Keep");
        
       	//Click on add task
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Add Task']").click();    	
        // wait for page to load
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@resource-id='com.splendapps.splendo:id/edtTaskName']")));
    	driver.findElementByXPath("//android.widget.EditText[@resource-id='com.splendapps.splendo:id/edtTaskName']").sendKeys("Complete the second Activity Google Keep");    	
    	//Save
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Save Task']").click(); 
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.splendapps.splendo:id/task_name']")));
    	String task3 = driver.findElementByXPath("//android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.splendapps.splendo:id/task_name']").getText();
    	// Assertion before scrolling
        Assert.assertEquals(task3,"Complete the second Activity Google Keep");
        }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}