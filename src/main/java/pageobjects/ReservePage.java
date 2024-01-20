package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReservePage {
	private WebDriver driver;
	private WebDriverWait wait;


	@FindBy(xpath = "//table[contains(@class, 'hprt-table  hprt-table-long-language ']//tbody")
	private WebElement detailsTablebody;

	@FindBy(xpath="//button[@id='hp_book_now_button']")
	private WebElement bookNowBtn;
	
	@FindBy(xpath="//input[@name='bedPreference_78883120' and @value='2']")
	private WebElement largeBedOption;
	
	@FindBy(xpath="//select[@id='hprt_nos_select_78883120_373531459_0_33_0_131741']")
	private WebElement amountMenu;
	
	@FindBy(xpath="//button/span[contains(text(), 'reserve')]")
	private WebElement iWillReserve;
	
	
	@FindBy(xpath="//h2[contains(@class, \"pp-header__title\")]")
	private WebElement hotelName;
	
	@FindBy(xpath="/html/body/div[3]/div/div[6]/div[1]/div[1]/div[5]/div/div[3]/div/div/form/div[1]/div[1]/div/div/button[1]/span")
	private WebElement checkinDate;
	
	@FindBy(xpath="/html/body/div[3]/div/div[6]/div[1]/div[1]/div[5]/div/div[3]/div/div/form/div[1]/div[1]/div/div/button[2]/span")
	private WebElement checkOutDate;
	
			

	public ReservePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}
	 public String getHotelNameTxt() {
	        return hotelName.getText();
	    }

	
	public void selectBedOption() {
		largeBedOption.click();
		
	}
	
	public void selectAmount() {
	     Select amountDropDownMenu = new Select(amountMenu);
	     amountDropDownMenu.selectByValue("1");
		
	}
	

	public void iWillReserveOption() {
		iWillReserve.click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[@class = 'a3332d346a beb15c03b0']")));
	}
	
	 public String getCheckInDate() {
	        return checkinDate.getText();
	    }

	 public String getCheckOutDate() {
	        return checkOutDate.getText();
	    }

	

}
