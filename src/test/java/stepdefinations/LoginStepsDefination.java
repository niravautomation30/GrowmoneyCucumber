package stepdefinations;


import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.IndexPage;
import pages.LoginPage;

public class LoginStepsDefination {

	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private LoginPage loginpage;
	private IndexPage indexpage;
	private static String actualLoginPageTitle;
	private static String actualIndexPageTitle;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://growmoney.anticusindia.com/");
		loginpage = homePage.clickLoginButton();
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		actualLoginPageTitle = loginpage.getLoginPageTitle();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedLoginPageTitle) {
	   Assert.assertTrue(actualLoginPageTitle.contains(expectedLoginPageTitle));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginpage.isForgotPasswordLinkDisplay());   
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	   loginpage.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
	    loginpage.enterPassword(pwd);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		indexpage = loginpage.clickLoginBtn();
	}

	@Then("user gets the title of the Index page")
	public void user_gets_the_title_of_the_Index_page() {
		actualIndexPageTitle = indexpage.getIndexPageTitle();
	}
	
	@Then("Index page title should be {string}")
	public void index_page_title_should_be(String expectedIndexPageTitle) {
		Assert.assertTrue(actualIndexPageTitle.contains(expectedIndexPageTitle));
	}
}
