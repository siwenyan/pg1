package lu.wenyan.playground.site.wiki;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import lu.wenyan.playground.site.BasePage;

public class WikiHomePage extends BasePage {

	@FindBy(how = How.ID, using = "searchInput")
	public WebElement searchInput;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public WebElement submitButton;

	public WikiHomePage(WebDriver webDriver) {
		super(webDriver);
	}

	@Override
	public boolean isSafe() {
		try {
			this.waitForPresence(By.id("searchInput"));
			this.waitForPresence(By.xpath("//button[@type='submit']"));
			return true;
		} catch(TimeoutException e) {
			return false;
		}
	}

	public void goTo() {
		this.webDriver.get("https://www.wikipedia.org/");
	}

	public void search(String q) {
		this.searchInput.sendKeys(q);
		this.submitButton.click();
	}

}
