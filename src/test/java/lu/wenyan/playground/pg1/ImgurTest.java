package lu.wenyan.playground.pg1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import junit.framework.Assert;
import lu.wenyan.playground.site.BasePage;
import lu.wenyan.playground.site.imgur.ImgurSite;

public class ImgurTest {

	private WebDriver webDriver = null;
	private ImgurSite imgurSite = null;

	@Test
	public void basicSearchBarTest() {
		Assert.assertTrue(this.imgurSite.imgurHomePage().isSafe());

		File jpg = new File("./Chrysanthemum.jpg");
		this.imgurSite.imgurHomePage().uploadImage(jpg.getAbsolutePath());
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

		this.imgurSite = new ImgurSite(this.webDriver);
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
