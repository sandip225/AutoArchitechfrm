package elsTech.Module3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import elsTech.BasePackage.BaseInit;

public class ManufacturerProducts extends BaseInit{
	
	@BeforeTest
	public void setUP() throws Exception 
	{
		startUP();
	}
	
	@Test
	public void testProductsManu() throws InterruptedException 
	{
		driver.get(storage.getProperty("url"));
		
		WebElement manudd = isElementPresent("dd_manufacturer_name");
		List<WebElement> prodList = manudd.findElements(By.tagName("option"));
		
		for(int count=1;count<prodList.size();count++) 
		{
			String manufactlist = prodList.get(count).getText();
			prodList.get(count).click();
			logs.info(manufactlist);
			Thread.sleep(1000);
			driver.navigate().back();
		    manudd = isElementPresent("dd_manufacturer_name");
			prodList = manudd.findElements(By.tagName("option"));
			
		}
		
	}
}
