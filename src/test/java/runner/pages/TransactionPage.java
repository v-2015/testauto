package runner.pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import runner.browsers.BrowserDriver;

public class TransactionPage {

	@FindBy(className = "user-info")
	private WebElement actualUserName;

	public void verifyUserName(String expectedUserName) {
		//BrowserDriver.waitForElement(actualUserName, 10);
		assertThat(expectedUserName, containsString(actualUserName.getText()));
	}
	public TransactionPage() {
//		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(BrowserDriver.getCurrentDriver(), 10), this);
	}

}
