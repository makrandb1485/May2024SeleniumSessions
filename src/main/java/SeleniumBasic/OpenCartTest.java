package SeleniumBasic;

public class OpenCartTest {

	public static void main(String[] args) {

		BrowserUtil bu = new BrowserUtil();
		
		bu.initDriver("chrome");
		
		bu.launchURL("https://naveenautomationlabs.com/opencart/index.php");
		
		String url = bu.getPageUrl();
		System.out.println(url);
		
		String title = bu.getTitlePage();
		System.out.println(title);
		if (title.contains("Your Store")) {
			System.out.println("title pass");
		} else {
			System.out.println("title fail");
		}
		
		bu.quitBrowser();
		
	}

}
