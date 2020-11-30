package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject ;
	ProductDetailsPage productdetailsObject;
	@Test
	public void userCanSearchProduct() throws InterruptedException {
		searchObject = new SearchPage(driver);
		searchObject.userCanSearchProduct(productName);
		searchObject.userCanOpenProductDetailsPage();
		productdetailsObject = new ProductDetailsPage(driver);
		assertEquals(productdetailsObject.productNameTest.getText(),productName);	
	}

}
