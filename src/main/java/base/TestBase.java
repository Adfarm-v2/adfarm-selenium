package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;
	public static Properties properties = null;

	public Properties loadpropertyfile() throws IOException {
		FileInputStream fileinputstream = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(fileinputstream);
		return properties;
	}

	@BeforeSuite
	public void launchbrowser() throws IOException {

		loadpropertyfile();

		String Driverlocation = properties.getProperty("driverlocation");
		String Url = properties.getProperty("url");

		System.setProperty("webdriver.chrome.driver", Driverlocation);
		driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void teardown() {

		// driver.quit();

	}
}