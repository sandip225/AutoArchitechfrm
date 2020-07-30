package elsTech.Module3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import elsTech.BasePackage.BaseInit;
import elsTech.Utility.ExcelFileReader;
import elsTech.Utility.MyLibrary;


public class BestsellerLink extends BaseInit{
	
	ExcelFileReader testoutput;
	
	@BeforeTest
	public void setUP() throws Exception {
		
		startUP();
		testoutput = new ExcelFileReader(System.getProperty("user.dir")+"//src//elsTech//TestData//TestCases.xlsx");
	}
	
	@Test()
	public void testExtractBestSellerLinks() throws InterruptedException {
		
		driver.get(storage.getProperty("url"));
		
		WebElement bestseller = isElementPresent("lnk_bestseller_xpath");
		List<WebElement> bestsellerlinks = bestseller.findElements(By.tagName("a"));
		
		for (int count = 0; count < bestsellerlinks.size(); count++) {
			
			String linkText = bestsellerlinks.get(count).getText();
			bestsellerlinks.get(count).click();
			Thread.sleep(2000);
			
			String webTitle = driver.getTitle();
			String currentUrl = driver.getCurrentUrl();
			
			System.out.println(webTitle);
			System.out.println(currentUrl);
			
			if (!webTitle.isEmpty()) {

				testoutput.setData("BestSellerLink", count + 1, 0, linkText);
				testoutput.setData("BestSellerLink", count + 1, 1, webTitle);
				testoutput.setData("BestSellerLink", count + 1, 2, currentUrl);
				testoutput.setData("BestSellerLink", count + 1, 3, "Pass");

			} else {

				testoutput.setData("BestSellerLink", count + 1, 0, linkText);
				testoutput.setData("BestSellerLink", count + 1, 1, webTitle);
				testoutput.setData("BestSellerLink", count + 1, 2, currentUrl);
				testoutput.setData("BestSellerLink", count + 1, 3, "Fail");

			}
			driver.navigate().back();
			bestseller = isElementPresent("lnk_bestseller_xpath");
			bestsellerlinks = bestseller.findElements(By.tagName("a"));	
		}
		
		
	}
	
}
