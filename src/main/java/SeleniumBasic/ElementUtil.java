package SeleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
	
	private WebDriver driver;
	
	ElementUtil(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getLocator(By locator) {
		return driver.findElement(locator);
		
	}
	
	public void doSendKeys(By locator, String value) {
		getLocator(locator).sendKeys(value);
	}
	
	public void elementClick(By locator) {
		getLocator(locator).click();
	}
	
	public String getText(By locator) {
		return getLocator(locator).getText();
	}
	
	public boolean isElementDisplayed(By locator) {
		try {
			return getLocator(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not displayed : " + locator);
			return false;
		}

	}
	
	public boolean isElementEnabled(By locator) {
		return getLocator(locator).isEnabled();
	}
	
	
	public boolean isElementSelected(By locator) {
		return getLocator(locator).isSelected();
	}
	
	public String doGetElementText(By locator) {
		String eleText = getLocator(locator).getText();
			if(eleText!=null) {
				return eleText;
			}
			else {
				System.out.println("Element text is null:" + eleText);
				return null;
			}
	}
	
	public String doElementGetAttribute(By locator, String attrName) {
		return getLocator(locator).getAttribute(attrName);
	}

}
