package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="small-searchterms")
	WebElement searchInput;
	
	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id="ui-id-1")		
	WebElement searchDropMenu;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productDetailsPage;
	
	public void userCanSearchProduct(String searchText) {
		setText(searchInput, searchText);
		clickButton(searchBtn);	
	}
	public void userCanOpenProductDetailsPage() {
		clickButton(productDetailsPage);
	}
}
