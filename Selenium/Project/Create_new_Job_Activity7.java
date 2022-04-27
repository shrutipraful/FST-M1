package seleniumProject_JobsBoardSys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Create_new_Job_Activity7 {
	
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs"); 
        
        //Locate the navigation menu and click the menu item that says “Post a Job”
        WebElement PostJob = driver.findElement(By.xpath("//a[contains(text(),'Post a Job')]"));
        PostJob.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Sign in')]")));
        
        //Fill in the necessary details and click the button that says “Preview”.
        driver.findElement(By.xpath("//input[@id='create_account_email']")).sendKeys("fst_sel_batch_31@gmail.com");
        driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys("Test Specialist");
        driver.findElement(By.xpath("//input[@id='job_location']")).sendKeys("Bangalore");
        driver.switchTo().frame("job_description_ifr");
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("QA");
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//input[@id='application']")).sendKeys("http://QA3.com");
        driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("QA3Company");
        driver.findElement(By.xpath("//input[@id='company_website']")).sendKeys("http://QA3.com");
        driver.findElement(By.xpath("//input[@id='company_tagline']")).sendKeys("Testing services");
        driver.findElement(By.xpath("//input[@id='company_video']")).sendKeys("http://testvideo.com");
        driver.findElement(By.xpath("//input[@id='company_twitter']")).sendKeys("test@qa3");
        driver.findElement(By.xpath("//input[@id='company_logo']")).sendKeys("C:\\Users\\ShrutiN\\Desktop\\logo.jpg");
        driver.findElement(By.xpath("//input[@value='Preview']")).click();
                
        //Submit Listing
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='job_preview_submit_button']")));
        driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
        
        //Find navigation bar click on Jobs link and verify job posted successfully
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[starts-with(text(),'Jobs')]")));
        WebElement JobsLink = driver.findElement(By.xpath("//a[starts-with(text(),'Jobs')]"));
        JobsLink.click();          
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='job_listings']/li[1]/a")));
        
        //Search for the job posted using company name as search key
        WebElement SearchBox = driver.findElement(By.xpath("//input[@id='search_keywords']"));
        SearchBox.sendKeys("QA3");    
        WebElement submit = driver.findElement(By.xpath("//div[@class='search_submit']"));
        submit.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='job_listings']/li[1]/a")));
        WebElement first_job = driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]/a/img"));        
        Assert.assertEquals(first_job.getAttribute("alt"), "QA3Company", "Job posting unsuccessful");  
    
    
        //Close the browser
        driver.close();
	}

}
