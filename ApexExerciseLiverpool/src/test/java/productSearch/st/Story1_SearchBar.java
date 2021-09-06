package productSearch.st;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import productSearch.po.mainPage;

public class Story1_SearchBar {

	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\laere\\eclipse-workspace\\dependencies\\chromedriver.exe");
	}
	
	@Test
	public void TC_01_searchProduct() {	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.liverpool.com.mx/tienda/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		mainPage oSearch = PageFactory.initElements(driver, mainPage.class);
		
		SoftAssert softAssert = new SoftAssert();
			oSearch.enterSearchValue("Sony");
			oSearch.triggerSearch();
			System.out.println("Search Completed");
			softAssert.assertNotEquals(oSearch.searchResults(), "319 Productos");
			System.out.println("TS validation completed: " + oSearch.searchResults());
			
	}
	

}
