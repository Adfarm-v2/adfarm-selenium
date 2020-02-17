package testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pages.Login_page_objects;

public class Test_Logintest extends TestBase {

	public static Login_page_objects Ddpage;

	String[][] data = null;

	@BeforeMethod
	public void before() throws IOException {

		launchbrowser();
		Ddpage = new Login_page_objects();
	}

	@DataProvider(name = "logindata")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data = GetExcelData();
		return data;
	}

	public String[][] GetExcelData() throws BiffException, IOException {

		FileInputStream m = new FileInputStream("C:\\Users\\YSelvaraj\\Desktop\\ad-excel\\ERPTesting.xls");
		Workbook excel = Workbook.getWorkbook(m);
		Sheet sheet = excel.getSheet("loginsheet");
		int rowcount = sheet.getRows();
		int columncount = sheet.getColumns();

		String testdata[][] = new String[rowcount - 1][columncount - 1];

		for (int i = 1; i < rowcount; i++) {
			for (int j = 1; j < columncount; j++) {
				testdata[i - 1][j - 1] = sheet.getCell(j, i).getContents();
			}
		}

		return testdata;
	}

	@Test(dataProvider = "logindata")
	public void logincheck(String uname, String pwd) {

		Ddpage.logincheck(uname, pwd);

		// driver.quit();
	}

}
