package SessionTwo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class testAutomationPage {
	
	private DSL dsl;
	
	public testAutomationPage(WebDriver surfing) {
		dsl = new DSL(surfing);
	}
	
	public void selectVisibleText(String text) {
		dsl.visibleText("Books");
	}
	
	public void clickElementXpath (String xpath) {
		dsl.clickElement("//div/input[@value='Go']");
	}
	
	public WebElement dropDown(String id){
		return dsl.selectDropdown("searchDropdownBox");
	}
	
	public void writingText(String id_field, String text) {
		dsl.writing(id_field, text);
	}
	
	public void bothTextEquals(String id) {
		dsl.bothText(id);
	}
	
	public void implicityWait(Integer sec) {
		dsl.manageTimeoutImplicitywait(sec);	
	}
	
	public List<WebElement> cssSelector(String cssSelector) {
		return dsl.findByCssSelector(cssSelector);
	}
	
	public String cssSelectorAndGET(String cssSelector) {
		return dsl.findByCssSelectorAndGET(cssSelector);
	}
	
	public String cssSelectorAndGETSelected(String cssSelector) {
		return dsl.findByCssSelectorAndGETSelected(cssSelector);
	}
	
	public String cssSelectorAndClick(String cssSelector) {
		return dsl.findByCssSelectorAndClick(cssSelector);
	}
	
}
