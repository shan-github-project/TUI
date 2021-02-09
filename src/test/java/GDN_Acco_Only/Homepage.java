package GDN_Acco_Only;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.popUp;
import resources.Base;




public class Homepage extends Base
{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	popUp up ;
	String dateVal;
	LandingPage lp;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=intializeDriver();
		log.info("Driver is intialized");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
	}
	
	@Test
	public void Pageinit() throws IOException, InterruptedException
	{
		lp =  new LandingPage(driver);
		lp.getHotell().click();
		Thread.sleep(5000);
		up =new popUp(driver);
		if(up.getPopUpSize()>0)
		{
	      up.getPopUp().click();
		}
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
	}	
		
	@Test
	public void RandomDate() throws InterruptedException
	{
		WebElement root = driver.findElement(By.tagName("tui-search-panel"));
		Thread.sleep(5000);
		WebElement shadowRoot = expandRootElement(root);
		shadowRoot.findElement(By.id("destination-input")).sendKeys("Stockholm, Sweden");
		shadowRoot.findElement(By.id("destination-input")).sendKeys(Keys.ARROW_DOWN);
		shadowRoot.findElement(By.id("destination-input")).sendKeys(Keys.ENTER);
		
		shadowRoot.findElement(By.cssSelector("[class='date-container']")).click();
		
		shadowRoot.findElement(By.cssSelector("tui-calendar-day:nth-of-type(5)")).click();
	          
	         shadowRoot.findElement(By.cssSelector("[class='btn-done']")).click();
	  		shadowRoot.findElement(By.cssSelector("[class='search-button']")).click();
			
	  		log.info("Random date got successfully selected");
		 
		 
		 
		/*hl.getCalender().click();
		hl.getRandomdate().click();
		hl.getKlar().click();
		hl.getSÃK().click();*/
		/*HotelCard hc = new HotelCard(driver); 
	    Assert.assertTrue(hc.getHotelCard().isDisplayed());
	    Assert.assertTrue(hc.getHotelName().getText().contains("Downtown Camper"));
		*/
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor)driver)
	.executeScript("return arguments[0].shadowRoot", element);
		return ele;
	}
	
}
