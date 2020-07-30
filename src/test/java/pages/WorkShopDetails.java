package pages;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import base.ActionUtils;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class WorkShopDetails extends ActionUtils{
	
	private By locationName = By.xpath("//h1[starts-with(@class,'locationName')]");
	private String dynamicLastAppointTime= "(//*[starts-with(@class,'dayName') and text()='DYNAMIC']/../div[starts-with(@class,'meeting')]/span[starts-with(@class,'meetingTime')])[last()]";
	private String dynamicFirstAppointTime = "(//*[starts-with(@class,'dayName') and text()='DYNAMIC']/../div[starts-with(@class,'meeting')]/span[starts-with(@class,'meetingTime')])[1]";
	private String dynamicPersonAppointments = "(//*[starts-with(@class,'dayName') and text()='DYNAMIC']/../div[starts-with(@class,'meeting')]/span[2])";
	
	public String getLocationName()
	{
		return getText(locationName);
	}

	public String getTodayLastAppointmentTime()
	{
		return getText(By.xpath(dynamicLastAppointTime.replace("DYNAMIC", getDayOfTheWeek())));
	}
	
	public String getTodayFirstAppointmentTime()
	{
		return getText(By.xpath(dynamicFirstAppointTime.replace("DYNAMIC", getDayOfTheWeek())));
	}
	
	public List<WebElement> getPersonAppointmentElements(String dayOfWeek)
	{
		return getElements(By.xpath(dynamicPersonAppointments.replace("DYNAMIC",dayOfWeek)));
	}
		
}
