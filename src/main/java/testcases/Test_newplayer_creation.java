package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Login_page_objects;
import pages.Player_details_page_objets;

public class Test_newplayer_creation extends TestBase {

	public void login() {
		PageFactory.initElements(driver, Login_page_objects.class);

		Login_page_objects.uname.sendKeys(properties.getProperty("username"));
		Login_page_objects.pwd.sendKeys(properties.getProperty("password"));
		Login_page_objects.logbtn.click();

	}

	@Test
	public void newplayercreation() throws InterruptedException {

		login();
		PageFactory.initElements(driver, Player_details_page_objets.class);
		Thread.sleep(3000);
		Player_details_page_objets.newplayer.click();
		Thread.sleep(3000);
		Player_details_page_objets.usernamefield.sendKeys("GopiDist1Play4");
		Player_details_page_objets.locationnamefield.sendKeys("cakes & bakes");
		Thread.sleep(2000);
		Player_details_page_objets.status.click();
		Player_details_page_objets.statustitle.click();
		
		Player_details_page_objets.distributor.click();
		Player_details_page_objets.distributortitle.click();
		
		Player_details_page_objets.dealer.click();
		Player_details_page_objets.dealertitle.click();
		
		Player_details_page_objets.customer.click();
		Player_details_page_objets.customertitle.click();
		
		Player_details_page_objets.location.click();
		Player_details_page_objets.locationtitle.click();
		Thread.sleep(2000);
		Player_details_page_objets.country.click();
		Player_details_page_objets.countrytitle.click();

		Thread.sleep(2000);
		Player_details_page_objets.state.click();
		Player_details_page_objets.statetitle.click();

		Player_details_page_objets.city.click();
		Player_details_page_objets.citytitle.click();

		Player_details_page_objets.group.click();
		Player_details_page_objets.grouptitle.click();

		
		
		Player_details_page_objets.zipcode.sendKeys("641041");
		
	}

}
