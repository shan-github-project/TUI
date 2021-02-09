package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage
{
	public WebDriver driver;
	
	//By hotell=By.cssSelector("a[href*='boka-hotell']");
	private By hotell=By.cssSelector("li:nth-child(3) div:nth-child(1) span:nth-child(1)");
	private By searchBoxBttn=By.id("site-search-open");
	private By serachBox=By.cssSelector("[class='addsearch']");
	private By el=By.cssSelector("[href*='https://www.tui.se/resa/thailand/phuket/karon-beach/utflykter/']");
	private By serachLabel=By.cssSelector("input[placeholder='Sök på tui.se']");
		
	
	private By  välj=By.cssSelector("div[id='airports'] span[class='text']");
	private By  placeName=By.cssSelector("[class='option-list clearfix']");
	private By allaResmal=By.cssSelector("div[id='countries'] span[class='text']");
	private By vuxan=By.cssSelector("div[id='paxes'] span[class='text']");
	private By antalBarn=By.cssSelector("div[class='children clearfix'] i[class='add icon']");
	private By childAge=By.cssSelector("select[class='form-control child-age']");
	private By väljReslängd=By.cssSelector("div[id='durations'] span[class='text']");
	private By väljDatum=By.cssSelector("div[id='date'] span[class='text']");
	private By sÃKButton=By.cssSelector("button[type='button']");
	private By flight=By.cssSelector("div[class='prefilters']");
	private By flightChk=By.cssSelector("#directflight");
	


	
    public LandingPage(WebDriver driver) 
	{
	   this.driver=driver;
	}

	public WebElement getHotell()
	{
		return driver.findElement(hotell);
	}
	public WebElement getSearchBoxBttn()
	{
		return driver.findElement(searchBoxBttn);
	}
	public WebElement getSerachBox()
	{
		WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='addsearch']")));
		return driver.findElement(serachBox);
	}
	public WebElement getEL()
	{
		return driver.findElement(el);
	}
	public WebElement getvälj()
	{
		return driver.findElement(välj);
	}
	public WebElement getplaceName()
	{
		return driver.findElement(placeName);
	}
	public WebElement getAllaResmal()
	{
		return driver.findElement(allaResmal);
	}
	public WebElement getAntalBarn()
	{
		return driver.findElement(antalBarn);
	}
	public WebElement getVuxan()
	{
		return driver.findElement(vuxan);
	}
	public WebElement getChildAge()
	{
		return driver.findElement(childAge);
	}
	public WebElement getVäljReslängd()
	{
		return driver.findElement(väljReslängd);
	}
	public WebElement getVäljDatum()
	{
		return driver.findElement(väljDatum);
	}
	public WebElement getSÃKButton()
	{
		return driver.findElement(sÃKButton);
	}
	public WebElement getFlight()
	{
		return driver.findElement(flight);
	}
	public WebElement getSerachLabel()
	{
		return driver.findElement(serachLabel);
	}
	public boolean getFlightChk(){
		WebElement checkbox = driver.findElement(flightChk);
		if(!checkbox.isSelected())
		{
	    }
		   return true;
		}
	
}
