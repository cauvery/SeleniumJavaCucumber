package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.Properties;
import java.io.IOException;

public class LoginPage {
//	public static Properties prop;
//    public static InputStream input;
//    public static String browser;

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) throws IOException {
//		prop = new Properties();
//		input= new FileInputStream("/src/test/resources/config.properties");
//		prop.load(input);
//		input.close();
//		
//		browser = prop.getProperty("browser");
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id = "Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement lnkLogout;

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
}
