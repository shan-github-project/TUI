package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkout
{
	public WebDriver driver;
	
	private By leadAdult=By.cssSelector("div[class='LeadAdult__selectOption inputs__selectDropdown'] select[aria-label='Select']");
	private By firstname=By.cssSelector("#paxInfoFirstName0");
	private By lastName=By.cssSelector("#paxInfoLastName0");
	private By year=By.cssSelector("#paxInfoDobYear0");
	private By month=By.cssSelector("#paxInfoDobMonth0");
	private By day=By.cssSelector("#paxInfoDobDay0");
	private By address=By.cssSelector("#paxInfoAddressLine1");
	private By postCode=By.cssSelector("#paxInfoPostCode");
	private By town=By.cssSelector("#paxInfoTown");
	private By telephone=By.cssSelector("#paxInfoTelephone");
	private By email=By.cssSelector("#paxInfoEmail");
	
	private By adult=By.cssSelector("div[class='Adult__selectOption inputs__selectDropdown'] select[aria-label='Select']");
	private By firstName1=By.cssSelector("#paxInfoFirstName1");
	private By lastName1=By.cssSelector("#paxInfoLastName1");
	private By year1=By.cssSelector("#paxInfoDobYearundefined");
	private By month1=By.cssSelector("#paxInfoDobMonthundefined");
	private By day1=By.cssSelector("#paxInfoDobDayundefined");
	private By contbttn=By.cssSelector("div[class*='ctaContainer']");	
	private By infoBox=By.cssSelector("div[class*='NordicsImportantInformation'] span[class*='box']");	
	private By insuranceBox=By.cssSelector("div[class*='InsuranceTermsAndconditions'] span[class*='box']");	
	
	
	   public Checkout(WebDriver driver) 
	   {
		   this.driver=driver;
	   }
	   
	   public WebElement getLeadAdult()
		{
			return driver.findElement(leadAdult);
		}
		public WebElement getFirstname()
		{
			return driver.findElement(firstname);
		}
		public WebElement getLastName()
		{
			return driver.findElement(lastName);
		}
		public WebElement getYear()
		{
			return driver.findElement(year);
		}
		public WebElement getMonth()
		{
			return driver.findElement(month);
		}
		public WebElement getDay()
		{
			return driver.findElement(day);
		}
		public WebElement getAddress()
		{
			return driver.findElement(address);
		}
		public WebElement getPostCode()
		{
			return driver.findElement(postCode);
		}
		public WebElement getTelephone()
		{
			return driver.findElement(telephone);
		} 
		public WebElement getTown()
		{
			return driver.findElement(town);
		} 
		public WebElement getEmail()
		{
			return driver.findElement(email);
		} 
		public WebElement getAdult()
		{
			return driver.findElement(adult);
		} 
		public WebElement getFirstName1()
		{
			return driver.findElement(firstName1);
		}
		public WebElement getLastName1()
		{
			return driver.findElement(lastName1);
		}
		public WebElement getYear1()
		{
			return driver.findElement(year1);
		}
		public WebElement getMonth1() 
		{
			return driver.findElement(month1);
		}
		public WebElement getDay1()
		{
			return driver.findElement(day1);
		}
		public WebElement getcontBttn()
		{
			return driver.findElement(contbttn);
		}
		public WebElement getInfoBox()
		{
			return driver.findElement(infoBox);
		}
		public WebElement getInsuranceBox()
		{
			return driver.findElement(insuranceBox);
		}
}
