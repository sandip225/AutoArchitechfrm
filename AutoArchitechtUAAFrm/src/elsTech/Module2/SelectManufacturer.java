package elsTech.Module2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import elsTech.BasePackage.BaseInit;

public class SelectManufacturer extends BaseInit 
{
	
	@BeforeTest
	public void setUP() throws Exception {
		
		startUP();
	}
	
	@Test
	public void testSelectManufacturer() throws InterruptedException {
		
		driver.get(storage.getProperty("url"));
		
		WebElement manufacturer = isElementPresent("dd_manufacturer_name");
		List<WebElement> manufacturerval = manufacturer.findElements(By.tagName("option"));
		
		for(int count=1;count<manufacturerval.size();count++)
		{
			
			logs.info(manufacturerval.get(count).getText());	
		}
		
		
	}
}
