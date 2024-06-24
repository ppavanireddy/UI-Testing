package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver dr;

    // Constructor
    public HomePage(WebDriver dr) {
        this.dr = dr;
    }
    
    public void clickFirstLink()
	{
    	WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
    	WebElement firstLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='https://www.getcalley.com/']")));
		firstLink.click();
	}
    
    public void clicksecondLink()
	{
    	WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
    	WebElement secondLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'https://www.getcalley.com/calley-call-from-browser')]")));
    	secondLink.click();
	}
    
    
    public void clickthirdLink()
	{
    	WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		WebElement thirdLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='https://www.getcalley.com/calley-pro-features/']")));
		thirdLink.click();
	}
    
    public void clickforthLink()
	{
    	WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		WebElement forthLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='https://www.getcalley.com/best-auto-dialer-app/']")));
		forthLink.click();
	}

    public void clickfifthLink()
	{
    	WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		WebElement fifthLink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'https://www.getcalley.com/how-calley-auto-dialer-a')]")));
		fifthLink.click();
	}
    
    
}