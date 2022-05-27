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


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AppiumProjectGoogleKeep {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "106c3126");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 5);

   }

    @Test
    public void googleKeep() {
    	//Click on add Note
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc='New text note']").click(); 
    	//Add title
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@resource-id='com.google.android.keep:id/editable_title']")));
    	driver.findElementByXPath("//android.widget.EditText[@resource-id='com.google.android.keep:id/editable_title']").sendKeys("Note Title"); 
    	
        // wait for page to load
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@resource-id='com.google.android.keep:id/edit_note_text']")));
    	driver.findElementByXPath("//android.widget.EditText[@resource-id='com.google.android.keep:id/edit_note_text']").sendKeys("Test Note");    	
    	//Click on back and validate Note created
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
    	//Validate Note Desc
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/index_note_text_description']")));
    	String NoteDesc = driver.findElementByXPath("//android.widget.TextView[@resource-id='com.google.android.keep:id/index_note_text_description']").getText();
    	// Assertion before scrolling
        Assert.assertEquals(NoteDesc,"Test Note");
        
       //Validate Note Title  
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/index_note_title']")));
    	String NoteTitle = driver.findElementByXPath("//android.widget.TextView[@resource-id='com.google.android.keep:id/index_note_title']").getText();
    	// Assertion before scrolling
        Assert.assertEquals(NoteTitle,"Note Title");
        }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}