package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Login_page_objects;

public class TestBase {

	public static WebDriver driver;
	public static Robot robo;
	public static Properties properties = null;

	public Properties loadpropertyfile() throws IOException {
		FileInputStream fileinputstream = new FileInputStream("config.properties");
		
		properties = new Properties();
		properties.load(fileinputstream);
		return properties;
	}

	public void launchbrowser() throws IOException {
		loadpropertyfile();
		String DriverLocation = properties.getProperty("driverlocation");
		String Url = properties.getProperty("url");
		System.setProperty("webdriver.chrome.driver", DriverLocation);
		driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
	}

	public void loginpage() throws IOException {
		loadpropertyfile();
		PageFactory.initElements(driver, Login_page_objects.class);
		String Username = properties.getProperty("username");
		String Password = properties.getProperty("password");
		Login_page_objects.uname.sendKeys(Username);
		Login_page_objects.pwd.sendKeys(Password);
		Login_page_objects.logbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void keydown() throws AWTException {
		robo = new Robot();
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyRelease(KeyEvent.VK_DOWN);
	}

	public static void keyenter() throws AWTException {
		robo = new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void controlv() throws AWTException {
		robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.setAutoDelay(3000);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
	}

}
