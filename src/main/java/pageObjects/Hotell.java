package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hotell
{
	public WebDriver driver;
	
	//By destination=By.tagName("tui-search-panel");
	private By calendar=By.cssSelector(".picker-value-container");
	private By randomdate=By.cssSelector(".tui-calendar-day-inner");
	private By klar=By.cssSelector(".btn-done");
	private By sak=By.cssSelector(".search-button");
	
	
	private By country=By.cssSelector("[class='panel-input col-airports']");
	private By couChkbox=By.xpath("//span[@data-itemid='ARN']//input[@type='checkbox']");
	private By close=By.cssSelector("button[class*=panel-close]");
	
	private By countries=By.id("countries");
	private By searchInput=By.cssSelector("[type='text']");
	private By activeIndex=By.cssSelector("[class='active-index']");
	private By countriesV=By.xpath("//ul[@class='level-1']//span[contains(text(),'Portugal')]");
	private By svg=By.xpath("//span[normalize-space()='Portugal']//i//*[local-name()='svg']");
	private By pDropDown=By.xpath("//span[normalize-space()='Lissabon']//input[@type='checkbox']");
	
	private By personCount=By.id("paxes");
	private By adultCount=By.cssSelector("div[class='adults clearfix'] label");
	private By childrenCount=By.cssSelector("div[class='children clearfix'] i[class='add icon']");
	private By childAge=By.cssSelector("select[class='form-control child-age']");
	
	private By duration=By.id("durations");
	private By radioButton=By.cssSelector("ul.level-1.level-single:nth-child(2) > li:nth-child(1) > span");
	
	private By date=By.cssSelector("div[id='date'] div[class='col-text']");	
	private By dayscnt=By.cssSelector("input[type='radio']");
	private By selecteddays=By.cssSelector("span[class='selected'] input[name='panel-flexibility']");
	private By days=By.xpath("//span[normalize-space()='+/- 7 dagar']//input[@name='panel-flexibility']");
	private By weekdays=By.className("hover");
	
	private By searchBttn=By.cssSelector("button[class='button-search']");
	
	private By hotelAten=By.cssSelector("a[href*='https://www.tui.se/resa/grekland/aten/hotell/']");
	private By secHotelCard=By.cssSelector("img[alt='Amalia Athens']");	
	private By bookBttn=By.cssSelector("a[class*='js-btn-book']");
	private By lowPriceCell=By.cssSelector("td[class*=UI__lowPriceCell]");
	private By tillbaka=By.linkText("Tillbaka till sökresultatet");	
	private By summaryButton=By.cssSelector("div[class='ProgressbarNavigation__summaryButton'] button[aria-label='button']");
	private By hotelfakta=By.cssSelector("a[aria-label='HOTEL_DETAILS']");
	private By amaliaAthens=By.cssSelector("div[class*='headerTitle '] h1 span");
	private By Fortsatt=By.cssSelector("div[class='ProgressbarNavigation__summaryButton'] button[aria-label='button']");
	
	
	
	   public Hotell(WebDriver driver) 
	   {
		   this.driver=driver;
	   }
	   
	   public WebElement getCountry()
		{
			return driver.findElement(country);
		}
		public WebElement getCouChkbox()
		{
			return driver.findElement(couChkbox);
		}
		public WebElement getClose()
		{
			return driver.findElement(close);
		}
		public WebElement getCountries()
		{
			return driver.findElement(countries);
		}
		public WebElement getSearchInput()
		{
			return driver.findElement(searchInput);
		}
		public WebElement getActiveIndex()
		{
			return driver.findElement(activeIndex);
		}
		public WebElement getCountriesV()
		{
			return driver.findElement(countriesV);
		}
		public WebElement getsvg()
		{
			return driver.findElement(svg);
		}
		public WebElement getPDropDown()
		{
			return driver.findElement(pDropDown);
		} 
		public WebElement getPersonCount()
		{
			return driver.findElement(personCount);
		} 
		public WebElement getAdultCount()
		{
			return driver.findElement(adultCount);
		} 
		public WebElement getChildrenCount()
		{
			return driver.findElement(childrenCount);
		} 
		public WebElement getChildAge()
		{
			return driver.findElement(childAge);
		}
		public WebElement getDuration()
		{
			return driver.findElement(duration);
		}
		public WebElement getRadioButton()
		{
			return driver.findElement(radioButton);
		}
		public WebElement getDate()
		{
			WebDriverWait wait = new WebDriverWait(driver, 500);
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[id='date'] div[class='col-text']")));
			return driver.findElement(date);
		}
		public WebElement getSelectedDays() 
		{
			return driver.findElement(selecteddays);
		}
		public WebElement getDays()
		{
			return driver.findElement(days);
		}
		public List<WebElement> getdayscnt()
		{
			return driver.findElements(dayscnt);
		}
		public WebElement getWeekdays()
		{
			return driver.findElement(weekdays);
		}

		public WebElement getSearchBttn()
		{
			return driver.findElement(searchBttn);
		}
		public WebElement getHotelAten()
		{
			return driver.findElement(hotelAten);
		}
		public WebElement getSecHotelCard()
		{
			return driver.findElement(secHotelCard);
		}
		public WebElement getBookBttn()
		{
			return driver.findElement(bookBttn);
		}
		
		public String getbookcolor(){
			String color = driver.findElement(bookBttn).getCssValue("background-color");
			String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");                           
            hexValue[0] = hexValue[0].trim();
            int hexValue1 = Integer.parseInt(hexValue[0]);                   
            hexValue[1] = hexValue[1].trim();
            int hexValue2 = Integer.parseInt(hexValue[1]);                   
            hexValue[2] = hexValue[2].trim();
           int hexValue3 = Integer.parseInt(hexValue[2]);                   

			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
			return actualColor;
		}
		public WebElement getLowPriceCell()
		{
			return driver.findElement(lowPriceCell);
		}
		public WebElement getTillbaka()
		{
			return driver.findElement(tillbaka);
		}
		public WebElement getSummaryButton()
		{
			return driver.findElement(summaryButton);
		}
		public String getbookcolor1(WebElement element){
			String color = element.getCssValue("background-color");
			String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");                           
            hexValue[0] = hexValue[0].trim();
            int hexValue1 = Integer.parseInt(hexValue[0]);                   
            hexValue[1] = hexValue[1].trim();
            int hexValue2 = Integer.parseInt(hexValue[1]);                   
            hexValue[2] = hexValue[2].trim();
           int hexValue3 = Integer.parseInt(hexValue[2]);                   

			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
			return actualColor;
		}
		public WebElement getHotelfakta()
		{
			return driver.findElement(hotelfakta);
		}
		public WebElement getAmaliaAthens()
		{
			return driver.findElement(amaliaAthens);
		}
		public WebElement getFortsatt()
		{
			return driver.findElement(Fortsatt);
		}
}
