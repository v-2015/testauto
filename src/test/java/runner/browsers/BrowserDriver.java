package runner.browsers;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserDriver {
	private static final Logger LOGGER = Logger.getLogger(BrowserDriver.class.getName());
	private static WebDriver wDriver;
	
	public synchronized static WebDriver getCurrentDriver() {
		if (wDriver==null) {
			try {
				wDriver = BrowserFactory.getBrowser();
	        } catch (UnreachableBrowserException e) {
				wDriver = BrowserFactory.getBrowser();
	        } catch (WebDriverException e) {
				wDriver = BrowserFactory.getBrowser();
	        }finally{
	        	Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
	        }
		}
        return wDriver;
    }
	
	public static void close() {
        try {
            getCurrentDriver().quit();
			wDriver = null;
            LOGGER.info("closing the browser");
        } catch (UnreachableBrowserException e) {
            LOGGER.info("cannot close browser: unreachable browser");
        }
    }
	
	private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }
    }
	
	public static void loadPage(String url){
		getCurrentDriver();
        LOGGER.info("try to loadPage [" + url + "]");
        getCurrentDriver().get(url);
	}
	

	public static WebElement waitForElement(WebElement elementToWaitFor){
		return waitForElement(elementToWaitFor, null);
	}
	
	public static WebElement waitForElement(WebElement elementToWaitFor, Integer waitTimeInSeconds) {
	    if (waitTimeInSeconds == null) {
	    	waitTimeInSeconds = 10;
	    }
	    
	    WebDriverWait wait = new WebDriverWait(getCurrentDriver(), waitTimeInSeconds);
	    return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
	}

}

