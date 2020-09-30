package runner.browsers;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {

	private static final String BROWSER_PROP_KEY = "browser";

	public static WebDriver getBrowser() {
		Browsers browser;
		WebDriver driver;

		if (System.getProperty(BROWSER_PROP_KEY) == null) {
			browser = Browsers.FIREFOX;
		} else {
			browser = Browsers.browserForName(System.getProperty(BROWSER_PROP_KEY));
		}
		switch (browser) {
			case CHROME:
				driver = createChromeDriver();
				break;
			case FIREFOX:
			default:
				driver = createFirefoxDriver();
				break;
		}
		addAllBrowserSetup(driver);
		return driver;
	}

	private static WebDriver createChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		return new ChromeDriver();
	}

	private static WebDriver createFirefoxDriver() {
		if (SystemUtils.IS_OS_WINDOWS) {
			System.setProperty(
					"webdriver.gecko.driver", "src/test/resources/wires.exe");
		} else {
			System.setProperty(
					"webdriver.gecko.driver", "src/test/resources/wires");
		}
		return new FirefoxDriver();
	}

	private static void addAllBrowserSetup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(0, 0));
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
		driver.manage().window().setSize(dim);
	}

}
