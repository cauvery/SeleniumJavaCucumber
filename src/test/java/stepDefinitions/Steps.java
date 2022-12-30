package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class Steps {
	
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() throws IOException {
		
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		
		lp = new LoginPage(driver);
	}
	
	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}
	
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    lp.setUserName(email);
	    lp.setPassword(password);
	}
	
	@When("Click on Login")
	public void click_on_login() {
	    lp.clickLogin();
	}
	
	@Then("Verify pagesource contains {string}")
	public void verify_pagesource_contains(String text) {
		assertThat(driver.getPageSource().contains(text));
	}
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			assertThat(false);
		}
		assertThat(driver.getTitle().equals(title));
	}
	
	@Then("Click on Logout")
	public void click_on_logout() {
	    lp.clickLogout();
	}
	
	@Then("Close browser")
	public void close_browser() {
	    driver.close();
	}


}
