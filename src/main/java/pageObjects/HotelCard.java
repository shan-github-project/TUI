package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HotelCard
{
	public WebDriver driver;
	
	
	  By hotelcard=By.cssSelector(".image-fade");
	  By hotelname=By.cssSelector("hotel-name");
	  By searchcard=By.cssSelector("[class='ResultListItemV2__location']");
	
	   public HotelCard(WebDriver driver) 
	   {
		   this.driver=driver;
	   }

	   
	   public WebElement getHotelCard()
		{
			return driver.findElement(hotelcard);
			
		}

	    public WebElement getHotelName()
		{
			return driver.findElement(hotelname);
			
		}
	    public WebElement getSearchCard()
		{
			return driver.findElement(searchcard);
			
		}
	
	
}
