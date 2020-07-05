package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;

public class Manageplayer_page_objects extends TestBase {

	@FindBy(xpath = "//input[@id='playerDetails[cost]']")
	public static WebElement cost;
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement update;

	// ************************************************************ //
	public Manageplayer_page_objects() {
		PageFactory.initElements(driver, this);
	}
	// ************************************************************ //

	public void editplayerdetails() throws InterruptedException {

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
					if (names.contains("Automation")) {
						driver.findElement(By.xpath("//span[text()='Automation']")).click();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Alredy except this exception");
		}

		try {
			cost.sendKeys("6000");
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Cost Field");
		}

		try {
			update.click();
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in Update Button");
		}

		try {
			String popupmessage = driver.findElement(By.xpath("//div[@class='ant-message']/span")).getText();
			System.out.println(popupmessage);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Issue in pop-up");
		}
	}

	// ************************************************************ //

	public void manageplayer() throws InterruptedException {

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
					if (names.contains("Automation")) {
						driver.findElement(By.xpath("//span[text()='Automation']")).click();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Alredy except this exception");
		}

		driver.findElement(By.xpath("//i[@class='anticon anticon-sliders']")).click();

		List<WebElement> Paginations = driver
				.findElements(By.xpath("//li[starts-with(@class,'ant-pagination-item ant-pagination-item-')]"));
		List<String> Layoutnames = new ArrayList<String>();
		try {
			for (int i = 1; i <= Paginations.size(); i++) {
				String Paginationselect = "//li[starts-with(@class,'ant-pagination-item ant-pagination-item-" + i
						+ "')]";
				driver.findElement(By.xpath(Paginationselect)).click();
				List<WebElement> Totallayout = driver
						.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr/td"));

				for (WebElement Getlayoutnames : Totallayout) {
					Layoutnames.add(Getlayoutnames.getText());
					String Publishlayout = "PT time";
					act = new Actions(driver);
					if (Layoutnames.contains(Publishlayout)) {
//						System.out.println("in the list");
//						String sourcepath = "//div[text()='" + Publishlayout + "']";
						WebElement source = driver.findElement(By.xpath("//div[text()='PT time']"));
						WebElement target = driver.findElement(By.xpath("//div[@class='content_table___4lVRe']"));
						Thread.sleep(3000);
						act.dragAndDrop(source, target).perform();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Alredy except this exception");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		
		
	}
}
