package GDN_Acco_Only;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Checkout;
import pageObjects.FlightBook;
import pageObjects.Hotell;
import pageObjects.LandingPage;
import pageObjects.popUp;
import randomDob.customRandom;
import resources.Base;

public class TU_Book_Ticket  extends Base
{

	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	popUp up ;
	LandingPage lp;
	Hotell hl;
	Checkout ct;
	FlightBook fb;
	
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
	public void pageinit() throws IOException, InterruptedException
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
     public void searchaten()
     {
	  lp.getSearchBoxBttn().click();
	  lp.getSerachBox().sendKeys("aten");
	  lp.getSerachBox().sendKeys(Keys.ENTER);
     }
     @Test
	 public void clciksecondhotelcard(){
	  hl=new Hotell(driver);
	  hl.getHotelAten().click();
	  hl.getSecHotelCard().click();
	 }
	 @Test
	 public void verifyingbookbttndisplaying()
	 {
	  Assert.assertTrue(hl.getBookBttn().isDisplayed());
	  if(up.getPopUpSize1()>0)
		{
	      up.getPopUp1().click();
		}
	 }
	 
	 @Test
	 public void bookbttnclicked()
	 {
	  hl.getBookBttn().click();
	 }
	 @Test
	 public void lowPricecellclicked()
	 {
	  hl.getLowPriceCell().click();
	 }
	 @Test
	 public void validatehotelpageinit()
	 {
	  Assert.assertEquals("Hotellfakta",hl.getHotelfakta().getAttribute("label"));
	  log.info("succefully validated Hotellfakta");
	 }
	 @Test
	 public void validateathenhotel()
	 {
	  Assert.assertEquals("Amalia Athens",hl.getAmaliaAthens().getText());
	  log.info("succefully validated amaliathens");
	 }
	 @Test
	 public void forsattclicked()
	 {
		 hl.getFortsatt().click();
	 }

	 @Test
	 public void  pageheadingvalidation()
	 {
	  fb=new FlightBook(driver);
	  Assert.assertEquals("ANPASSA DIN RESA",fb.getPageHeading().getText()); 
	  log.info("succefully navigated and validated pageheading");
	  try {
		Thread.sleep(5000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	  
	 }

	 @Test
	 public void  roomclicked()
	 {
	  fb.getRumoChat().click();
	 }
	 @Test
	 public void  doubeRoomClicked()
	 {
	  fb.getDoubleRoom().click();
	 }
	 @Test
	 public void  backbutton()
	 {
	  fb.getTillBaka().click();
	 }
	 @Test
	 public void  adultclicked()
	 {
	  fb.getVuxen1().click();
	 }
	 @Test
	 public void  bokaclicked()
	 {
	  fb.getBoka().click();
	 }
	 @Test
	 public void  selectMale(){
	  ct=new Checkout(driver);
	  Select leadAdult = new Select(ct.getLeadAdult());
	  leadAdult.selectByValue("MALE");
	 }
	 @Test
	 public void  firstName(){
	  ct.getFirstname().sendKeys(RandomStringUtils.randomAlphabetic(4));
	 }
	 @Test
	 public void  lastName(){
	  ct.getLastName().sendKeys(RandomStringUtils.randomAlphabetic(4));
	 }
	 @Test
	 public void  yearofDob(){
	  ct.getYear().sendKeys("1995");
	 }
	 @Test
	 public void  monthofDob()
	 {
	  ct.getMonth().sendKeys("11");
	 }
	 @Test
	 public void  dateofDob()
	 {
	  ct.getDay().sendKeys("28");
	 }
	 
	 @Test
	 public void  address(){
	  ct.getAddress().sendKeys("Linclon" + RandomStringUtils.randomNumeric(4));
	 }
	 @Test
	 public void postCode()
	 {
	  ct.getPostCode().sendKeys("1"+RandomStringUtils.randomNumeric(3));
	 }
	 @Test
	 public void Town()
	 {
	  ct.getTown().sendKeys(RandomStringUtils.randomAlphabetic(4));
	 }
	 @Test
	 public void telePhone(){
	  ct.getTelephone().sendKeys("0"+RandomStringUtils.randomNumeric(9));
	 }
	 @Test
	 public void email() throws InterruptedException{
	  Random randomGenerator = new Random();  
	  int randomInt = randomGenerator.nextInt(1000);  
	  ct.getEmail().sendKeys("Jhon"+ randomInt +"@gmail.com");
	  Thread.sleep(5000);
	 }
	 @Test
	 public void adult2(){
	  Select adult = new Select(ct.getAdult());
	  adult.selectByValue("MALE");
	 }
	 @Test
	 public void firstName2()
	 {
	  ct.getFirstName1().sendKeys(RandomStringUtils.randomAlphabetic(4));
	 }
	 @Test
	 public void lastName2()
	 {
	  ct.getLastName1().sendKeys(RandomStringUtils.randomAlphabetic(4));
	 }
	 @Test
	 public void yearDOB(){
	  ct.getYear1().sendKeys("2000");
	 }
	 @Test
	 public void monthDOB(){
	  ct.getMonth1().sendKeys("10");
	 }
	 @Test
	 public void dayDOB(){
	  ct.getDay1().sendKeys("27");
	 }
	 @Test
	 public void info(){
	  ct.getInfoBox().click();
	 
	  if(ct.getInsuranceBox().isDisplayed())
	  {
	  ct.getInsuranceBox().click();
	  }
	 }
	 @Test
	 public void clickedContinue()
	 {
	  JavascriptExecutor executor = (JavascriptExecutor) driver;
	  executor.executeScript("arguments[0].click;", ct.getcontBttn());   
	  
	  log.info("Navigated to Paymentpage");
	 }

	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
