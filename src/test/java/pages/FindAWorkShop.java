package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.ActionUtils;

public class FindAWorkShop extends ActionUtils{
	
	private By enterLocation = By.id("location-search");
	private By firstTitle = By.xpath("(//*[@id='search-results']//div[starts-with(@class,'linkContainer')])[1]");
	private By firstDistance = By.xpath("(//*[@id='search-results']//span[starts-with(@class,'distance')])[1]");
	private By searchButton = By.id("location-search-cta");
	
	public void enterLocation(String text)
	{
		setText(enterLocation,text);
	}
	
	public void clickSearch()
	{
		click(searchButton);
	}
	
	public String getFindAWorkShopPageTitle()
	{
		return getPageTitle();
	}
	
	public String getFirstTitle()
	{
		return getText(firstTitle);
	}
	
	public void clickFirstTitle()
	{
		click(firstTitle);
	}
	
	public String getFirstDistance()
	{
		return getText(firstDistance);
	}
	
	
	

}
