package lu.wenyan.playground.site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	private static final int TIMEOUT_SECONDS = 10;

	protected WebDriver webDriver = null;

	private WebDriverWait wait = null;

	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// do nothing
		}
	}

	public BasePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.wait = new WebDriverWait(this.webDriver, TIMEOUT_SECONDS);
	}

	protected void waitForPresence(By by) {
		this.wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	protected void waitUntilAttributeContains(By by, String attribute, String value) {
		this.wait.until(ExpectedConditions.attributeContains(by, attribute, value));
	}

	protected void waitUntilAttributeNotContains(By by, String attribute, String value) {
		this.wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(by, attribute, value)));
	}

	abstract public boolean isSafe();

}
