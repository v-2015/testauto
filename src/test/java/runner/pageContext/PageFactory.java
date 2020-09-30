package runner.pageContext;

public class PageFactory {
	private static PageContext pageContext = null;

	public static synchronized PageContext getPageContext(){
		if(pageContext == null){
			pageContext = new PageContext();
		}
		return pageContext;
	}

}
