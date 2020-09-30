package runner.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import runner.browsers.BrowserDriver;


public class HomePage {


	@FindBy(partialLinkText = "Profile")
	private WebElement myProfileLink;


	public HomePage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(BrowserDriver.getCurrentDriver(), 10), this);
	}


	public void navigateTo_HomePage() {
		BrowserDriver.loadPage("http://localhost:8080/IBS/portal/ControllerPortal?SSO-Credentials=5002262400365");
	}

	public void clickOnmyProfileLink() {
		//BrowserDriver.waitForElement(myProfileLink, 10);
		myProfileLink.click();
	}

}
	
