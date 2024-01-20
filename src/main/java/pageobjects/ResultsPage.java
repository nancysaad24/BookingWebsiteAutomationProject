package pageobjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
	private WebDriver driver;
	private WebDriverWait wait;


	@FindBy(xpath = "//div[text()='Tolip Hotel Alexandria']")
	private WebElement seeAvailabilityBtn;

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	public void clickAvailability() {
		Actions actions = new Actions(driver);
		actions.scrollToElement(seeAvailabilityBtn);
		seeAvailabilityBtn.click();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String tab : windowHandles) {
		    driver.switchTo().window(tab);
		}
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class = 'd2fee87262 pp-header__title']")));
	}

}
