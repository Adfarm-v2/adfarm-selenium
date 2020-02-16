package testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

	@Test
	public void newplayercreationtesting() throws AWTException, InterruptedException {

		player.createnewplayer();

	}

	@Test(enabled = false)
	public void verifyplayerlist() {

		List<WebElement> totaltablecolumn = driver.findElements(By.xpath("//th[@class='ant-table-align-center']"));
		System.out.println("Total column: " + totaltablecolumn.size());

		List<WebElement> totalrow = driver.findElements(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']"));
		System.out.println("Total row: " + totalrow.size());

		List<WebElement> totalcell = driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']//tr//td"));
		System.out.println("Total cell: " + totalcell.size());

		List<WebElement> usernamecolumn = driver
				.findElements(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[2]"));
		System.out.println("Total usernamecell: " + usernamecolumn.size());

		for (WebElement user : usernamecolumn) {
			System.out.println(user.getText());
			if (user.getText().equals("jimmyplayer1")) {
				System.out.println("Player successfully created");
				break;
			} else {
				System.out.println("Somthing error player not created");
			}
		}
	}

	@AfterMethod
	public void afterMethod() {
//		driver.quit();
	}

}
