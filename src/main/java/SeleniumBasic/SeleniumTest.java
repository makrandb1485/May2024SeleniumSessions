package SeleniumBasic;

//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {

	public static void main(String[] args) {

		//ChromeDriver driver = new ChromeDriver();
		//EdgeDriver driver = new EdgeDriver();
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equals("Google")) {
			
			System.out.println("Title is correct - PAAS");
		
		}else {
			
			System.out.println("Title is incorrect - FAILED");
		}
		
		driver.quit();
	}

}
