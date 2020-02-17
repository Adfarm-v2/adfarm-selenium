
package testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.New_media_page_objects;

public class Test_newmedia_creation extends TestBase {
	
	public static New_media_page_objects media;
	
	@BeforeMethod
	public void beforeMethod() throws IOException {

		launchbrowser();
		loginpage();
		media=new New_media_page_objects();
	}

	@Test
	public void newmediacreation() throws InterruptedException, AWTException {
		media.uploadmedia();
	}
	
	@AfterMethod
	public void afterMethod() {
//		driver.quit();
	}


}
