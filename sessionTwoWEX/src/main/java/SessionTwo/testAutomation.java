package SessionTwo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class testAutomation {
	
	private WebDriver surfing;
	String sameText;	
	private DSL dsl;
	private testAutomationPage pom;
	
	@Given("^I navigate to \"([^\"]*)\"\\.$")
	public void i_navigate_to_www_amazon_com() throws Throwable {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno\\Documents\\WebDrivers\\chromedriver.exe");
			surfing = new ChromeDriver();
			pom.implicityWait(5);
			surfing.get("https://www.amazon.com/");
			dsl = new DSL(surfing);
			pom = new testAutomationPage(surfing);
		}

	@When("^I select the option \"([^\"]*)\" in the dropdown next to the search text input criteria\\.$")
	public void i_select_the_option_Books_in_the_dropdown_next_to_the_search_text_input_criteria() throws Throwable {
		  WebElement itemMenu = pom.dropDown("searchDropdownBox");
		  Select item = new Select(itemMenu);
		  pom.selectVisibleText("Books");
	}

	@Then("^I search for \"([^\"]*)\".$")
	public void i_search_for_Test_automation() throws Throwable {
		pom.writingText("twotabsearchtextbox", "Test automation");
		pom.clickElementXpath("//div/input[@value='Go']");
	}

	@Then("^I select the cheapest book of the page without using any sorting method available\\.$")
	public void i_select_the_cheapest_book_of_the_page_without_using_any_sorting_method_available() throws Throwable {
		pom.implicityWait(15);
		List<WebElement> listBooks = pom.cssSelector("div[data-cel-widget^='search_result_']");
		Double cheap = null;
		WebElement selectedElement = null;
		
		for (int b=0; b<listBooks.size(); b++) {
			WebElement selected = listBooks.get(b);
			String priceWhole = pom.cssSelectorAndGET(".a-price .a-price-whole");
			String priceFraction = pom.cssSelectorAndGET(".a-price .a-price-fraction");
			String cost = priceWhole+"."+priceFraction;
			Double price = Double.parseDouble(cost);
			
			if (cheap == null) {
				cheap = price;
				selectedElement = selected;
				sameText = pom.cssSelectorAndGETSelected("h2 span");
				
			} else if (price<cheap) {
				selectedElement = selected;
				cheap = price;
				sameText = pom.cssSelectorAndGETSelected("h2 span");
			}
		}
		pom.cssSelectorAndClick(".a-price .a-price-whole");
	}

	@When("^I reach the detailed book page, I check if the name in the header is the same name of the book that I select previously\\.$")
	public void i_reach_the_detailed_book_page_I_check_if_the_name_in_the_header_is_the_same_name_of_the_book_that_I_select_previously() throws Throwable {
		pom.bothTextEquals("ebooksProductTitle");
		surfing.quit();
	}

}
