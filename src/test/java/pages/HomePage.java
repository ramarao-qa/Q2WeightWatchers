package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import base.ActionUtils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class HomePage extends ActionUtils{
	
	private By FindaWorkShop = By.xpath("//*[@icon='location']");
	
	public String getHomePageTitle()
	{
		return getPageTitle();
	}
	
	public void clickFindaWorkShop()
	{
		click(FindaWorkShop);
	}
	

}
