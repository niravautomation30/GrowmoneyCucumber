package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By uname = By.name("UserName");
	private By pass = By.name("Password");
	private By loginBtn = By.id("btnCustomerLogin");
	private By forgotPwdLink = By.linkText("Forgot Password?");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkDisplay() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUsername(String username) {
		driver.findElement(uname).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(pass).sendKeys(pwd);
	}
	
	public IndexPage clickLoginBtn() {
		driver.findElement(loginBtn).click();
		return new IndexPage(driver);
	}
}
