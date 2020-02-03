package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Login_page_objects;

public class Test_newmedia_creation extends TestBase {
	
	@BeforeMethod
	public void beforeMethod() throws IOException {

		launchbrowser();
		PageFactory.initElements(driver, Login_page_objects.class);

		Login_page_objects.uname.sendKeys(properties.getProperty("username"));
		Login_page_objects.pwd.sendKeys(properties.getProperty("password"));
		Login_page_objects.logbtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void newmediacreation() throws InterruptedException {
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[@href='/dashboard/media-library']")).click();
		driver.get("https://dev-app.newsigntv.com/dashboard/media-library");
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void afterMethod() {
//		driver.quit();
	}


}
