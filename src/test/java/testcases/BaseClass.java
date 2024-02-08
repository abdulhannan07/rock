package testcases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;

public class BaseClass {

	ReadConfig rd=new ReadConfig();

	public static WebDriver driver;
	public String baseUrl=rd.getBaseUrl();
	public String username=rd.Uname();
	public String password=rd.Pw();
	
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setBrowser(String br) {
		//comment added in the file
		//second comment added
		//added thrid commnet
		logger=Logger.getLogger("Automation Project");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", rd.firefoxPath());
		driver=new FirefoxDriver();
		}
		else if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",rd.chromePath());
		driver=new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		logger.info("launching URL");
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
}

	@AfterClass
	public void closeBrowser() {
		logger.info("closing url");
		driver.close();
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch
			(NoAlertPresentException e){
				return false;
			}
	}
		public void screenShot(WebDriver driver, String testname) throws IOException {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File destination=new File(System.getProperty("user.dir")+"//Screenshots//"+testname+".png");
			FileUtils.copyFile(source, destination);
			System.out.println("screenshot  taken");
		
	}
	}

