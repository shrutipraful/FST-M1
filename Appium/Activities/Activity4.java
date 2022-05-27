package activities;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity4 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "106c3126");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.dialer");
        caps.setCapability("appActivity", ".extensions.GoogleDialtactsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void addContact() {
        // Wait for app to load
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.FrameLayout[@content-desc='Contacts']/android.widget.FrameLayout")));    	
    	driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='Contacts']/android.widget.FrameLayout").click();
    	
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[@text='Create new contact']")));
        driver.findElementByXPath("//android.widget.TextView[@text='Create new contact']").click();
    	
//        // Click on add new contact floating button
//        driver.findElementByAccessibilityId("Create new contact").click();

        // Wait for fields to load
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='First name']")));

        // Find the first name, last name, and phone number fields
        MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
        MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Surname']");
        MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");

        // Enter the text in the fields
        firstName.sendKeys("Aaditya");
        lastName.sendKeys("Varma");
        phoneNumber.sendKeys("9991284782");

        // Save the contact
        driver.findElementByXPath("//android.widget.Button[@text='Save']").click();        
        

        // Wait for contact card to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='Aaditya Varma']")));

        // Assertion
        MobileElement mobileCard = driver.findElementByXPath("//android.widget.TextView[@text='Aaditya Varma']");
        Assert.assertTrue(mobileCard.isDisplayed());

        
        
    }
    
    

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
