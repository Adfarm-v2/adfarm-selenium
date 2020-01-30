package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Login_page_objects;

public class Test_newplayer_creation extends TestBase {

	public void login() {
		PageFactory.initElements(driver, Login_page_objects.class);

		Login_page_objects.uname.sendKeys(properties.getProperty("username") + System.currentTimeMillis());
		Login_page_objects.pwd.sendKeys(properties.getProperty("password"));
		Login_page_objects.logbtn.click();

	}

	@Test
	public void newplayercreation() {

		login();
		
	}

}
