package lu.wenyan.playground.pg1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import lu.wenyan.playground.site.BasePage;
import lu.wenyan.playground.site.wiki.WikiSite;

public class WikiTest {

	private WebDriver webDriver = null;
	private WikiSite wikiSite = null;

	@Test
	public void basicSearchBarTest() {
		Assert.assertTrue(this.wikiSite.wikiHomePage().isSafe());

		this.wikiSite.wikiHomePage().search("Puppies");
		Assert.assertTrue(this.wikiSite.wikiPage().isSafe());
		Assert.assertEquals("Puppy", this.wikiSite.wikiPage().firstHeading.getText());
	}

	@Test(dependsOnMethods = { "basicSearchBarTest" })
	public void hideContentsTest() {
		this.wikiSite.wikiPage().hideContent();
		Assert.assertTrue(this.wikiSite.wikiPage().panelIsHidden());
	}

	@Test(dependsOnMethods = { "hideContentsTest" })
	public void autocompleteSearchTest() {
		this.wikiSite.wikiPage().searchInput.sendKeys("Franc");
		Assert.assertTrue(this.wikiSite.wikiPage().autocompleteDropDown());

		WebElement suggestionFrance = this.wikiSite.wikiPage().findSuggestion("France");
		Assert.assertNotNull(suggestionFrance);
		System.out.println(suggestionFrance.getAttribute("href"));

		suggestionFrance.click();
		Assert.assertTrue(this.wikiSite.wikiPage().isSafe());
		Assert.assertEquals("France", this.wikiSite.wikiPage().firstHeading.getText());
	}

	@AfterMethod
	public void afterMethod() {
		BasePage.wait(2);
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		this.webDriver = new ChromeDriver();

		// System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
		// this.webDriver = new FirefoxDriver();

		this.wikiSite = new WikiSite(this.webDriver);
	}

	@AfterTest
	public void afterTest() {
		if (null != this.webDriver) {
			try {
				this.webDriver.quit();
			} finally {
				this.webDriver = null;
			}
		}
	}

}
