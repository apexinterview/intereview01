package productSearch.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class mainPage {
	
	WebDriver Driver;
	public mainPage(WebDriver d) {
		this.Driver = d;
		
	}

	//Page Objects
	@FindBy (how = How.XPATH, using="//input[@class='form-control search-bar plp-no__results' and @label='Buscar ...']") private WebElement txtbx_searchBar;
	@FindBy (how = How.XPATH, using="//button[@class='input-group-text']") private WebElement btn_iconSearch;
	@FindBy (how = How.XPATH, using= "//h1[@class='a-headline__typeahed searcherTitle-result']//span[@class='searchNum-result']") private WebElement searchSuccess;
	@FindBy (how = How.XPATH, using= "//p[@class='a-plp-results-title']") private WebElement searchCatLabel;
	
	public void enterSearchValue(String arg) {
		txtbx_searchBar.sendKeys(arg);
		
	}
	
	public void triggerSearch() {
		btn_iconSearch.click();
	}
	
	public String searchResults() {
		return searchCatLabel.getText();
 	}
}
