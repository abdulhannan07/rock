package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public  LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
			
		}
	
		@FindBy(name="uid")
		WebElement txtusername;
		
		@FindBy(name="password")
		WebElement txtpassword;
		
		@FindBy(name="btnLogin")
		WebElement loginButton;
		
		@FindBy(partialLinkText="Log out")
		WebElement logoutButton;
		
		public void Username(String username) {
			txtusername.sendKeys(username);
		}
		
		public void Password(String password) {
			txtpassword.sendKeys(password);
		}
		
		public void logIn() {
			loginButton.click();
		}
		
		public void logOut() {
			logoutButton.click();
		}
		
}


