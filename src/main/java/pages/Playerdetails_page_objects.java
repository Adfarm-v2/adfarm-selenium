package pages;

import java.awt.AWTException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;

public class Playerdetails_page_objects extends TestBase {

	// ***************** Player Details ************************ //

	@FindBy(xpath = "//a[@href='/dashboard/player-list']")
	public static WebElement myplayer;
	@FindBy(xpath = "//button[@type='button']")
	public static WebElement newplayer;
	@FindBy(xpath = "//input[@id='playerDetails[username]']")
	public static WebElement usernamefield;
	@FindBy(xpath = "//input[@id='playerDetails[password]']")
	public static WebElement playerpassword;
	@FindBy(xpath = "//input[@id='playerDetails[location_name]']")
	public static WebElement locationnamefield;

	@FindBy(xpath = "//div[@id='playerDetails[status_id]']")
	public static WebElement statusclick;
	@FindBy(xpath = "//input[@id='playerDetails[status_id]']")
	public static WebElement statusinput;

	@FindBy(xpath = "//div[@id='distributor_id']")
	public static WebElement distclick;
	@FindBy(xpath = "//input[@id='distributor_id']")
	public static WebElement distinput;

	@FindBy(xpath = "//div[@id='dealer_id']")
	public static WebElement dealerclick;
	@FindBy(xpath = "//input[@id='dealer_id']")
	public static WebElement dealerinput;

	@FindBy(xpath = "//div[@id='customer_id']")
	public static WebElement customerclick;
	@FindBy(xpath = "//input[@id='customer_id']")
	public static WebElement customerinput;

	@FindBy(xpath = "//div[@id='playerDetails[parent_user_id]']")
	public static WebElement locationclick;
	@FindBy(xpath = "//input[@id='playerDetails[parent_user_id]']")
	public static WebElement locationinput;

	@FindBy(xpath = "//input[@id='playerDetails[contact_person_name]']")
	public static WebElement contpername;
	@FindBy(xpath = "//input[@id='playerDetails[contact_phone_number]']")
	public static WebElement contmobnum;
	@FindBy(xpath = "//input[@id='playerDetails[contact_email_id]']")
	public static WebElement contperemail;
	@FindBy(xpath = "//input[@id='playerDetails[address1]']")
	public static WebElement address1;
	@FindBy(xpath = "//input[@id='playerDetails[address2]']")
	public static WebElement address2;

	@FindBy(xpath = "//div[@id='playerDetails[country_id]']")
	public static WebElement countryclick;
	@FindBy(xpath = "//input[@id='playerDetails[country_id]']")
	public static WebElement countryinput;

	@FindBy(xpath = "//div[@id='playerDetails[state_id]']")
	public static WebElement stateclick;
	@FindBy(xpath = "//input[@id='playerDetails[state_id]']")
	public static WebElement stateinput;

	@FindBy(xpath = "//div[@id='playerDetails[city_id]']")
	public static WebElement cityclick;
	@FindBy(xpath = "//input[@class='ant-input ant-select-search__field']")
	public static WebElement cityinput;

	@FindBy(xpath = "//div[@id='playerDetails[cluster_id]']")
	public static WebElement groupclick;
	@FindBy(xpath = "//input[@id='playerDetails[cluster_id]']")
	public static WebElement groupinput;

	@FindBy(xpath = "//input[@placeholder='Search Places ...']")
	public static WebElement mapsearch;
	@FindBy(xpath = "//input[@id='playerDetails[zipcode]']")
	public static WebElement zipcode;
	@FindBy(xpath = "//input[@id='playerDetails[area]']")
	public static WebElement area;
	@FindBy(xpath = "//input[@id='playerDetails[cost]']")
	public static WebElement cost;

	@FindBy(xpath = "//div[@id='playerDetails[tag_id]']")
	public static WebElement tagclick;
	@FindBy(xpath = "//input[@id='playerDetails[tag_id]']")
	public static WebElement taginput;

	@FindBy(xpath = "//div[@id='playerDetails[customer_type_id]']")
	public static WebElement customertypeclick;
	@FindBy(xpath = "(//input[@class='ant-input ant-select-search__field'])[2]")
	public static WebElement customertypeinput;

	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement submit;

	// ********************************************************************************************************************************
	// //
	public Playerdetails_page_objects() {
		PageFactory.initElements(driver, this);
	}
	// ********************************************************************************************************************************
	// //

	public void createplayer(String uname1, String pwd2, String name3, String status31, String dist32,
			String dealername4, String customername5, String locationname6, String contpername7, String contmobnum8,
			String conteid9, String add110, String add211, String countryname12, String statename13, String cityname14,
			String groupname15, String zipcode16, String area17, String locationcost18, String tag19,
			String typeofcustomer20, String opt, String clt) throws AWTException, InterruptedException {

		String unicname = new SimpleDateFormat("mmss").format(new Date());
		String UName=uname1+unicname;
		String PWD=pwd2+unicname;

		try {
			newplayer.click();
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in New Player button Field");
		}

		try {
			usernamefield.sendKeys(UName);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in User Name Field");
		}

		try {
			playerpassword.sendKeys(PWD);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Password Field");
		}

		try {
			locationnamefield.sendKeys(name3 + unicname);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue in Location Name Field");
		}

		try {
			statusclick.click();
			Thread.sleep(1000);
			List<WebElement> totalstatus = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			List<String> statusnames = new ArrayList<String>();
			for (WebElement totalstat : totalstatus) {
				statusnames.add(totalstat.getText());
			}
			if (statusnames.contains(status31)) {
				System.out.println("In the list");
				statusinput.sendKeys(status31, Keys.ENTER);
			} else {
				System.out.println("Your searching Status not in the list");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Status Field");

			// This is Used for print entire Exception message in extend report //
//			}}catch(Throwable t) {
//				t.fillInStackTrace();
//				test.log(LogStatus.ERROR, t.fillInStackTrace());
		}

		try {
			distclick.click();
			Thread.sleep(1000);
			List<WebElement> totaldists = driver.findElements(By.xpath("(//ul[@role='listbox'])[2]//li"));
			List<String> distnames = new ArrayList<String>();
			for (WebElement totaldist : totaldists) {
				distnames.add(totaldist.getText());
			}
			System.out.println(distnames);
			if (distnames.contains(dist32)) {
				System.out.println("In the list");
				distinput.sendKeys(dist32, Keys.ENTER);
			} else {
				System.out.println("Your Searching Distributor not in the List");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Distributor Field");
		}

		try {
			dealerclick.click();
			Thread.sleep(1000);
			List<WebElement> totaldealer = driver.findElements(By.xpath("(//ul[@role='listbox'])[3]//li"));
			System.out.println(totaldealer.size());
			List<String> dealernames = new ArrayList<String>();
			for (WebElement totaldeal : totaldealer) {
				dealernames.add(totaldeal.getText());
			}
			System.out.println(dealernames);
			if (dealernames.contains(dealername4)) {
				System.out.println("In the list");
				dealerinput.sendKeys(dealername4, Keys.ENTER);
			} else {
				System.out.println("Your searching Dealer not in the list");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Dealer Field");
		}

		customerclick.click();
		Thread.sleep(1000);
		List<WebElement> totalcustomer = driver.findElements(By.xpath("(//ul[@role='listbox'])[4]//li"));
		System.out.println(totalcustomer.size());
		List<String> customernames = new ArrayList<String>();
		for (WebElement totalcust : totalcustomer) {
			customernames.add(totalcust.getText());
		}
		System.out.println(customernames);
		if (customernames.contains(customername5)) {
			System.out.println("In the list");
			customerinput.sendKeys(customername5, Keys.ENTER);
		} else {
			System.out.println("Your searching Customer not in the list");
		}

		locationclick.click();
		Thread.sleep(1000);
		List<WebElement> totallocation = driver.findElements(By.xpath("(//ul[@role='listbox'])[5]//li"));
		System.out.println(totallocation.size());
		List<String> locationnames = new ArrayList<String>();
		for (WebElement totallocat : totallocation) {
			locationnames.add(totallocat.getText());
		}
		System.out.println(locationnames);
		if (locationnames.contains(locationname6)) {
			System.out.println("In the list");
			locationinput.sendKeys(locationname6, Keys.ENTER);
		} else {
			System.out.println("Your searching Location not in the list");
		}

		try {
			contpername.sendKeys(contpername7);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Contact Person Name Field");
		}
		try {
			contmobnum.sendKeys(contmobnum8);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Contact Mobile Number Field");
		}
		try {
			contperemail.sendKeys(conteid9);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Contact E-mail id Field");
		}
		try {
			address1.sendKeys(add110);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Address1 Field");
		}
		try {
			address2.sendKeys(add211);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Address2 Field");
		}

		try {
			countryclick.click();
			Thread.sleep(1000);
			List<WebElement> totalcountry = driver.findElements(By.xpath("(//ul[@role='listbox'])[6]//li"));
			System.out.println(totalcountry.size());
			List<String> countrynames = new ArrayList<String>();
			for (WebElement totalcount : totalcountry) {
				countrynames.add(totalcount.getText());
			}
			System.out.println(countrynames);
			if (countrynames.contains(countryname12)) {
				System.out.println("In the list");
				countryinput.sendKeys(countryname12, Keys.ENTER);
			} else {
				System.out.println("Your searching Country not in the list");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Country Field");
		}

		try {
			stateclick.click();
			Thread.sleep(1000);
			List<WebElement> totalstates = driver.findElements(By.xpath("(//ul[@role='listbox'])[7]//li"));
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
				System.out.println("Your searching State Name not in the list");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in State Field");
		}

		try {
			cityclick.click();
			Thread.sleep(1000);
			List<WebElement> totalcity = driver.findElements(By.xpath("(//ul[@role='listbox'])[8]//li"));
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
				System.out.println("Your searching City not in the list");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in City Field");
		}

		try {
			groupclick.click();
			Thread.sleep(1000);
			List<WebElement> totalgroups = driver.findElements(By.xpath("(//ul[@role='listbox'])[9]//li"));
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
				System.out.println("Your searching Group not in the list");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Group Field");
		}

		try {
			mapsearch.sendKeys("coimbatore", Keys.ENTER);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Map Search Field");
		}
		try {
			zipcode.sendKeys(zipcode16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			area.sendKeys(area17);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Area Field");
		}
		try {
			cost.sendKeys(locationcost18);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Cost Field");
		}

		try {
			tagclick.click();
			Thread.sleep(1000);
			List<WebElement> totaltags = driver.findElements(By.xpath("(//ul[@role='listbox'])[10]//li"));
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
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Tag Field");
		}

		try {
			customertypeclick.click();
			Thread.sleep(1000);
			List<WebElement> totalcustomertypes = driver.findElements(By.xpath("(//ul[@role='listbox'])[11]//li"));
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
				System.out.println("Your searching CustomerType not in the list");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in CustomerType Field");
		}

		try {
			driver.findElement(By.xpath("(//input[@class='ant-time-picker-input'])[1]")).click();
			driver.findElement(By.xpath("//input[@class='ant-time-picker-panel-input  ']")).sendKeys(opt);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Open Time Field");
		}

		try {
			driver.findElement(By.xpath("(//input[@class='ant-time-picker-input'])[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@class='ant-time-picker-panel-input  ']")).sendKeys(clt);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Close Time Field");
		}

		try {
			Playerdetails_page_objects.submit.click();
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Save Player Button");
		}

		List<WebElement> totalpagination = driver
				.findElements(By.xpath("//li[starts-with(@class,'ant-pagination-item ant-pagination-item-')]"));

		System.out.println("Total pagination: " + totalpagination.size());

		List<String> names = new ArrayList<String>();

		for (int i = 1; i <= totalpagination.size(); i++) {
			String paginationselector = "//li[starts-with(@class,'ant-pagination-item ant-pagination-item-" + i + "')]";
			System.out.println(paginationselector);
			driver.findElement(By.xpath(paginationselector)).click();
			List<WebElement> usernamecolumns = driver
					.findElements(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[2]"));
			for (WebElement totalusername : usernamecolumns) {
				names.add(totalusername.getText());
			}
		}
		System.out.println(names);
		if (names.contains(UName)) {
			System.out.println("New PLayer Created Successfully!");
		} else {
			System.out.println("Have some issues Player not Created");
		}
	}

	// ********************************************************************************************************************************
	// //

	public void editplayerdetails() {

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
			driver.findElement(By.xpath(userpath)).click();
		} else {
			System.out.println("Not in the list");
		}

		try {
			cost.sendKeys("6000");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Cost Field");
		}

		try {
			String popupmessage = driver.findElement(By.xpath("//div[@class='ant-message']/span")).getText();
			System.out.println(popupmessage);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in pop-up");
		}
	}

	// ********************************************************************************************************************************
	// //

	public void playerdetails() {

//		List<WebElement> totaltablecolumn = driver.findElements(By.xpath("//th[@class='ant-table-align-center']"));
//		System.out.println("Total column: " + totaltablecolumn.size());
//
//		List<WebElement> totalrow = driver.findElements(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']"));
//		System.out.println("Total row: " + totalrow.size());
//
//		List<WebElement> totalcell = driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']//tr//td"));
//		System.out.println("Total cell: " + totalcell.size());
//
//		List<WebElement> usernamecolumns = driver
//				.findElements(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[2]"));
//		System.out.println("Total usernamecell: " + usernamecolumns.size());
		
		List<WebElement> totalpagination = driver.findElements(By.xpath("//li[starts-with(@class,'ant-pagination-item ant-pagination-item-')]"));

		System.out.println("Total pagination: " + totalpagination.size());
		
		List<String> names=new ArrayList<String>();
		
		for(int i=1; i<=totalpagination.size();i++) {
			
		}
		
		//li[starts-with(@class,'ant-pagination-item ant-pagination-item-')]
		
		
		
	}
}