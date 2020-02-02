package testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Login_page_objects;
import pages.Player_details_page_objets;

public class Test_newplayer_creation extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws IOException {

		launchbrowser();
		PageFactory.initElements(driver, Login_page_objects.class);

		Login_page_objects.uname.sendKeys(properties.getProperty("username"));
		Login_page_objects.pwd.sendKeys(properties.getProperty("password"));
		Login_page_objects.logbtn.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Test(enabled = false)
	public void newplayercreation() throws InterruptedException, AWTException {

		PageFactory.initElements(driver, Player_details_page_objets.class);

		Player_details_page_objets.newplayer.click();

		Player_details_page_objets.usernamefield.sendKeys("GopiDist1Play4");
		Player_details_page_objets.locationnamefield.sendKeys("cakes & bakes");

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

		Player_details_page_objets.contpername.sendKeys("anbu");
		Player_details_page_objets.contmobnum.sendKeys("768776877");
		Player_details_page_objets.contperemail.sendKeys("anbu@gmail.com");
		Player_details_page_objets.address1.sendKeys("behind singanallur");
		Player_details_page_objets.address2.sendKeys("behind singanallur");

		Player_details_page_objets.country.click();
		Player_details_page_objets.countrytitle.click();

		Player_details_page_objets.state.click();
		Player_details_page_objets.statetitle.click();

		Player_details_page_objets.city.click();
		Player_details_page_objets.citytitle.click();

		Player_details_page_objets.group.click();
		Player_details_page_objets.grouptitle.click();

		Player_details_page_objets.mapsearch.sendKeys("singanallur");
		keydown();
		keyenter();

		Player_details_page_objets.zipcode.sendKeys("641041");
		Player_details_page_objets.area.sendKeys("local");
		Player_details_page_objets.cost.sendKeys("40000000");

//		WebElement tag = driver.findElement(By.xpath("//input[@id='tag_id']"));
		WebElement tagclick = driver.findElement(By.xpath("//div[text()='Select Tag']"));
		tagclick.click();
		List<WebElement> totaltypeoftag = driver.findElements(By.xpath("(//ul[@role='listbox'])[10]//li"));
		System.out.println(totaltypeoftag.size());

		for (WebElement tagtag : totaltypeoftag) {
			if (tagtag.getText().equals("Invisible")) {
				tagtag.click();
				break;
			} else {
				System.out.println("This tag is not in the list");
//				tag.sendKeys("Gopi", Keys.ENTER);
			}
		}

//		WebElement entercusttag = driver.findElement(By.xpath("//input[@id='customer_type_id']"));
		driver.findElement(By.xpath("//div[text()='Select Type Of Customer']")).click();
		List<WebElement> totaltypeofcust = driver.findElements(By.xpath("(//ul[@role='listbox'])[11]//li"));
		System.out.println(totaltypeofcust.size());

		for (WebElement custtag : totaltypeofcust) {
			if (custtag.getText().equals("Old")) {
				custtag.click();
				break;
			} else {
				System.out.println("This customer tag is not in the list");
//				entercusttag.sendKeys("gopi", Keys.ENTER);
			}
		}

		WebElement opentime = driver.findElement(By.xpath("//input[@id='open_time']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='10:23 am';", opentime);

		WebElement closetime = driver.findElement(By.xpath("//input[@id='close_time']"));
		js.executeScript("arguments[0].value='10:19 pm';", closetime);

	}

	@Test
	public void verifyplayerlist() {

//		login();
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
			if (user.getText().equals("DentalOffice2")) {
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
