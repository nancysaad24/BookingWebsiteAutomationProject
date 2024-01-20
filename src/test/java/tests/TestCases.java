package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.ConfirmationPage;
import pageobjects.HomePage;
import pageobjects.ReservePage;
import pageobjects.ResultsPage;
import utils.ExcelReader;

public class TestCases extends BaseClass {
	public WebDriver driver;
	HomePage hp;
	ResultsPage rp;
	ReservePage reservepage;
	ConfirmationPage cp;

	@BeforeClass
	public void loginBeforeTest() throws IOException {
		driver = initializeDriver();
		hp = new HomePage(driver);
		rp = new ResultsPage(driver);
		reservepage = new ReservePage(driver);
		cp = new ConfirmationPage(driver);

		navigateToURL();

	}

	@Test(dataProvider = "reservationData", dataProviderClass = ExcelReader.class, priority = 1)
	public void case01_searchForHotel(String searchText, String checkInMonth, String val, String checkOutMonth,
			String val2) throws InterruptedException {
		hp.dismissSignIn();
		hp.searchLoaction(searchText);
		hp.selectcheckInDate(checkInMonth, val);
		hp.selectCheckOutDate(checkOutMonth, "val2");
		hp.clickSubmitSearch();
	}

	@Test(priority = 2)
	public void selectHotelAndGoToDetailsPage() throws InterruptedException {
		navigateToURL();
		Thread.sleep(4000);
		hp.searchLoaction("Alexandria");
		hp.selectcheckInDate("February 2024", "7");
		hp.selectCheckOutDate("February 2024", "10");
		hp.clickSubmitSearch();
		rp.clickAvailability();
		Assert.assertEquals(reservepage.getHotelNameTxt(), "Tolip Hotel Alexandria");
		Assert.assertEquals(reservepage.getCheckInDate(), "Wed 7 Feb");
		Assert.assertEquals(reservepage.getCheckOutDate(), "Sat 10 Feb");
	}

	@Test(dependsOnMethods = "selectHotelAndGoToDetailsPage")
	public void selectDetailsAndGoToConfirmationPage() {
		reservepage.selectBedOption();
		reservepage.selectAmount();
		reservepage.iWillReserveOption();
		Assert.assertTrue(cp.getHotelNameConf().contains("Tolip Hotel Alexandria"));
		Assert.assertEquals(cp.getCheckInDateConf(), "Wed 7 Feb 2024");
		Assert.assertEquals(cp.getCheckOutDateConf(), "Sat 10 Feb 2024");
	}

	@AfterClass
	public void bookingAfterClass() {
		closeBrowser();

	}

}