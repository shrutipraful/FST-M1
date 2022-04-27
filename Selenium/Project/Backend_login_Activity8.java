package seleniumProject_JobsBoardSys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Backend_login_Activity8 {
	
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin"); 
        
        //Visit the site’s backend and login with valid credentials
        WebElement username = driver.findElement(By.xpath("//input[@id='user_login']"));
        username.sendKeys("root");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='menu-dashboard']")));
        Assert.assertEquals(driver.getTitle(), "Dashboard ‹ Alchemy Jobs — WordPress", "Unable to Login");
        
        //Close the browser
        driver.close();
	
	
	}
	

}
