package base;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class Base {
	
	public static WebDriver driver;
	String baseUrl="https://www.weightwatchers.com/us/";
	WebDriverWait wait;
	
	@BeforeMethod(alwaysRun=true)
    public void setup() {
		String driverPath = System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver=new ChromeDriver();     
		driver.manage().window().fullscreen();
		
		//1. Navigate to https://www.weightwatchers.com/us/
        driver.get(baseUrl);
    }
	
	@AfterMethod
    public void teardown(){
        driver.close();
        driver.quit();
    }

}


