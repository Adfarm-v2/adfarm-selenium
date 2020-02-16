package testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Player_details_page_objets;

public class Test_newplayer_creation extends TestBase {

	public static Player_details_page_objets player;

	@BeforeMethod
	public void beforeMethod() throws IOException {

		launchbrowser();
		loginpage();
		player = new Player_details_page_objets();
	}

	@Test(enabled = false)
	public void newplayercreationtesting() throws AWTException, InterruptedException {

		player.createnewplayer();

	}

	@Test
	public void verifyplayerlist() {

		player.playerverification();
	}

	@AfterMethod
	public void afterMethod() {
//		driver.quit();
	}

}
