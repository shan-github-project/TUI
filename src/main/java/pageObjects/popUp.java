package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class popUp
{
	public WebDriver driver;
	
	
	public popUp(WebDriver driver) 
	   {
		   this.driver=driver;
	   }

	
	
	By popup=By.cssSelector(".pictogram.pictogram-plus.right.up.close");
	public int getPopUpSize()

	{
      return driver.findElements(popup).size();
    }

	public WebElement getPopUp()

	{
		return driver.findElement(popup);

	}
		
	By popup1=By.cssSelector("[class*='tui-article-button-close']");
	public int getPopUpSize1()

	{
      return driver.findElements(popup1).size();
    }

	public WebElement getPopUp1()

	{
		return driver.findElement(popup1);

	}

}
