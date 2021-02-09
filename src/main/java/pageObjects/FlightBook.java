package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightBook
{
	public WebDriver driver;
	
	//By destination=By.tagName("tui-search-panel");
	private By pageHeading=By.cssSelector("h1[aria-label='page heading']");
	private By rumoChat=By.cssSelector("a[href*='/se/hitta-resa/boka/rumochmat']");
	private By doubleRoom=By.cssSelector("div[id='roomTypesV3__component'] div:nth-child(1) label:nth-child(1)");
	private By tillBaka=By.cssSelector("button[class*='buttons__primary undefined']");
	
	
	private By vuxen1=By.cssSelector("span[class='inputs__box']");
	private By totalPris=By.xpath("div[class='PriceDiscountBreakDown__price']");
	private By boka=By.cssSelector("button[class*='buttons__primary undefined']");
	
	
	
	
	   public FlightBook(WebDriver driver) 
	   {
		   this.driver=driver;
	   }
	   
	   public WebElement getPageHeading()
		{
			return driver.findElement(pageHeading);
		}
		public WebElement getRumoChat()
		{
			return driver.findElement(rumoChat);
		}
		public WebElement getDoubleRoom()
		{
			return driver.findElement(doubleRoom);
		}
		public WebElement getTillBaka()
		{
			return driver.findElement(tillBaka);
		}
		public WebElement getVuxen1()
		{
			return driver.findElement(vuxen1);
		}
		public WebElement getTotalPris()
		{
			return driver.findElement(totalPris);
		}
		public WebElement getBoka()
		{
			return driver.findElement(boka);
		}
		
}
