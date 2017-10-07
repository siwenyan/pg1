package lu.wenyan.playground.site.wiki;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import lu.wenyan.playground.site.BasePage;

public class WikiPage extends BasePage {

	@FindBy(how = How.ID, using = "searchInput")
	public WebElement searchInput;

	@FindBy(how = How.ID, using = "firstHeading")
	public WebElement firstHeading;

	@FindBy(how = How.XPATH, using = "//div[@id='toc']//a")
	public WebElement hide;

	public WikiPage(WebDriver webDriver) {
		super(webDriver);
	}

	public boolean isSafe() {
		try {
			this.waitForPresence(By.id("firstHeading"));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public void hideContent() {
		this.hide.click();
	}

	public boolean panelIsHidden() {
		try {
			this.waitUntilAttributeContains(By.xpath("//div[@id='toc']/ul"), "style", "display: none;");
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean autocompleteDropDown() {
		try {
			this.waitUntilAttributeNotContains(By.xpath("/html/body/div[@class='suggestions']"), "style",
					"display: none;");
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public WebElement findSuggestion(String expectedTitle) {
		return this.webDriver.findElement(By.linkText(expectedTitle));
	}

}
