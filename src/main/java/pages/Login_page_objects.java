package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_page_objects {
	
	@FindBy(xpath = "//input[@id='login_id']")
	public static WebElement uname;

	@FindBy(id = "password")
	public static WebElement pwd;

	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement logbtn;


}
