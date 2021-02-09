package GDN_Acco_Only;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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




public class SE_PROD_StartPageRender1_Configurator extends Base
{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	popUp up ;
	String dateVal;
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
	public void pageinit() throws InterruptedException
	{
		lp =  new LandingPage(driver);
		lp.getHotell().click();
		up =new popUp(driver);
		if(up.getPopUpSize()>0)
		{
	      up.getPopUp().click();
		}
		lp.getSearchBoxBttn().click();
		lp.getSerachBox().sendKeys("aten");
		lp.getSerachBox().sendKeys(Keys.ENTER);
	}
	
	@Test
	public void ValidatedeapatureList()
	{
		
		Assert.assertEquals("Välj avreseort", lp.getvälj().getText());
		lp.getvälj().click();	
		
		List<WebElement> names = driver.findElements(By.cssSelector("span[data-itemid]"));
		int size=names.size();

		// extract the prices from the price elements and store in a List
		List<String> name = new ArrayList<String>();
		for (WebElement e : names)
		{
		    //name.add(e.getText().replaceFirst("\\s+","").trim());
		    name.add(e.getText().replace(" ", ""));
		    
		}
		List<Object> sortedNames = name.stream().sorted().collect(Collectors.toList());
		System.out.println(size);
		System.out.println(sortedNames);
		log.info("Succesfully ValidatedeapatureList");
	}  
	@Test
	public void ValidateallDestinationList() throws InterruptedException
	{
		hl=new Hotell(driver);
		hl.getClose().click();
		Assert.assertEquals("Alla resmål", lp.getAllaResmal().getText());
		lp.getAllaResmal().click();
		List<WebElement> desnames = driver.findElements(By.cssSelector("div[class='option-list clearfix']"));

		List<String> desname = new ArrayList<String>();
		for (WebElement e : desnames)
		{
		    desname.add(e.getText());
		}
		List<Object> desSortedNames = desname.stream().sorted().collect(Collectors.toList());
		System.out.print("\n" + desSortedNames);
		List<WebElement> des=driver.findElements(By.cssSelector("ul>li>span"));
		int desSize=des.size();
		System.out.println(desSize);
		hl.getClose().click();
		Thread.sleep(5000);
		log.info("Succesfully ValidateallDestinationList");
	}
	
	@Test
	public void Validateadultlist() throws InterruptedException	
	{
	    Assert.assertEquals("2 vuxna", lp.getVuxan().getText());
		lp.getVuxan().click();
		lp.getAntalBarn().click();
		lp.getChildAge().click();
		List<WebElement> ageSize = driver.findElements(By.cssSelector("option[value]"));
		int childAge=ageSize.size();
		System.out.println(childAge);
		hl.getClose().click();
		log.info("Succesfully Validateadultlist");
	}	
	@Test
	public void ValidatetravelLength() throws InterruptedException	
	{
		Assert.assertEquals("Välj reslängd", lp.getVäljReslängd().getText());
		lp.getvälj().click();
		List<WebElement> travelLenName = driver.findElements(By.cssSelector("div[class='v--modal-overlay'] ul"));
		int trvlLenSize=travelLenName.size();
		System.out.println(trvlLenSize);
		hl.getClose().click();
		log.info("Succesfully ValidatetravelLength");
	}	
	@Test
	public void ValidateSelectedDate() throws InterruptedException
	{
		Assert.assertEquals("Välj datum", lp.getVäljDatum().getText());
		log.info("Succesfully ValidateSelectedDate");
	}
	@Test
	public void ValidateButtonText() throws InterruptedException
	{
		Assert.assertEquals("SÖK", lp.getSÃKButton().getText());
		log.info("Succesfully ValidateButtonText");
	}	
	@Test
	public void ValidateDirectFlyChkBox() throws InterruptedException
	{
		Assert.assertEquals("Direktflyg", lp.getFlight().getText());
		System.out.println(lp.getFlightChk());
		log.info("Succesfully ValidateDirectFlyChkBox");
	}

	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
