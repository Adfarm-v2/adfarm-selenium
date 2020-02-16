package pages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Player_details_page_objets extends TestBase {

	@FindBy(xpath = "//a[@href='/dashboard/player-list']")
	public static WebElement myplayer;
	@FindBy(xpath = "//button[@type='button']")
	public static WebElement newplayer;
	@FindBy(xpath = "//input[@name='username']")
	public static WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	public static WebElement playerpassword;
	@FindBy(xpath = "//input[@name='location_name']")
	public static WebElement locationnamefield;
	@FindBy(xpath = "//div[@id='status_id']")
	public static WebElement status;
	@FindBy(xpath = "(//*[text()='Active'])[1]")
	public static WebElement statustitle;

	@FindBy(xpath = "//div[@id='dealer_id']")
	public static WebElement dealerclick;
	@FindBy(xpath = "//input[@id='dealer_id']")
	public static WebElement dealerinput;

	@FindBy(xpath = "//div[@id='customer_id']")
	public static WebElement customerclick;
	@FindBy(xpath = "//input[@id='customer_id']")
	public static WebElement customerinput;

	@FindBy(xpath = "//div[@id='location_id']")
	public static WebElement locationclick;
	@FindBy(xpath = "//input[@id='location_id']")
	public static WebElement locationinput;

	@FindBy(xpath = "//input[@name='contact_person_name']")
	public static WebElement contpername;
	@FindBy(xpath = "//input[@name='contact_phone_number']")
	public static WebElement contmobnum;
	@FindBy(xpath = "//input[@name='contact_email_id']")
	public static WebElement contperemail;
	@FindBy(xpath = "//input[@name='address1']")
	public static WebElement address1;
	@FindBy(xpath = "//input[@name='address2']")
	public static WebElement address2;

	@FindBy(xpath = "//div[@id='country']")
	public static WebElement countryclick;
	@FindBy(xpath = "//input[@id='country']")
	public static WebElement countryinput;

	@FindBy(xpath = "//div[@id='state']")
	public static WebElement stateclick;
	@FindBy(xpath = "//input[@id='state']")
	public static WebElement stateinput;

	@FindBy(xpath = "//div[@id='city_id']")
	public static WebElement cityclick;
	@FindBy(xpath = "//input[@class='ant-input ant-select-search__field']")
	public static WebElement cityinput;

	@FindBy(xpath = "//div[@id='cluster_id']")
	public static WebElement groupclick;
	@FindBy(xpath = "//input[@id='cluster_id']")
	public static WebElement groupinput;

	@FindBy(xpath = "//input[@id='pac-input']")
	public static WebElement mapsearch;
	@FindBy(xpath = "//input[@name='zipcode']")
	public static WebElement zipcode;
	@FindBy(xpath = "//input[@name='area']")
	public static WebElement area;
	@FindBy(xpath = "//input[@name='cost']")
	public static WebElement cost;

	@FindBy(xpath = "//div[@id='tag_id']")
	public static WebElement tagclick;
	@FindBy(xpath = "//input[@id='tag_id']")
	public static WebElement taginput;

	@FindBy(xpath = "//div[@id='customer_type_id']")
	public static WebElement customertypeclick;
	@FindBy(xpath = "//input[@id='customer_type_id']")
	public static WebElement customertypeinput;

	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement submit;

	// -------------------------------------//
	public Player_details_page_objets() {
		PageFactory.initElements(driver, this);
	}
	// -------------------------------------//

	public static void createnewplayer() throws AWTException, InterruptedException {

		newplayer.click();
		usernamefield.sendKeys("GopiDist1Play4");
		playerpassword.sendKeys("GopiDist1Play4");
		locationnamefield.sendKeys("cakes & bakes");
		status.click();
		statustitle.click();

		dealerclick.click();
		List<WebElement> totaldealer = driver.findElements(By.xpath("(//ul[@role='listbox'])[2]//li"));
		System.out.println(totaldealer.size());
		List<String> dealernames = new ArrayList<String>();
		for (WebElement totaldeal : totaldealer) {
			dealernames.add(totaldeal.getText());
		}
		System.out.println(dealernames);
		if (dealernames.contains("Autodealer1")) {
			System.out.println("in the list");
			dealerinput.sendKeys("Autodealer1", Keys.ENTER);
		} else {
			System.out.println("Your searching dealer not in the list");
		}

		customerclick.click();
		List<WebElement> totalcustomer = driver.findElements(By.xpath("(//ul[@role='listbox'])[3]//li"));
		System.out.println(totalcustomer.size());
		List<String> customernames = new ArrayList<String>();
		for (WebElement totalcust : totalcustomer) {
			customernames.add(totalcust.getText());
		}
		System.out.println(customernames);
		if (customernames.contains("Autocustomer1")) {
			System.out.println("in the list");
			customerinput.sendKeys("Autocustomer1", Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		locationclick.click();
		List<WebElement> totallocation = driver.findElements(By.xpath("(//ul[@role='listbox'])[4]//li"));
		System.out.println(totallocation.size());
		List<String> locationnames = new ArrayList<String>();
		for (WebElement totallocat : totallocation) {
			locationnames.add(totallocat.getText());
		}
		System.out.println(locationnames);
		if (locationnames.contains("Autolocation1")) {
			System.out.println("in the list");
			locationinput.sendKeys("Autolocation1", Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		contpername.sendKeys("anbu");
		contmobnum.sendKeys("768776877");
		contperemail.sendKeys("anbu@gmail.com");
		address1.sendKeys("behind singanallur");
		address2.sendKeys("behind singanallur");

		countryclick.click();
		List<WebElement> totalcountry = driver.findElements(By.xpath("(//ul[@role='listbox'])[5]//li"));
		System.out.println(totalcountry.size());
		List<String> countrynames = new ArrayList<String>();
		for (WebElement totalcount : totalcountry) {
			countrynames.add(totalcount.getText());
		}
		System.out.println(countrynames);
		if (countrynames.contains("India")) {
			System.out.println("in the list");
			countryinput.sendKeys("India", Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		stateclick.click();
		stateinput.sendKeys("Tamil Nadu", Keys.ENTER);

//		List<WebElement> totalstates = driver.findElements(By.xpath("(//ul[@role='listbox'])[6]//li"));
//		System.out.println(totalstates.size());
//		List<String> statenames = new ArrayList<String>();
//		for (WebElement totalstat : totalstates) {
//			statenames.add(totalstat.getText());
//		}
//		System.out.println(statenames);
//		if (statenames.contains("Tamil Nadu")) {
//			System.out.println("in the list");
//			stateinput.sendKeys("Tamil Nadu", Keys.ENTER);
//		} else {
//			System.out.println("Your searching customer not in the list");
//		}

		cityclick.click();
		List<WebElement> totalcity = driver.findElements(By.xpath("(//ul[@role='listbox'])[7]//li"));
		System.out.println(totalcity.size());
		List<String> citynames = new ArrayList<String>();
		for (WebElement totalcit : totalcity) {
			citynames.add(totalcit.getText());
		}
		System.out.println(citynames);
		if (citynames.contains("Chennai")) {
			System.out.println("in the list");
			cityinput.sendKeys("Chennai", Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		groupclick.click();
		List<WebElement> totalgroups = driver.findElements(By.xpath("(//ul[@role='listbox'])[8]//li"));
		System.out.println(totalgroups.size());
		List<String> groupnames = new ArrayList<String>();
		for (WebElement totalgroup : totalgroups) {
			groupnames.add(totalgroup.getText());
		}
		System.out.println(groupnames);
		if (groupnames.contains("Tambaram")) {
			System.out.println("in the list");
			groupinput.sendKeys("Tambaram", Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		mapsearch.sendKeys("coimbatore");
		Thread.sleep(3000);
		keydown();
		keyenter();

		zipcode.sendKeys("641041");
		area.sendKeys("local");
		cost.sendKeys("40000000");

		tagclick.click();
		List<WebElement> totaltags = driver.findElements(By.xpath("(//ul[@role='listbox'])[9]//li"));
		System.out.println(totaltags.size());
		List<String> tagnames = new ArrayList<String>();
		for (WebElement totaltag : totaltags) {
			tagnames.add(totaltag.getText());
		}
		System.out.println(tagnames);
		if (tagnames.contains("property")) {
			System.out.println("in the list");
			taginput.sendKeys("property", Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		customertypeclick.click();
		List<WebElement> totalcustomertypes = driver.findElements(By.xpath("(//ul[@role='listbox'])[10]//li"));
		System.out.println(totalcustomertypes.size());
		List<String> totalcustomernames = new ArrayList<String>();
		for (WebElement totalcustomertype : totalcustomertypes) {
			totalcustomernames.add(totalcustomertype.getText());
		}
		System.out.println(totalcustomernames);
		if (totalcustomernames.contains("Beach View")) {
			System.out.println("in the list");
			customertypeinput.sendKeys("Beach View", Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		WebElement opentime = driver.findElement(By.xpath("//input[@id='open_time']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='10:23 am';", opentime);

		WebElement closetime = driver.findElement(By.xpath("//input[@id='close_time']"));
		js.executeScript("arguments[0].value='10:19 pm';", closetime);

		//// //Player_details_page_objets.submit.click();
	}
	
	public static void playerverification() {

		List<WebElement> totaltablecolumn = driver.findElements(By.xpath("//th[@class='ant-table-align-center']"));
		System.out.println("Total column: " + totaltablecolumn.size());

		List<WebElement> totalrow = driver.findElements(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']"));
		System.out.println("Total row: " + totalrow.size());

		List<WebElement> totalcell = driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']//tr//td"));
		System.out.println("Total cell: " + totalcell.size());

		List<WebElement> usernamecolumns = driver
				.findElements(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[2]"));
		System.out.println("Total usernamecell: " + usernamecolumns.size());

		List<String> totalusernames = new ArrayList<String>();
		for (WebElement totalusername : usernamecolumns) {
			totalusernames.add(totalusername.getText());
		}
		System.out.println(totalusernames);
		String testplayer="Autoplayer1";
		if (totalusernames.contains(testplayer)) {
			System.out.println("In the list");
			String userpath="//div[text()='"+testplayer+"']/preceding::td";
			String playername=driver.findElement(By.xpath(userpath)).getText();
			String clickpath="//a[text()='"+playername+"']";
			driver.findElement(By.xpath(clickpath)).click();
		} else {
			System.out.println("Not in the list");
		}
	}
}