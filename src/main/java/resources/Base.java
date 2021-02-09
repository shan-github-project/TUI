package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	public static WebDriver driver;  //multiple tc are accessing this driver than it will not create new driver rather it will share existing copy only
	public Properties prop;
    public WebDriver  intializeDriver() throws IOException
    {
    	prop = new Properties();
    	//System.getProperty("use.dir"); //give current proj path use it fileinputstream
    	//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/resources/data.properties");
    	 FileInputStream fis=new FileInputStream("src/main/java/resources/data1.properties");  
    	prop.load(fis);
    	
    	//mvn test -Dbrowser=chrome
    	 String browserName=System.getProperty("browser"); //want to send browser from maven cmd rather than  test case. use this it also used in jenkins tools also
    	//String browserName=prop.getProperty("browser");  //browser send from Test case
    	System.out.println(browserName);
    	ChromeOptions options=new ChromeOptions();
    	if(browserName.contains("chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
    		
    		if(browserName.contains("headless"))
    		{
    		options.addArguments("--headless");
    		}
    		driver= new ChromeDriver(options);
    		
        }
    	else if(browserName.equals("firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", "D:\\FireFox\\geckodriver.exe");
    		driver = new FirefoxDriver();
    	}
    	else if(browserName.equals("edge"))
    	{
    		System.setProperty("webdriver.edge.driver", "D:\\MicroEdge\\msedgedriver.exe");
    		 driver= new EdgeDriver();
    	}
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	return driver;
    	
    }	
    
    public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;  //extentadd image expects path of SS so that it go and attach to report.
		
	}
	

}
