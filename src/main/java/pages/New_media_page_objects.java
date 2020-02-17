package pages;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class New_media_page_objects extends TestBase {
	
	
	@FindBy(xpath = "(//*[text()='Media Library'])[1]")
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
		String imgpath = "C:\\Users\\Jothi\\Desktop\\Nature HD Images\\img1.JPG";
		Thread.sleep(3000);
		driver.get("https://dev-app.newsigntv.com/dashboard/media-library");
		Thread.sleep(4000);
		newmediabutton.click();
		uploadbutton.click();
		StringSelection selection = new StringSelection(imgpath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Thread.sleep(2000);
		controlv();
		keyenter();
	}

}
