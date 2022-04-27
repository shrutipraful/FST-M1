package seleniumProject_JobsBoardSys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Create_Job_Listing_Activity9 {
	
	public static void main(String[] args) throws InterruptedException {
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
        
        //Locate the left hand menu and click the menu item that says “Job Listings”.
        driver.findElement(By.xpath("//li[@id='menu-posts-job_listing']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='page-title-action']")));
        
        //Locate the “Add New” button and click it, Fill the necessary details.
        driver.findElement(By.xpath("//a[@class='page-title-action']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@class='editor-post-title__input']")));
        driver.findElement(By.xpath("//textarea[@class='editor-post-title__input']")).sendKeys("Test Specialist");
        driver.findElement(By.xpath("//input[@id='_company_website']")).sendKeys("http://PRSTest.co.in");
        driver.findElement(By.xpath("//input[@id='_company_twitter']")).sendKeys("PRS@Test");
        driver.findElement(By.xpath("//input[@id='_job_location']")).sendKeys("Bangalore");
        driver.findElement(By.xpath("//input[@id='_company_name']")).sendKeys("PRS Test");
        driver.findElement(By.xpath("//input[@id='_company_tagline']")).sendKeys("PRS Testing Services");
        driver.findElement(By.xpath("//input[@id='_company_video']")).sendKeys("http://PRSTesting/Video");
        driver.findElement(By.xpath("//input[@id='_filled']")).click();
        driver.findElement(By.xpath("//input[@id='_featured']")).click();
        driver.findElement(By.xpath("//input[@id='_job_expires']")).sendKeys("May 30,2022");
        
        //Click the “Publish” button.
        driver.findElement(By.xpath("//button[contains(text(),'Publish')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='editor-post-publish-panel__content']")));
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']")).click();
        
        //Verify that the job listing was created
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'View Job')]")));
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'View Job')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500); 
        driver.findElement(By.xpath("//a[contains(text(),'View Job')]")).click();
        WebElement first_job = driver.findElement(By.xpath("//div[@class='company']/img"));        
        Assert.assertEquals(first_job.getAttribute("alt"), "PRS Test", "Job posting unsuccessful");          
        
        //Close the browser
          driver.close();
        
	}

}
