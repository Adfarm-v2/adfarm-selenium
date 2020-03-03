package pages;

import java.awt.AWTException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Player_details_page_objets extends TestBase {

// ***************** Player Details ************************ //	

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
	public static WebElement statusclick;
	@FindBy(xpath = "//input[@id='status_id']")
	public static WebElement statusinput;

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
	@FindBy(xpath = "(//input[@class='ant-input ant-select-search__field'])[2]")
	public static WebElement customertypeinput;

	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement submit;

// ******************************************************************************************************************************** //	
	public Player_details_page_objets() {
		PageFactory.initElements(driver, this);
	}
// ******************************************************************************************************************************** //	

	public void createnewplayer(String uname1, String pwd2, String name3, String status31, String dealername4,
			String customername5, String locationname6, String contpername7, String contmobnum8, String conteid9,
			String add110, String add211, String countryname12, String statename13, String cityname14,
			String groupname15, String zipcode16, String area17, String locationcost18, String tag19,
			String typeofcustomer20, String opt, String clt) throws AWTException, InterruptedException {

		String unicname = new SimpleDateFormat("mmss").format(new Date());
		newplayer.click();
		usernamefield.sendKeys(uname1 + unicname);
		playerpassword.sendKeys(pwd2 + unicname);
		locationnamefield.sendKeys(name3 + unicname);

		statusclick.click();
		Thread.sleep(1000);
		List<WebElement> totalstatus = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		System.out.println(totalstatus.size());
		List<String> statusnames = new ArrayList<String>();
		for (WebElement totalstat : totalstatus) {
			statusnames.add(totalstat.getText());
		}
		System.out.println(statusnames);
		if (statusnames.contains(status31)) {
			System.out.println("in the list");
			statusinput.sendKeys(status31, Keys.ENTER);
		} else {
			System.out.println("Your searching dealer not in the list");
		}

		dealerclick.click();
		Thread.sleep(1000);
		List<WebElement> totaldealer = driver.findElements(By.xpath("(//ul[@role='listbox'])[2]//li"));
		System.out.println(totaldealer.size());
		List<String> dealernames = new ArrayList<String>();
		for (WebElement totaldeal : totaldealer) {
			dealernames.add(totaldeal.getText());
		}
		System.out.println(dealernames);
		if (dealernames.contains(dealername4)) {
			System.out.println("in the list");
			dealerinput.sendKeys(dealername4, Keys.ENTER);
		} else {
			System.out.println("Your searching dealer not in the list");
		}

		customerclick.click();
		Thread.sleep(1000);
		List<WebElement> totalcustomer = driver.findElements(By.xpath("(//ul[@role='listbox'])[3]//li"));
		System.out.println(totalcustomer.size());
		List<String> customernames = new ArrayList<String>();
		for (WebElement totalcust : totalcustomer) {
			customernames.add(totalcust.getText());
		}
		System.out.println(customernames);
		if (customernames.contains(customername5)) {
			System.out.println("in the list");
			customerinput.sendKeys(customername5, Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		locationclick.click();
		Thread.sleep(1000);
		List<WebElement> totallocation = driver.findElements(By.xpath("(//ul[@role='listbox'])[4]//li"));
		System.out.println(totallocation.size());
		List<String> locationnames = new ArrayList<String>();
		for (WebElement totallocat : totallocation) {
			locationnames.add(totallocat.getText());
		}
		System.out.println(locationnames);
		if (locationnames.contains(locationname6)) {
			System.out.println("in the list");
			locationinput.sendKeys(locationname6, Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		contpername.sendKeys(contpername7);
		contmobnum.sendKeys(contmobnum8);
		contperemail.sendKeys(conteid9);
		address1.sendKeys(add110);
		address2.sendKeys(add211);

		countryclick.click();
		Thread.sleep(1000);
		List<WebElement> totalcountry = driver.findElements(By.xpath("(//ul[@role='listbox'])[5]//li"));
		System.out.println(totalcountry.size());
		List<String> countrynames = new ArrayList<String>();
		for (WebElement totalcount : totalcountry) {
			countrynames.add(totalcount.getText());
		}
		System.out.println(countrynames);
		if (countrynames.contains(countryname12)) {
			System.out.println("in the list");
			countryinput.sendKeys(countryname12, Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		stateclick.click();
		Thread.sleep(1000);
		List<WebElement> totalstates = driver.findElements(By.xpath("(//ul[@role='listbox'])[6]//li"));
		System.out.println(totalstates.size());
		List<String> statenames = new ArrayList<String>();
		for (WebElement totalstat : totalstates) {
			statenames.add(totalstat.getText());
		}
		System.out.println(statenames);
		if (statenames.contains(statename13)) {
			System.out.println("in the list");
			stateinput.sendKeys(statename13, Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		cityclick.click();
		Thread.sleep(1000);
		List<WebElement> totalcity = driver.findElements(By.xpath("(//ul[@role='listbox'])[7]//li"));
		System.out.println(totalcity.size());
		List<String> citynames = new ArrayList<String>();
		for (WebElement totalcit : totalcity) {
			citynames.add(totalcit.getText());
		}
		System.out.println(citynames);
		if (citynames.contains(cityname14)) {
			System.out.println("in the list");
			cityinput.sendKeys(cityname14, Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		groupclick.click();
		Thread.sleep(1000);
		List<WebElement> totalgroups = driver.findElements(By.xpath("(//ul[@role='listbox'])[8]//li"));
		System.out.println(totalgroups.size());
		List<String> groupnames = new ArrayList<String>();
		for (WebElement totalgroup : totalgroups) {
			groupnames.add(totalgroup.getText());
		}
		System.out.println(groupnames);
		if (groupnames.contains(groupname15)) {
			System.out.println("in the list");
			groupinput.sendKeys(groupname15, Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		mapsearch.sendKeys("coimbatore");
		Thread.sleep(3000);
		keydown();
		keyenter();

		zipcode.sendKeys(zipcode16);
		area.sendKeys(area17);
		cost.sendKeys(locationcost18);

		tagclick.click();
		Thread.sleep(1000);
		List<WebElement> totaltags = driver.findElements(By.xpath("(//ul[@role='listbox'])[9]//li"));
		System.out.println(totaltags.size());
		List<String> tagnames = new ArrayList<String>();
		for (WebElement totaltag : totaltags) {
			tagnames.add(totaltag.getText());
		}
		System.out.println(tagnames);
		if (tagnames.contains(tag19)) {
			System.out.println("in the list");
			taginput.sendKeys(tag19, Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		customertypeclick.click();
		Thread.sleep(1000);
		List<WebElement> totalcustomertypes = driver.findElements(By.xpath("(//ul[@role='listbox'])[10]//li"));
		System.out.println(totalcustomertypes.size());
		List<String> totalcustomernames = new ArrayList<String>();
		for (WebElement totalcustomertype : totalcustomertypes) {
			totalcustomernames.add(totalcustomertype.getText());
		}
		System.out.println(totalcustomernames);
		if (totalcustomernames.contains(typeofcustomer20)) {
			System.out.println("in the list");
			customertypeinput.sendKeys(typeofcustomer20, Keys.ENTER);
		} else {
			System.out.println("Your searching customer not in the list");
		}

		driver.findElement(By.xpath("(//input[@class='ant-time-picker-input'])[1]")).click();
		driver.findElement(By.xpath("//input[@class='ant-time-picker-panel-input  ']")).sendKeys(opt);

		driver.findElement(By.xpath("(//input[@class='ant-time-picker-input'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='ant-time-picker-panel-input  ']")).sendKeys(clt);

//      Player_details_page_objets.submit.click();
	}

// ******************************************************************************************************************************** //	

	public void playerverification() {

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
		String testplayer = "Autoplayer1";
		if (totalusernames.contains(testplayer)) {
			System.out.println("In the list");
			String userpath = "//span[text()='" + testplayer + "']";
			System.out.println(userpath);
			driver.findElement(By.xpath(userpath)).click();
		} else {
			System.out.println("Not in the list");
		}
	}

// ******************************************************************************************************************************** //	

	public void manageplayer() throws InterruptedException {

		driver.findElement(By.xpath("//i[@class='anticon anticon-sliders']")).click();

		List<WebElement> totallayouttypes = driver
				.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr/td"));
		System.out.println("Total Layout Count: " + totallayouttypes.size());

		List<String> totallayoutnames = new ArrayList<String>();
		for (WebElement totallayouttype : totallayouttypes) {
			totallayoutnames.add(totallayouttype.getText());
		}
		System.out.println(totallayoutnames);

		action = new Actions(driver);

		String layoutname = "Automate Fullscreen Layout1";
		if (totallayoutnames.contains(layoutname)) {
			System.out.println("in the list");
			String sourcepath = "//div[text()='" + layoutname + "']";
			System.out.println(sourcepath);
			WebElement source = driver.findElement(By.xpath(sourcepath));
			WebElement target = driver.findElement(By.xpath("//div[@class='content_table___4lVRe']"));
			action.dragAndDrop(source, target).perform();
		} else {
			System.out.println("Your searching layout not in the list");
		}

		String msg=driver.findElement(By.xpath("//div[@class='ant-message']/span")).getText();
		System.out.println(msg);
	}

}