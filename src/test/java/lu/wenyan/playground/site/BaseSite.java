package lu.wenyan.playground.site;

import org.openqa.selenium.WebDriver;

public class BaseSite {

	protected WebDriver webDriver = null;

	public BaseSite(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

}