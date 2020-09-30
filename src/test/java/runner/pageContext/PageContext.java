package runner.pageContext;

import runner.pages.HomePage;
import runner.pages.TransactionPage;

public class PageContext {

	//private WebDriver driver;
	private HomePage homePage;
	private TransactionPage transactionPage;

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage() : homePage;
	}
	public TransactionPage getTransactionPage() {
		return (transactionPage == null) ? transactionPage = new TransactionPage() : transactionPage;
	}
}