package SeleniumBasic;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.network.Network;
import org.openqa.selenium.devtools.v126.network.model.RequestId;
import org.openqa.selenium.devtools.v126.network.model.Response;


public class SeleniumNetworkTracking {

	
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devTools.addListener(Network.responseReceived(), responseReceived -> {
            RequestId requestId = responseReceived.getRequestId();
			Response response = responseReceived.getResponse();
			String url = response.getUrl();
			if (url.contains("/contacts")) {
				System.out.println("API Response received for: " + url);
				System.out.println("===response=== " + "\n" );
				System.out.println(response.getStatus() + " " + response.getStatusText());
				
                //get the response body
                Network.GetResponseBodyResponse bodyResponse = devTools.send(Network.getResponseBody(requestId));
                String responseBody = bodyResponse.getBody();
                System.out.println("Response body: " + responseBody);
			}
		});

		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		driver.findElement(By.id("email")).sendKeys("naveen@open.com");
		driver.findElement(By.id("password")).sendKeys("naveen@123");

		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("add-contact")).click();

		driver.quit();
	}
}
