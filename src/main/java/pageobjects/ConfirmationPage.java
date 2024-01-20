package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//div[@class='bui-date-range bui-date-range--large bp-date-range']/div[1]/time/span[1]")
	private WebElement checkinDate;

	@FindBy(xpath = "//div[@class='bui-date-range bui-date-range--large bp-date-range']/div[2]/time/span[1]")
	private WebElement checkOutDate;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phone;

	@FindBy(xpath = "//span[contains(text(),'Final details')]")
	private WebElement finalStepBtn;

	@FindBy(xpath = "//div[@class='bp-mfe-container--property-details']")
	private WebElement hotelName;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	public String getHotelNameConf() {
		return hotelName.getText();
	}

	public String getCheckInDateConf() {
		return checkinDate.getText();
	}

	public String getCheckOutDateConf() {
		return checkOutDate.getText();
	}

	public void addFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}

	public void addLastName(String lasttname) {
		lastName.sendKeys(lasttname);
	}

	public void addEmail(String mail) {
		email.sendKeys(mail);
	}

	public void addPhone(String phoneno) {
		phone.sendKeys(phoneno);
	}

	public void clickFinal() {
		finalStepBtn.click();
	}

}
