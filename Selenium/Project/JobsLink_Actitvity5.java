package seleniumProject_JobsBoardSys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JobsLink_Actitvity5 {
	
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs"); 
        
        //Find navigation bar click on Jobs link
        WebElement JobsLink = driver.findElement(By.xpath("//a[starts-with(text(),'Jobs')]"));
        JobsLink.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("title")));
        System.out.println("Page Title " + driver.getTitle());    
        
        //Find page title and assert
        Assert.assertEquals( driver.getTitle(), "Jobs – Alchemy Jobs", "Page Title doesnot match with required text");
        
        //Close the browser
        driver.close();
    
	}

}
