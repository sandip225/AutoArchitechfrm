package elsTech.Utility;

import elsTech.BasePackage.BaseInit;

public class MyLibrary extends BaseInit{
	
	public static void signIN(String email,String pwd) 
	{
		isElementPresent("lnk_logyourselfin_xpath").click();
		isElementPresent("ip_email_name").sendKeys(email);
		isElementPresent("ip_password_name").sendKeys(pwd);
		isElementPresent("btn_signIn_id").click();
	}
	
	public static void signOUT() 
	{
		isElementPresent("lnk_logoff_xpath").click();
		isElementPresent("btn_continue_id").click();
	}

	public static Object[][] getTestData(ExcelFileReader data, String sheetName) {
		
		int cols = data.totalColumn(sheetName);
		int rows = data.totalRow(sheetName);
		
		Object myData[][] = new Object[rows-1][cols];
		
		for(int row=1;row<rows;row++) {
			
			for(int col=0;col<cols;col++) {
				myData[row-1][col] = data.getData(sheetName, row, col);
				
			}
		}
		return myData;
	}
}
