package seleniumProject_JobsBoardSys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Apply_For_Job_Activity6 {
	

	
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
        
        //Search for a particular job and wait for listings to show
        WebElement SearchBox = driver.findElement(By.xpath("//input[@id='search_keywords']"));
        SearchBox.sendKeys("Banking");    
        WebElement submit = driver.findElement(By.xpath("//div[@class='search_submit']"));
        submit.click();
        
        //Click and open any one of the jobs listed
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='job_listings']/li[1]/a")));
        WebElement first_job = driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]/a"));        
        first_job.click();
        
        //Click the apply button and print the email to the console.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Apply for job']")));
        driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='job_application_email']")));
        System.out.println("To apply for this job email your details to " +driver.findElement(By.xpath("//a[@class='job_application_email']")).getText());
        
      //Close the browser
        driver.close();
        
	}
        
}
