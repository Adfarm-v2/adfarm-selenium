package pages;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class New_media_page_objects extends TestBase {
	
	
	@FindBy(xpath = "(//input[@class='ant-input'])[2]")
	public static WebElement medianame;

	@FindBy(xpath = "(//*[text()='Media Library'])[1]")
	public static WebElement medialibrary;

	@FindBy(xpath = "//button[@type='button']")
	public static WebElement newmediabutton;

	@FindBy(xpath = "//div[@class='ant-upload ant-upload-drag']")
	public static WebElement uploadbutton;

	// -------------------------------------//
	public New_media_page_objects() {
		PageFactory.initElements(driver, this);
	}
	// -------------------------------------//

	public static void uploadmedia() throws InterruptedException, AWTException {		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String imgpath = "C:\\Users\\YSelvaraj\\Documents\\wp2601451.jpg";
		
		Thread.sleep(3000);
		driver.get("https://dev-app.newsigntv.com/dashboard/media-library");
		Thread.sleep(4000);
		newmediabutton.click();
		try {
			medianame.sendKeys("YOGESH");//Name
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[@class='ant-select-arrow']/i)[4]")).click();//User role 
			driver.findElement(By.xpath("//li[contains(text(),'Dealer')]")).click();
			driver.findElement(By.xpath("//div[@id='dealer_id'][@class='ant-select ant-select-enabled']")).click(); // click on the dealer user 
			driver.findElement(By.xpath("//li[contains(text(),'Autodealer2')]")).click();
//			driver.findElement(By.xpath("//li[contains(text(),'Dealer')]")).click();Thread.sleep(6000);
			WebElement category = driver.findElement(By.xpath("(//div[contains(text(),'Select Category')])[2]"));
			category.click();//category			
			WebElement catego = driver.findElement(By.xpath("//input[@id='category_id']"));
			catego.sendKeys("SUMANTH");catego.sendKeys(Keys.ENTER);
			catego.sendKeys(Keys.ENTER); Thread.sleep(3000);
			driver.findElement(By.xpath("//textarea[@class='ant-input textarea___2NDLl']")).sendKeys("THIS IS FOR TEST PURPOSE");Thread.sleep(2000);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tag_id']")));
			driver.findElement(By.xpath("//div[@id='tag_id']")).click();// click on the tag
			WebElement tag = driver.findElement(By.xpath("//input[@id='tag_id']")); tag.sendKeys("Property");tag.sendKeys(Keys.ENTER);
			tag.sendKeys(Keys.ARROW_DOWN);tag.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//textarea[@class='ant-input textarea___2NDLl']")).sendKeys(".....");Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='cluster_id']")).click();//click on the group
			WebElement cluster= driver.findElement(By.xpath("//input[@id='cluster_id']"));
			cluster.sendKeys("PAMMAL"); cluster.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//textarea[@class='ant-input textarea___2NDLl']")).sendKeys(".....");Thread.sleep(3000);
			
			WebElement med_type =	driver.findElement(By.xpath("//div[@id='media_type']"));
			wait.until(ExpectedConditions.elementToBeClickable(med_type));
			med_type.click();// media type 
			WebElement medtype = driver.findElement(By.xpath("//input[@id='media_type']"));
			medtype.sendKeys(Keys.ENTER);
//			driver.findElement(By.xpath("//li[contains(text(),'Image')]")).click();
			Thread.sleep(5000);
			 driver.findElement(By.xpath("//div[@id='layout_id']")).click();
//			wait.until(ExpectedConditions.elementToBeSelected(layout_type));
//			layout_type.click(); Thread.sleep(3000);
			WebElement layout = driver.findElement(By.xpath("//input[@id='layout_id']")); layout.sendKeys(Keys.ARROW_DOWN);layout.sendKeys(Keys.ENTER);
//			driver.findElement(By.xpath("//input[@id='layout_id']")).click();//click on the Layout
//			driver.findElement(By.xpath("//li[contains(text(),'BaseRight')]")).click();
			uploadbutton.click();//file upload
			StringSelection selection = new StringSelection(imgpath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
			Thread.sleep(2000);
			controlv();
			keyenter(); Thread.sleep(5000);
			
//			driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("This Is for Test Purpose");//click on the text area
			driver.findElement(By.xpath("//span[@id='startDate']")).click();//click on the start date
			Thread.sleep(3000);
//			driver.findElement(By.xpath("//input[@class='ant-calendar-input ']")).sendKeys("2020-03-05");
			driver.findElement(By.xpath("//a[contains(text(),'Today')]")).click();
			driver.findElement(By.xpath("(//input[@class='ant-calendar-picker-input ant-input'])[2]")).click();//click on the end date
			driver.findElement(By.xpath("//textarea[@class='ant-input textarea___2NDLl']")).sendKeys(".....");
//			driver.findElement(By.xpath("//a[contains(text(),'Today')]")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//input[@class='ant-calendar-input ']")).sendKeys("2020-03-10");
			driver.findElement(By.xpath("//input[@id='default_media']")).click();//click on default media
			driver.findElement(By.xpath("//input[@id='date_dependent']")).click();//click on Date dependent
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='drawer_footer___2g0dj']/button[2]")).click();
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String already_exist = driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']")).getText();
		System.out.println(already_exist);
		//logs("The Name of the media library is already exist "+already_exist+"");
		
	}

}
