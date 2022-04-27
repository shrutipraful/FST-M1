package seleniumProject_JobsBoardSys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JobsBoardSys_Heading_Activity2{
	
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs"); 
          
        //Find heading of the website using xpath()
        WebElement header = driver.findElement(By.xpath("//h1[@class='entry-title']"));
        System.out.println("Page heading is: " + header.getText());     
      
        //Find heading and assert
        Assert.assertEquals( header.getText(), "Welcome to Alchemy Jobs", "Page Heading doesnot match with required text");
        
        //Close the browser
        driver.close();
        
	}	


}
