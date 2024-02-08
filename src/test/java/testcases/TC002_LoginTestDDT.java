package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelLibrary;

public class TC002_LoginTestDDT extends BaseClass {
	
	ExcelLibrary ex=new ExcelLibrary();
	
	@Test(dataProvider="excelDDT")
	public void TC002_LoginTest(String us, String pw) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.Username(us);
		lp.Password(pw);
		lp.logIn();
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			System.out.println("test case failed");
			
		}else {
			Assert.assertTrue(true);
			System.out.println("test case passed");
			lp.logOut();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
	}
	
	
	@DataProvider(name="excelDDT")
	public Object [][] dataInput(){
		return new Object[][] 
				
				{{ex.excelLib("Sheet1", 0, 0),ex.excelLib("Sheet1", 0, 1)},
				{ex.excelLib("Sheet1", 1, 0),ex.excelLib("Sheet1", 1, 1)},
				{ex.excelLib("Sheet1", 2, 0),ex.excelLib("Sheet1", 2, 1)},
				{ex.excelLib("Sheet1", 3, 0),ex.excelLib("Sheet1", 3, 1)},
				{ex.excelLib("Sheet1", 4, 0),ex.excelLib("Sheet1", 4, 1)},
				{ex.excelLib("Sheet1", 5, 0),ex.excelLib("Sheet1", 5, 1)},
				
				};
				
				
				
				
	
	
	
	}}

