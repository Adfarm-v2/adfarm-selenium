package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Login_page_objects extends TestBase{
	
	@FindBy(xpath = "//input[@id='login_id']")
	public static WebElement uname;

	@FindBy(id = "password")
	public static WebElement pwd;
	
	@FindBy(xpath = "//input[@id='captcha']")
	public static WebElement inputcaptcha;

	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement logbtn;

	// -------------------------------------//
	public Login_page_objects() {
		PageFactory.initElements(driver, this);
	}
	// -------------------------------------//

	public void logincheck(String uname1,String pwd2) {
		uname.sendKeys(uname1);
		pwd.sendKeys(pwd2);
		logbtn.click();
}
}
