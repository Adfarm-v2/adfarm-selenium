package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.TestBase;

public class Manageplayer_page_objects extends TestBase{

	
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
			WebElement source = driver.findElement(By.xpath(sourcepath));
			WebElement target = driver.findElement(By.xpath("//div[@class='content_table___4lVRe']"));
			action.dragAndDrop(source, target).perform();
		} else {
			System.out.println("Your searching layout not in the list");
		}
	}

}
