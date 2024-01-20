package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	private WebDriverWait wait;

	
	@FindBy(xpath = "//a[@aria-label='Booking.com']")
	private WebElement logoBtn;
	
	@FindBy(xpath = "//button[@aria-label='Dismiss sign in information.']")
	private WebElement dismissSignInBtn;
	
	@FindBy(xpath = "//input[@Placeholder='Where are you going?']")
	private WebElement searchLocation;

	@FindBy(xpath = "//span[text()='Find your next stay']")
	private WebElement clickAnywhere;

	@FindBy(xpath = "//button[@data-testid='date-display-field-start']")
	private WebElement checkInDateBtn;

	@FindBy(xpath = "(//h3[@aria-live=\"polite\"])[1]")
	private WebElement dateInLeft;

	@FindBy(xpath = "(//h3[@aria-live=\"polite\"])[2]")
	private WebElement dateInRight;

	@FindBy(xpath = "//button[@data-testid='date-display-field-end']")
	private WebElement checkOutDateBtn;

	@FindBy(xpath = "//div[@data-testid='searchbox-datepicker-calendar']//button[contains(@class,'f073249358')]")
	private WebElement nextCalBtn;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitSearchBtn;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
	}

	public void dismissSignIn() {
		dismissSignInBtn.click();
	}
	
	public void clickLogoBtn() {
		logoBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@Placeholder='Where are you going?']")));
	}

	public void searchLoaction(String searchlocation) {
		searchLocation.clear();
		searchLocation.sendKeys(searchlocation);
		//clickAnywhere.click();
	}

	public void clickCheckInDateBtn() {
		checkInDateBtn.click();
	}

	public void clickCheckOutDateBtn() {
		checkOutDateBtn.click();
	}

	public void clickNextCalBtn() {
		nextCalBtn.click();
	}

	public void addCheckinDate() {
		nextCalBtn.click();
	}

	public String getDateInLeft() {
		return dateInLeft.getText();
	}

	public String getDateInRight() {
		return dateInRight.getText();
	}


	public void selectcheckInDate(String checkInMonth, String val) {
		clickCheckInDateBtn();
		while (true) {
			String month = getDateInLeft().trim();
			if (month.equalsIgnoreCase(checkInMonth.trim())) {
				break;
			} else {
				clickNextCalBtn();
			}
		}

		List<WebElement> ele = driver.findElements(By.xpath("(//tbody)[1]//tr//td/span"));
		for (WebElement element : ele) {
			String date = element.getText();
			if (date.equals(val)) {
				element.click();
				break;
			}
		}
	}

	public void selectCheckOutDate(String checkOutMonth, String val2) {
		String month2 = getDateInRight();
		String month = getDateInLeft();
		while (true) {

			if (month2.equalsIgnoreCase(checkOutMonth) || month.equalsIgnoreCase(checkOutMonth)) {
				break;
			} else {
				clickNextCalBtn();
			}
		}

		if (month2.equalsIgnoreCase(checkOutMonth)) {
			List<WebElement> ele = driver.findElements(By.xpath("(//tbody)[2]//tr//td/span"));
			for (WebElement element : ele) {
				String date = element.getText();
				if (date.equals(val2)) {
					element.click();
					break;
				}
			}
		} else {
			List<WebElement> eleL = driver.findElements(By.xpath("(//tbody)[1]//tr//td/span"));
			for (WebElement elementL : eleL) {
				String date2 = elementL.getText();
				if (date2.equals(val2)) {
					elementL.click();
					break;
				}
			}
		}
	}
	
	public void clickSubmitSearch() {
		submitSearchBtn.click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'efdb2b543b e4b7a69a57']")));
	}

}
