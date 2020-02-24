package SessionTwo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DSL {
	
	private WebDriver surfing;

	public DSL(WebDriver surfing) {
		this.surfing = surfing;
	}
	
	
	/****** VisibleText ******/
	
	public void visibleText(String text) {
		surfing.selectByVisibleText(text);
	}
	
	
	/****** XPath ******/
		
	public void clickElement (String xpath) {
		surfing.findElement(By.xpath(xpath)).click();
	}	
	
	
	/****** ID ******/
	
	public WebElement selectDropdown(String id){
		return surfing.findElement(By.id(id));
	}
	
	public void writing(String id_field, String text) {
		surfing.findElement(By.id(id_field)).sendKeys(text);
	}
	
	public void bothText(String id) {
		Assert.assertEquals(sameText, surfing.findElement(By.id(id)).getText());
	}
	
	
	/****** ImplicitlyWait ******/
	
	public void manageTimeoutImplicitywait(Integer sec) {
		surfing.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);	
	}
	
	
	/****** CSS Selector ******/
	
	public List<WebElement> findByCssSelector(String cssSelector) {
		return surfing.findElements(By.cssSelector(cssSelector));
	}
	
	public String findByCssSelectorAndGET(String cssSelector) {
		return selected.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public String findByCssSelectorAndGETSelected(String cssSelector) {
		return selectedElement.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public String findByCssSelectorAndClick(String cssSelector) {
		return selectedElement.findElement(By.cssSelector(cssSelector)).click();
	}
	
}
