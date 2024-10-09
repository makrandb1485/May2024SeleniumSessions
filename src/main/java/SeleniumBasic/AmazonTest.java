package SeleniumBasic;

public class AmazonTest {

	public static void main(String[] args) {

		BrowserUtil bu = new BrowserUtil();
		
		bu.initDriver("chrome");
		
		bu.launchURL("https://amazon.com");
		
		String url = bu.getPageUrl();
		System.out.println(url);
		
		String title = bu.getTitlePage();
		System.out.println(title);
		if (title.contains("Amazon")) {
			System.out.println("title pass");
		} else {
			System.out.println("title fail");
		}
		
		bu.quitBrowser();
	}

}
