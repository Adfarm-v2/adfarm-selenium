package testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Layout_page_objects;

public class Test_Layout extends TestBase {

	public static Layout_page_objects layout;

	@BeforeMethod
	public void beforeMethod() throws IOException {

		layout = new Layout_page_objects();

	}

	@Test
	public void CreateFullscreenLayout() throws InterruptedException {

		layout.FullscreenLayout();
		//layout.BaseLayout();
	}

}
