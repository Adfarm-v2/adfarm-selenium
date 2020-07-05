package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;

public class Manageplayer_page_objects extends TestBase {

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
					if (names.contains("Autoplayer41936")) {
						System.out.println("Available in the list");
						test.log(LogStatus.PASS, "New PLayer Created Successfully!");
						String userpath = "//span[text()='Autoplayer41936']";
						driver.findElement(By.xpath(userpath)).click();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Alredy except this exception");
		}

//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//i[@class='anticon anticon-sliders']")).click();

	}
}

//		List<WebElement> totallayouttypes = driver
//				.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr/td"));
//		System.out.println("Total Layout Count: " + totallayouttypes.size());
//
//		List<String> totallayoutnames = new ArrayList<String>();
//		for (WebElement totallayouttype : totallayouttypes) {
//			totallayoutnames.add(totallayouttype.getText());
//		}
//		System.out.println(totallayoutnames);
//
//		act = new Actions(driver);
//
//		String layoutname = "Automate Fullscreen Layout1";
//		if (totallayoutnames.contains(layoutname)) {
//			System.out.println("in the list");
//			String sourcepath = "//div[text()='" + layoutname + "']";
//			WebElement source = driver.findElement(By.xpath(sourcepath));
//			WebElement target = driver.findElement(By.xpath("//div[@class='content_table___4lVRe']"));
//			act.dragAndDrop(source, target).perform();
//		} else {
//			System.out.println("Your searching layout not in the list");
//		}
//	}
