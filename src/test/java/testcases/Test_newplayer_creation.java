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
import pages.Player_details_page_objets;

public class Test_newplayer_creation extends TestBase {

	String[][] data = null;

	public static Player_details_page_objets player;

	@BeforeMethod
	public void beforeMethod() throws IOException {

		player = new Player_details_page_objets();
		
	}

	@DataProvider(name = "playerdata")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data = GetExcelData();
		return data;
	}

	public String[][] GetExcelData() throws BiffException, IOException {

		//FileInputStream m = new FileInputStream("C:\\Users\\Gopinath\\Desktop\\Exceldata\\ERPTesting.xls");
		FileInputStream m = new FileInputStream("C:\\Users\\Jothi\\Desktop\\Adfarm Excel Data\\ERPTesting.xls");
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

	@Test(dataProvider = "playerdata",enabled=false)
	public void logincheck(String uname, String pwd, String name, String status, String dealername, String customername,
			String locationname, String contpername, String contmobnum, String conteid, String add1, String add2,
			String countryname, String statename, String cityname, String groupname, String zipcode, String area,
			String locationcost, String tag, String typeofcustomer, String opentime, String closetime) throws AWTException, InterruptedException {

		player.createnewplayer(uname, pwd, name, status, dealername, customername, locationname, contpername, contmobnum,
				conteid, add1, add2, countryname, statename, cityname, groupname, zipcode, area, locationcost, tag,
				typeofcustomer, opentime, closetime);

		// driver.quit();
	}

	@Test(priority=1)
	public void verifyplayerlist() {

		player.playerverification();
	}
	
	@Test(priority=2)
	public void verifymanageplayer() throws InterruptedException {
	
		player.manageplayer();
		
	}

//	@AfterMethod
//	public void afterMethod() {
////		driver.quit();
//	}

}
