package elsTech.Module2;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import elsTech.BasePackage.BaseInit;
import elsTech.Utility.MyLibrary;

public class SearchProduct extends BaseInit 
{
	
	@BeforeTest
	public void setUP() throws Exception {
		
		startUP();
	}
	
	@Test(dataProvider="getTestData")
	public void testSearchProduct(String Keywords) {
		
		driver.get(storage.getProperty("url")); 
		isElementPresent("ip_quickfind_name").sendKeys(Keywords);
		isElementPresent("ip_quickfind_name").sendKeys(Keys.ENTER);
		
	}
	
	@DataProvider
	public Object[][] getTestData() {
		
		return MyLibrary.getTestData(data, "SearchProduct");
		
	}
	
}
