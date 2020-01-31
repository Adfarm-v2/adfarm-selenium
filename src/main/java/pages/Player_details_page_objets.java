package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Player_details_page_objets {

	@FindBy(xpath = "//a[@href='/dashboard/player-list']")
	public static WebElement myplayer;
	
	@FindBy(xpath = "//button[@type='button']")
	public static WebElement newplayer;

	@FindBy(xpath = "//input[@name='username']")
	public static WebElement usernamefield;

	@FindBy(xpath = "//input[@name='location_name']")
	public static WebElement locationnamefield;
	
	@FindBy(xpath = "//div[@id='status_id']")
	public static WebElement status;
	@FindBy(xpath = "(//*[text()='Active'])[1]")
	public static WebElement statustitle;

	@FindBy(xpath = "//div[@id='distributor_id']")
	public static WebElement distributor;
	@FindBy(xpath = "//li[text()='Pro Digital']")
	public static WebElement distributortitle;
	
	@FindBy(xpath = "//div[@id='dealer_id']")
	public static WebElement dealer;
	@FindBy(xpath = "//li[text()='Steady Brand']")
	public static WebElement dealertitle;

	@FindBy(xpath = "//div[@id='customer_id']")
	public static WebElement customer;
	@FindBy(xpath = "//li[text()='On Hold 32']")
	public static WebElement customertitle;
	
	@FindBy(xpath = "//div[@id='location_id']")
	public static WebElement location;
	@FindBy(xpath = "//li[text()='Dental Office']")
	public static WebElement locationtitle;
	
	@FindBy(xpath = "//div[text()='Please select Country']")
	public static WebElement country;
	@FindBy(xpath = "//li[text()='India']")
	public static WebElement countrytitle;
	
	@FindBy(xpath = "//div[text()='Please select State']")
	public static WebElement state;
	@FindBy(xpath = "//li[text()='Tamil Nadu']")
	public static WebElement statetitle;
	
	@FindBy(xpath = "//div[text()='Select City']")
	public static WebElement city;
	@FindBy(xpath = "//*[text()='Coimbatore']")
	public static WebElement citytitle;
	
	@FindBy(xpath = "//div[text()='Please select Cluster']")
	public static WebElement group;
	@FindBy(xpath = "//*[text()='Chennai North']")
	public static WebElement grouptitle;
	
	@FindBy(xpath = "//input[@name='zipcode']")
	public static WebElement zipcode;

	@FindBy(xpath = "//input[@placeholder='search']")
	public static WebElement mapsearch;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement submit;

}
