package GDN_Acco_Only;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Hotell;
import pageObjects.LandingPage;
import pageObjects.popUp;
import resources.Base;

public class Test_Search_Icon  extends Base
{

	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	popUp up;
	LandingPage lp;
	Hotell hl;

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
	public void pageInit() throws IOException, InterruptedException
	{
		lp=new LandingPage(driver);
		lp.getHotell().click();
		up =new popUp(driver);
		if(up.getPopUpSize()>0)
		{
	      up.getPopUp().click();
		}
	}
	@Test
	public void searchButtonValidation() throws IOException, InterruptedException
	{
	  lp.getSearchBoxBttn().click();
	  Assert.assertEquals("Sök på tui.se", lp.getSerachLabel().getAttribute("placeholder"));
	  lp.getSerachBox().sendKeys("aten");
	  lp.getSerachBox().sendKeys(Keys.ENTER);
	}
	@Test
	public void searchResultAten()
	{
	
	  hl=new Hotell(driver);
	  hl.getHotelAten().click();
	} 
	@Test
	public void validationofbookBttn()
	{
	  hl.getSecHotelCard().click();
	  Assert.assertTrue(hl.getBookBttn().isDisplayed());
	  Assert.assertEquals("#f23c42", hl.getbookcolor());
	  if(up.getPopUpSize1()>0)
		{
	      up.getPopUp1().click();
		}
	  log.info("Hotelcard button book color is displaying");
	} 
	@Test
	public void bookbttnclicked()
	{
	  hl.getBookBttn().click();
	}
	@Test
	public void clicklowpriceplan()
	{
	  hl.getLowPriceCell().click();
	  Assert.assertTrue(hl.getTillbaka().isDisplayed());
	  log.info("Low price cell is displaying");
	}
	@Test
	public void clickbackbttn()
	{
	  hl.getTillbaka().click();
	} 
	@Test
	public void clicklowpriceblock()
	{
	  hl.getLowPriceCell().click();
	} 
	@Test
	public void bookbttncolorvalidation()
	{
	
	  WebElement element=driver.findElement(By.cssSelector("div[class='ProgressbarNavigation__summaryButton'] button[aria-label='button']"));
	  Assert.assertEquals("#fcb712", hl.getbookcolor1(element));
	  Assert.assertEquals("Hotellfakta",hl.getHotelfakta().getAttribute("label"));
      log.info("successfully color validated book button");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
