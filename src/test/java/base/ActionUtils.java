package base;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtils extends Base{
	
	
	private boolean retryingFindElement(By by) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 2) {
	        try {
	            driver.findElement(by);
	            result = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    return result;
	}

	
	public void click(By ele)
	{
		waitforElement(ele);
		getElement(ele).click();
	}
	
	public String getText(By ele)
	{
		waitforElement(ele);
		return getElement(ele).getText();
	}
	
	public void setText(By ele,String text)
	{
		waitforElement(ele);
		getElement(ele).sendKeys(text);
	}
	
	public WebElement getElement(By ele)
	{
		waitforElement(ele);
		if(retryingFindElement(ele)==true)
		{
			return driver.findElement(ele);
		}
		else {
		return driver.findElement(ele);
		}
	}
	
	public List<WebElement> getElements(By ele)
	{
		waitforElement(ele);
		return driver.findElements(ele);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getDayOfTheWeek()
	{
		return LocalDate.now().getDayOfWeek().name().substring(0,3).toUpperCase();
	}
	
	private void waitforElement(By ele)
	{
		wait(30).until(ExpectedConditions.presenceOfElementLocated(ele));
		wait(10).until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	
	public WebDriverWait wait(int seconds)
	{
		wait = new WebDriverWait(driver,seconds);
		return wait;
	}

}
