package lu.wenyan.playground.site.imgur;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ImgurSite {

	private WebDriver webDriver = null;

	private ImgurHomePage imgurHomePage = null;

	public ImgurSite(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.webDriver.get("https://imgur.com/");
		this.imgurHomePage = PageFactory.initElements(this.webDriver, ImgurHomePage.class);
	}

	public ImgurHomePage imgurHomePage() {
		PageFactory.initElements(this.webDriver, this.imgurHomePage);
		return this.imgurHomePage;
	}

}
