package elsTech.BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import elsTech.Utility.ExcelFileReader;

/*1. Initialize and load properties file
2. Launch Browser
3. Define WebDriver
4. Maximize Browser window
5. Define TimeUnit
6. Delete all cookies
7. Define Logger
8. Object of ExcelFileReader class
9. Create a method isElementPresent
*/

public class BaseInit 
{
	public static Properties storage = null;
	public static WebDriver driver;
	public static Logger logs;
	public static ExcelFileReader data;
    public static ExcelFileReader testoutput=null;
    
	public void startUP() throws Exception 
	{
		
		if (driver == null) {

			logs = Logger.getLogger("devpinoyLogger");
			logs.info("Properties File is loading now");
			storage = new Properties();
			testoutput = new ExcelFileReader(System.getProperty("user.dir")+"//src//elsTech//TestData//TestCases.xlsx");
			FileInputStream fi = new FileInputStream(
					System.getProperty("user.dir")+"//src//elsTech//PropertiesFile//ObjectStorage.properties");
			storage.load(fi);
			logs.info("Properties file loaded..");
			
			

			String broweserval = storage.getProperty("browser");

			if (broweserval.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				logs.info("Chrome Browser Launching...");
			}

			else if (broweserval.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "E:\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				logs.info("FireFox Browser Launching..");
			} else {
				logs.info("Browser Not Defined");
			}

			driver.manage().window().maximize();
			logs.info("Window is Maximized..");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logs.info("TimeUnit is Defined..");

			driver.manage().deleteAllCookies();
			logs.info("Cookies has been deleted..");

			data = new ExcelFileReader(System.getProperty("user.dir") + "//src//elsTech//TestData//TestCases.xlsx");
			logs.info("ExcelFileReader object has created..");
		}

	}
	
	public static WebElement isElementPresent(String propKey)  
	{
		try 
		{
			if(propKey.contains("xpath")) 
			{
				return driver.findElement(By.xpath(storage.getProperty(propKey)));
			}
			
			else if(propKey.contains("id")) 
			{
				return driver.findElement(By.id(storage.getProperty(propKey)));
			}
			
			else if(propKey.contains("name")) 
			{
				return driver.findElement(By.name(storage.getProperty(propKey)));
			}
			
			else if(propKey.contains("linkText")) 
			{
				driver.findElement(By.linkText(storage.getProperty(propKey)));
			}
			else 
			{
				logs.info("key not found in the Properties file");
			}
			
		}catch(Exception e) 
		{
		
		}
		return null;
		
	}
}
