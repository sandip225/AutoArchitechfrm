package elsTech.Module1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import elsTech.BasePackage.BaseInit;
import elsTech.Utility.MyLibrary;
import junit.framework.Assert;

public class ValidateUser extends BaseInit
{
	
	@BeforeTest
	public void setUP() throws Exception 
	{
		
		startUP();
	}
	
	@Test(dataProvider="getTestData")
	public void testValidateUser(String Email, String Password) throws InterruptedException 
	{
		
		driver.get(storage.getProperty("url"));
		
		MyLibrary.signIN(Email,Password);
	
		Thread.sleep(2000);
		
		MyLibrary.signOUT();
		
	}
	
	@DataProvider
	public Object[][] getTestData() 
	{
		return MyLibrary.getTestData(data, "ValidateUser");
	}
	


}
