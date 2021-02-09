package GDN_Acco_Only;


	import java.io.IOException;
import java.util.ArrayList;
	import java.util.List;
	import java.util.stream.Collectors;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	import pageObjects.HotelCard;
	import pageObjects.Hotell;
	import pageObjects.LandingPage;
	import pageObjects.popUp;
	import resources.Base;

	public class ACCO extends Base   //inheritance
	{
		
			public WebDriver driver; //driver obj in local so that it doesnot create problem durning parallel run 
			public static Logger log=LogManager.getLogger(Base.class.getName());
			popUp up;
			Actions builder;
			Hotell hl;
			LandingPage lp;
			HotelCard hc;
			
			
			@BeforeTest()
			public void initialize() throws IOException
			{
				
				driver=intializeDriver();  //intialize the driver in local rather than calling base drive--mainly overriding  
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
				up =new popUp(driver);
				if(up.getPopUpSize()>0)
				{
			      up.getPopUp().click();
				}
		    }
			@Test
			public void searchkaronBeach() throws IOException, InterruptedException
			{
				lp.getSearchBoxBttn().click();
				lp.getSerachBox().sendKeys("Karon Beach");
				Thread.sleep(3000);
				builder = new Actions(driver);    
				builder.moveToElement(lp.getEL()).click(lp.getEL());    
				builder.perform(); 
			}
			
			@Test
			public void DepaturePlaceSearched() throws InterruptedException
			{
				Thread.sleep(3000);
				hl =new Hotell(driver);
				hl.getCountry().click();
				Thread.sleep(3000);
				hl.getCouChkbox().click();
				hl.getClose().click();
				Thread.sleep(3000);
				Assert.assertEquals("Stockholm-Arlanda",hl.getCountry().getText());
				log.info("Successfully Searched Depature Placed");
				
			}
			
			@Test
			public void allDestinationSearched() throws InterruptedException
			{
				Thread.sleep(3000);
				hl.getCountries().click();
				hl.getSearchInput().sendKeys("Portugal");
				builder.moveToElement(hl.getActiveIndex()).click().build().perform();
				Assert.assertEquals("Portugal", hl.getCountriesV().getText());
		
				Thread.sleep(3000);
				hl.getsvg().click();
				hl.getPDropDown().click();
				hl.getsvg().click();
				hl.getClose().click();
				Assert.assertEquals("Portugal"+'\n'+ "+1", hl.getCountries().getText());
				log.info("Successfully allDestination Searched");
			}
			
			@Test
			public void adultSearched() throws InterruptedException
			{
				Thread.sleep(3000);
				hl.getPersonCount().click();
				Thread.sleep(3000);
				Assert.assertEquals("2", hl.getAdultCount().getText());
				hl.getChildrenCount().click();
				//hl.getChildAge();
				Select childage = new Select(driver.findElement(By.cssSelector("select[class='form-control child-age']")));
				childage.selectByValue("11");
				Thread.sleep(5000);
				hl.getClose().click();
				Assert.assertEquals("2 vuxna"+'\n'+ ", 1 barn", hl.getPersonCount().getText());
				log.info("Successfully adultSearched");
			}
			
			@Test
			public void selectTravelLenght() throws InterruptedException
			{
				Thread.sleep(3000);
				hl.getDuration().click();
				hl.getRadioButton().click();
				hl.getClose().click();
				Assert.assertEquals("10 till"+" 13 dagar", hl.getDuration().getText());
				log.info("Successfully Selected TravelLength");
			}	
				

			@Test
			public void selectDays() throws InterruptedException
			{
				Thread.sleep(3000);
				hl.getDate().click();
				Assert.assertEquals(5, hl.getdayscnt().size());
				Assert.assertTrue(hl.getSelectedDays().isSelected());
				hl.getDays().click();
	    		while(!driver.findElement(By.cssSelector("td[class='dateview-title']")).getText().contains("Mars"))
				{
				driver.findElement(By.cssSelector("td[class='dateview-next-month']")).click();
				}
				List<WebElement> dates= driver.findElements(By.className(".hover"));
				int count=driver.findElements(By.className("hover")).size();
				
				for(int i=0;i<count;i++)
				{
					String text=driver.findElements(By.className("hover")).get(i).getText();
					if(text.equalsIgnoreCase("23"))
					{
						driver.findElements(By.className("hover")).get(i).click();
						break;
					}
				}
			hl.getClose().click();
			Assert.assertEquals("2021-03-23", hl.getDate().getText());
			log.info("Successfully Selected Days");
			
			hl.getSearchBttn().click();
			}
			
			@Test
			public void validatedHotelcard() throws InterruptedException
			{
				Thread.sleep(3000);	
			   log.info("Navigated to HotelCardPage");
			   hc=new HotelCard(driver);
			   Assert.assertEquals("Canico do Baixo, Madeira, Portugal", hc.getSearchCard().getText());
			   log.info("validated List HotelCardName");
			}
			
			@Test
			public void validatePriceHotellCard() throws InterruptedException
			{
				Thread.sleep(3000);	
			   List<WebElement> price = driver.findElements(By.cssSelector("[class='ResultListItemV2__value']"));

			// extract the prices from the price elements and store in a List
			//List<String> prices = price.stream().map(s->s.getText()).collect(Collectors.toList());
			   List<String> prices = new ArrayList<String>();
			   for (WebElement e : price)
			   {
			    //name.add(e.getText().replaceFirst("\\s+","").trim());
				  String s=e.getText();
			        s=s.replace(":-", "");
			        s=s.replace("[ , ]", "");
			        prices.add(s);
				 //prices.add(e.getText().replace(" , ", "").replace(":-", ""));
			     }
                System.out.println(prices);   
			     // sort the list
			    List<Object>sortedPrices=prices.stream().sorted().collect(Collectors.toList());
                 
			   // true if the prices are sorted
			   System.out.println(sortedPrices);
	           Assert.assertTrue(prices.equals(sortedPrices));
	           log.info("Succesfully Validated Sorted Price");
	       }
	    	
			@AfterTest()
			public void teardown()
			{
				driver.close();
			}
			

			
}
