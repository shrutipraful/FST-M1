package seleniumProject_JobsBoardSys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HeaderImage_url_Activity3 {

	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs"); 
          
        //Find header image url of the website using xpath()
        WebElement headerImageUrl = driver.findElement(By.xpath("//img[@itemprop='image']"));
        System.out.println("Page header image Url; is: " + headerImageUrl.getAttribute("src"));                  
        
        //Close the browser
        driver.close();
        
	}	
	
	
}
