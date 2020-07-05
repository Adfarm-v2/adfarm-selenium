package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.apache.commons.math3.ode.events.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;

public class Layout_page_objects extends TestBase {

//	@FindBy(xpath = "//a[@href='/dashboard/player-list']")
//	public static WebElement myplayer;
//	@FindBy(xpath = "//button[@type='button']")
//	public static WebElement newplayer;
//
//	// ********************************************************************************************************************************
//	// //
//	public Layout_page_objects() {
//		PageFactory.initElements(driver, this);
//	}

	// ********************************************************************************************************************************
	public void FullscreenLayout() throws InterruptedException {

		
		Thread.sleep(5000);
		driver.get("https://dev-app.newsigntv.com/dashboard/layout");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class='ant-btn'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class='ant-radio-input'])[1]")).click();
		Thread.sleep(3000);		
		try {
			WebElement ele = driver.findElement(By.xpath("//div[text()='New Playlist Order Flow']"));
			ele.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebElement ele1 = driver.findElement(By.xpath("//tr[@data-row-key='408']"));
		WebElement ele2 = driver.findElement(By.xpath("(//div[@class='ant-col-8'])[1]"));
		Actions act = new Actions(driver);

		try {
			act.dragAndDrop(ele1, ele2).build().perform(); 
		} catch (Exception e) {
			e.printStackTrace();
		}


		
	//	Thread.sleep(4000);
//		
//		WebElement source1 = driver.findElement(By.xpath("((//tbody[@class='ant-table-tbody'])[2]/tr)[2]"));
//		Thread.sleep(2000);
//		WebElement target1 = driver.findElement(By.xpath("(//div[@class='ant-card-body'])[2]"));
//		
//		Actions act = new Actions(driver);
////		act.clickAndHold(source1).moveToElement(target1).release().build().perform();
//		act.dragAndDrop(source1, target1).build().perform();

		
		
//		act.clickAndHold(source1).build().perform();
//		 
//		// Move to drop Webelement
//		act.moveToElement(target1).build().perform();
//		 
//		// Release drag webelement into drop webelement
//		act.release(target1).build().perform();
		
	}
//	public void BaseLayout(){
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.get("https://dev-app.newsigntv.com/dashboard/layout");
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		driver.findElement(By.xpath("(//button[@class='ant-btn'])[1]")).click();
//		driver.findElement(By.xpath("(//input[@class='ant-radio-input'])[2]")).click();
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.findElement(By.xpath("((//ul[@class='ant-pagination ant-table-pagination mini'])[2]/li)[3]")).click();
//		WebElement sour = driver.findElement(By.xpath("(//tr[@draggable='true'])[2]"));
//		WebElement targ = driver.findElement(By.xpath("(//div[@class='ant-card-body'])[4]"));
//		Actions act = new Actions(driver);
//		act.dragAndDrop(sour, targ).build().perform();
//		
//	}
}
