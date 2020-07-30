package test;
import org.testng.annotations.Test;

import base.Base;
import pages.FindAWorkShop;
import pages.HomePage;
import pages.WorkShopDetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WeightWatchers extends Base{
	
	HomePage hp=new HomePage();
	FindAWorkShop fw=new FindAWorkShop();
	WorkShopDetails wd=new WorkShopDetails();
	
	@Test
	void wwTestOne() {		
		//2. Verify loaded page title matches “WW (Weight Watchers): Weight Loss &amp; Wellness Help”
		Assert.assertEquals(hp.getHomePageTitle(), "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA");
		
		//3. On the right corner of the page, click on “Find a Studio”
		hp.clickFindaWorkShop();
		
		//4. Verify loaded page title contains “Find WW Studios &amp; Meetings Near You | WW USA”
		Assert.assertEquals(fw.getFindAWorkShopPageTitle(), "Find WW Studios & Meetings Near You | WW USA");
		
		//5. In the search field, search for meetings for zip code: 10011
		fw.enterLocation("10011");
		fw.clickSearch();
		
		//6. Print the title of the first result and the distance (located on the right of location title/name)		
		String firstTitle=fw.getFirstTitle();
		System.out.println("FIRST RESULT TITLE : " + firstTitle);
		System.out.println("FIRST RESULT DISTANCE : " + fw.getFirstDistance());
		
		//7. Click on the first search result and then, verify displayed location name/title matches with the name of the first searched result that was clicked.
		fw.clickFirstTitle();
		Assert.assertEquals(firstTitle,wd.getLocationName());
		
		//8. From this location page, print TODAY’s hours of operation (located towards the bottom of the page)		
		System.out.println("TODAYS HOURS OF OPERATION FROM : " + wd.getTodayFirstAppointmentTime() +" TO : "+ wd.getTodayLastAppointmentTime());
		
		//9. Create a method to print the number of meeting the each person(under the scheduled time) has a particular day of the week
		printMeetings("Sun");
	}
	
	void printMeetings(String day)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<WebElement> eleList=wd.getPersonAppointmentElements(day.toUpperCase());
		for(WebElement ele : eleList)
		{
			if(map.containsKey(ele.getText()))
			{
			map.replace(ele.getText(), map.get(ele.getText())+1);
			}
			else
			{
			map.put(ele.getText(), 1);
			}
		}
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
		    System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
	
}
