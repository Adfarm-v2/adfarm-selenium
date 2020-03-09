package testcases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pages.Manageplayer_page_objects;
import pages.Playerdetails_page_objects;

public class Test_Myplayers extends TestBase {

	String[][] data = null;

	public static Playerdetails_page_objects player;
	public static Manageplayer_page_objects manageplayer;

	@BeforeMethod
	public void beforeMethod() throws IOException {

		player = new Playerdetails_page_objects();
		manageplayer = new Manageplayer_page_objects();

	}

	@DataProvider(name = "playerdata")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data = GetExcelData();
		return data;
	}

	public String[][] GetExcelData() throws BiffException, IOException {

		FileInputStream m = new FileInputStream(excelpath);
		Workbook excel = Workbook.getWorkbook(m);
		Sheet sheet = excel.getSheet("playersheet");
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

	@Test(dataProvider = "playerdata")
	public void Createplayer(String uname, String pwd, String name, String status, String distname, String dealername,
			String customername, String locationname, String contpername, String contmobnum, String conteid,
			String add1, String add2, String countryname, String statename, String cityname, String groupname,
			String zipcode, String area, String locationcost, String tag, String typeofcustomer, String opentime,
			String closetime) throws AWTException, InterruptedException {

		player.createplayer(uname, pwd, name, status, distname, dealername, customername, locationname, contpername,
				contmobnum, conteid, add1, add2, countryname, statename, cityname, groupname, zipcode, area,
				locationcost, tag, typeofcustomer, opentime, closetime);

		// driver.quit();
	}

	@Test(enabled = false)
	public void Editplayer() {

		player.editplayerdetails();
	}

	@Test(enabled = false)
	public void Playerdetails() {

		player.playerdetails();
	}

	@Test(enabled = false)
	public void Manageplayer() throws InterruptedException {

		manageplayer.manageplayer();

	}

//	@AfterMethod
//	public void afterMethod() {
////		driver.quit();
//	}

}
