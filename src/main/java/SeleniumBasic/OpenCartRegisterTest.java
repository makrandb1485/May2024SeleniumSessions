package SeleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartRegisterTest {

	public static void main(String[] args) {

		BrowserUtil bu = new BrowserUtil();
		
		WebDriver driver = bu.initDriver("chrome");
		
		bu.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		ElementUtil eu = new ElementUtil(driver);
		
		By registerPageHeader = By.tagName("h1");
		String header = eu.getText(registerPageHeader);
		System.out.println(header);
		if(header.equals("Register Account")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		By firstName = By.id("input-firstname");
		eu.doSendKeys(firstName, "Mak");
		
		By lastName = By.id("input-lastname");
		eu.doSendKeys(lastName, "Ban");
		
		By eMail = By.id("input-email");
		eu.doSendKeys(eMail, "mak2.ban@gmail.com");
		
		By telephone = By.id("input-telephone");
		eu.doSendKeys(telephone, "5656454545");
		
		By password = By.id("input-password");
		eu.doSendKeys(password, "test@123");
		
		By passwordConfirm = By.id("input-confirm");
		eu.doSendKeys(passwordConfirm, "test@123");
		
		By privacyPolicyCheckbox = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
		eu.elementClick(privacyPolicyCheckbox);
		
		By continueButton = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		eu.elementClick(continueButton);
		
		By successHeader = By.tagName("h1");
		String s_header = eu.getText(successHeader);
		System.out.println(s_header);
		if(s_header.equals("Your Account Has Been Created!")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		bu.quitBrowser();
	}

}
