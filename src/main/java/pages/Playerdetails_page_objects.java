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

	@FindBy(xpath = "//a[@href='/dashboard/player-list']")
	public static WebElement myplayer;
	@FindBy(xpath = "//button[@type='button']")
	public static WebElement newplayer;
	@FindBy(xpath = "//input[@id='playerDetails[location_name]']")
	public static WebElement locationnamefield;
	@FindBy(xpath = "//input[@id='playerDetails[username]']")
	public static WebElement usernamefield;
	@FindBy(xpath = "//input[@id='playerDetails[password]']")
	public static WebElement playerpassword;

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

	@FindBy(xpath = "//div[@id='location_id']")
	public static WebElement locationclick;
	@FindBy(xpath = "//input[@id='location_id']")
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

	@FindBy(xpath = "//input[@placeholder='Search Places']")
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

	// ************************************************************ //
	public Playerdetails_page_objects() {
		PageFactory.initElements(driver, this);
	}
	// ************************************************************ //

	public void createplayer(String name1, String uname3, String pwd2, String status31, String dist32,
			String dealername4, String customername5, String locationname6, String contpername7, String contmobnum8,
			String conteid9, String add110, String add211, String countryname12, String statename13, String cityname14,
			String groupname15, String zipcode16, String area17, String locationcost18, String tag19,
			String typeofcustomer20, String opt, String clt) throws AWTException, InterruptedException {

		String unicname = new SimpleDateFormat("mmss").format(new Date());
		String PName = name1 + unicname;
		String UName = uname3 + unicname;
		String PWD = pwd2 + unicname;

		Thread.sleep(3000);

		try {
			newplayer.click();
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in New Player button Field");
		}

		try {
			locationnamefield.sendKeys(PName);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue in Player Name Field");
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
			statusclick.click();
			Thread.sleep(1000);
			List<WebElement> totalstatus = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			List<String> statusnames = new ArrayList<String>();
			for (WebElement totalstat : totalstatus) {
				statusnames.add(totalstat.getText());
			}
			if (statusnames.contains(status31)) {
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
			if (distnames.contains(dist32)) {
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
			List<String> dealernames = new ArrayList<String>();
			for (WebElement totaldeal : totaldealer) {
				dealernames.add(totaldeal.getText());
			}
			if (dealernames.contains(dealername4)) {
				dealerinput.sendKeys(dealername4, Keys.ENTER);
			} else {
				System.out.println("Your searching Dealer not in the list");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Dealer Field");
		}

		try {
			customerclick.click();
			Thread.sleep(1000);
			List<WebElement> totalcustomer = driver.findElements(By.xpath("(//ul[@role='listbox'])[4]//li"));
			List<String> customernames = new ArrayList<String>();
			for (WebElement totalcust : totalcustomer) {
				customernames.add(totalcust.getText());
			}
			if (customernames.contains(customername5)) {
				customerinput.sendKeys(customername5, Keys.ENTER);
			} else {
				System.out.println("Your searching Customer not in the list");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Customer Field");
		}

		try {
			locationclick.click();
			Thread.sleep(1000);
			List<WebElement> totallocation = driver.findElements(By.xpath("(//ul[@role='listbox'])[5]//li"));
			List<String> locationnames = new ArrayList<String>();
			for (WebElement totallocat : totallocation) {
				locationnames.add(totallocat.getText());
			}
			if (locationnames.contains(locationname6)) {
				locationinput.sendKeys(locationname6, Keys.ENTER);
			} else {
				System.out.println("Your searching Location not in the list");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Location Field");
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
			List<String> countrynames = new ArrayList<String>();
			for (WebElement totalcount : totalcountry) {
				countrynames.add(totalcount.getText());
			}
			if (countrynames.contains(countryname12)) {
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
			Thread.sleep(2000);
			List<WebElement> totalstates = driver.findElements(By.xpath("(//ul[@role='listbox'])[7]//li"));
			List<String> statenames = new ArrayList<String>();
			for (WebElement totalstat : totalstates) {
				statenames.add(totalstat.getText());
			}
			if (statenames.contains(statename13)) {
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
			List<String> citynames = new ArrayList<String>();
			for (WebElement totalcit : totalcity) {
				citynames.add(totalcit.getText());
			}
			if (citynames.contains(cityname14)) {
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
			List<String> groupnames = new ArrayList<String>();
			for (WebElement totalgroup : totalgroups) {
				groupnames.add(totalgroup.getText());
			}
			if (groupnames.contains(groupname15)) {
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
			List<String> tagnames = new ArrayList<String>();
			for (WebElement totaltag : totaltags) {
				tagnames.add(totaltag.getText());
			}
			if (tagnames.contains(tag19)) {
				taginput.sendKeys(tag19, Keys.ENTER);
			} else {
				System.out.println("Your searching Tag not in the list");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Tag Field");
		}

		try {
			customertypeclick.click();
			Thread.sleep(1000);
			List<WebElement> totalcustomertypes = driver.findElements(By.xpath("(//ul[@role='listbox'])[11]//li"));
			List<String> totalcustomernames = new ArrayList<String>();
			for (WebElement totalcustomertype : totalcustomertypes) {
				totalcustomernames.add(totalcustomertype.getText());
			}
			if (totalcustomernames.contains(typeofcustomer20)) {
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

		Thread.sleep(3000);

		List<WebElement> totalpagination = driver
				.findElements(By.xpath("//li[starts-with(@class,'ant-pagination-item ant-pagination-item-')]"));
		List<String> names = new ArrayList<String>();
		try {
			for (int i = 1; i <= totalpagination.size(); i++) {
				String paginationselector = "//li[starts-with(@class,'ant-pagination-item ant-pagination-item-" + i
						+ "')]";
				driver.findElement(By.xpath(paginationselector)).click();

				List<WebElement> usernamecolumns = driver
						.findElements(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[2]"));
				for (WebElement totalusername : usernamecolumns) {
					names.add(totalusername.getText());
					if (names.contains(UName)) {
						System.out.println("New PLayer Created Successfully!");
						String userpath = "//span[text()='" + UName + "']";
						driver.findElement(By.xpath(userpath)).click();
						test.log(LogStatus.PASS, "New PLayer Created Successfully!");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Alredy except this exception");
		}
	}
}