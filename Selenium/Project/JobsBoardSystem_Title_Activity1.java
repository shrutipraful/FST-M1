package seleniumProject_JobsBoardSys;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JobsBoardSystem_Title_Activity1{
	
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs");
 
        //Print title of page and heading on page and  assert the Title
        System.out.println("Page title is: " + driver.getTitle());     
        Assert.assertEquals(driver.getTitle(), "Alchemy Jobs – Job Board Application", "Page Title doesnot match");
        
        //Close the browser
        driver.close();
        
	}	

}
