package lu.wenyan.playground.site.wiki;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import lu.wenyan.playground.site.BaseSite;

public class WikiSite extends BaseSite {

	private WikiHomePage wikiHomePage = null;

	private WikiPage wikiPage = null;

	public WikiSite(WebDriver webDriver) {
		super(webDriver);

		this.webDriver.get("https://www.wikipedia.org/");
		this.wikiHomePage = PageFactory.initElements(this.webDriver, WikiHomePage.class);
		this.wikiPage = PageFactory.initElements(this.webDriver, WikiPage.class);
	}

	public WikiHomePage wikiHomePage() {
		PageFactory.initElements(this.webDriver, this.wikiHomePage);
		return this.wikiHomePage;
	}

	public WikiPage wikiPage() {
		PageFactory.initElements(this.webDriver, this.wikiPage);
		return this.wikiPage;
	}

}
