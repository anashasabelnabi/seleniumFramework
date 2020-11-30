package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	HomePage homeObject ;
	ContactUsPage contactUsObject;
	String testFullName = "Hamza Hasab ELnabi";
	String testEmail = "anashasab12@yahoo.com";
	String testEnquiry = "This is for elbeeeed";
	@Test
	public void userCanContactUs() {
		homeObject = new HomePage(driver);
		contactUsObject = new ContactUsPage(driver);
		homeObject.openContactUsPage();
		contactUsObject.userCanContactUs(testFullName,testEmail,testEnquiry);
		assertEquals(contactUsObject.successResult.getText(),
				"Your enquiry has been successfully sent to the store owner.");
	}

}
