package lu.wenyan.playground.site.imgur;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import lu.wenyan.playground.site.BasePage;

public class ImgurHomePage extends BasePage {

	@FindBy(how = How.ID, using = "create-dropdown-button")
	public WebElement createDropdownButton;

	@FindBy(how = How.LINK_TEXT, using = "Upload Images")
	public WebElement buttonUploadImages;

	@FindBy(how = How.ID, using = "global-files-button")
	public WebElement globalFilesButton;

	public ImgurHomePage(WebDriver webDriver) {
		super(webDriver);
	}

	@Override
	public boolean isSafe() {
		try {
			this.waitForPresence(By.id("create-dropdown-button"));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public void uploadImage(String path) {
		this.createDropdownButton.click();
		buttonUploadImages.click();
		globalFilesButton.sendKeys(path);
	}

}
