package seleniumProject_JobsBoardSys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SecondHeading_Activity4{

	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs"); 
          
        //Find second heading of the website using xpath()
        WebElement secondHeader = driver.findElement(By.xpath("//h2"));
        System.out.println("Page second heading is: " + secondHeader.getText());     
      
        //Find heading and assert
        Assert.assertEquals( secondHeader.getText(), "Quia quis non", "Page second Heading doesnot match with required text");
        
        //Close the browser
        driver.close();
        
	}	

	
	
}
