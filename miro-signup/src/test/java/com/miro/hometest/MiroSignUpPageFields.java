package com.miro.hometest;

/*This test class validates all the 
 * UI elements on Miro Signup page
 * createdBy Mayank Gupta*/

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import com.miro.utility.MiroUtility;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MiroSignUpPageFields extends MiroUtility {

	private String miroTitlePath = "//a[@class='overlay-signup__logo']";
	private String miroHeaderPath = "//h1[contains(@class,'signup__title-form')]";
	private String miroDropdownPath = "//div[contains(@class,'speero-trig-dropdown')]";
	private String fbOptionPath = "//img[@alt='Sign up with Facebook']";
	private String linkPath = "//div[@class='signup__checkbox-list']//";
	private String termsPath = "//h2[contains(text(),'Terms of Service')]";
	private String privacyPolicyPath = "//h2[contains(text(),'Privacy Policy')]";
	private String pwdHintPath = "//div[contains(@class,'signup__input-hint-text')]";

	@Before
	public void setUp() {
		// create a webdriver
		openDriver();

		// navigate to miro signup page
		navigateToMiro();
	}

	@After
	public void tearDown() {
		// close the driver
		quitDriver();
	}

	@Test
	public void testCase01_MiroTitle() {

		// validate the miro signup page title
		String text = getPageText(miroTitlePath);
		Assert.assertTrue(text.contains("Miro"));
	}

	@Test
	public void testCase02_MiroHeader() {

		// validate the miro signup page header
		String text = getPageText(miroHeaderPath);
		Assert.assertTrue(text.contains("Get started free today"));
	}

	@Test
	public void testCase03_NameWorkPasswordFields() {

		// get the name, email & password field element from signup page
		WebElement nameField = getPageElementByID("name");
		WebElement emailField = getPageElementByID("email");
		WebElement passwordField = getPageElementByID("password");

		// validate that these fields are present on form
		Assert.assertTrue(nameField.isDisplayed());
		Assert.assertTrue(emailField.isDisplayed());
		Assert.assertTrue(passwordField.isDisplayed());
	}

	@Test
	public void testCase04_DropdownField() {

		// get the dropdown element from signup page
		WebElement dropdown = getPageElementByXpath(miroDropdownPath);

		// validate the dropdown element
		Assert.assertTrue(dropdown.isDisplayed());
	}

	@Test
	public void testCase05_CheckboxFields() {

		// get the checkboxes field elements from signup page
		WebElement term = getPageElementByID("signup-terms-desc");
		WebElement subscribe = getPageElementByID("signup-subscribe-desc");

		// validate that these checkboxes are present on form & are not selected by default
		Assert.assertFalse(term.isSelected());
		Assert.assertFalse(subscribe.isSelected());
	}

	@Test
	public void testCase06_SignUpButton() {

		// get the signUp button from signup page
		WebElement signUpBtn = getPageElementByClass("signup__submit");

		// validate that signup is present on form
		Assert.assertTrue(signUpBtn.isDisplayed());
	}

	@Test
	public void testCase07_OtherSignupOptions() {

		// get the google, slack, office, fb, apple elements from signup page
		String googleOption = getElementAttribute("kmq-google-button");
		String slackOption = getElementAttribute("kmq-slack-button");
		String officeOption = getElementAttribute("kmq-office365-button");
		WebElement fbOption = getPageElementByXpath(fbOptionPath);
		WebElement appleOption = getPageElementByID("apple-auth");

		// validate the google, slack, office, fb, apple signup options on signup page
		Assert.assertTrue(googleOption.contains("https://accounts.google.com"));
		Assert.assertTrue(slackOption.contains("https://slack.com"));
		Assert.assertTrue(officeOption.contains("https://login.microsoftonline.com"));
		Assert.assertTrue(fbOption.isDisplayed());
		Assert.assertTrue(appleOption.isDisplayed());
	}
	
	@Test
	public void testCase08_PasswordStrength() {

		// enter password as combination of alphabet+specCharacter+numeric
		setValue("password", "MiroHomeTest@519");

		// get & validate password hit
		String text = getPageText(pwdHintPath);
		Assert.assertEquals("Great password", text);
	}

	@Test
	public void testCase09_PasswordStrength() {

		// enter password as only alphabets
		setValue("password", "MiroHomeTest");

		// get & validate password hit
		String text = getPageText(pwdHintPath);
		Assert.assertEquals("Good password", text);
	}

	@Test
	public void testCase10_PasswordStrength() {

		// enter password as combination of alphabet+numeric
		setValue("password", "Miro1234");

		// get & validate password hit
		String text = getPageText(pwdHintPath);
		Assert.assertEquals("So-so password", text);
	}

	@Test
	public void testCase11_PasswordStrength() {

		// enter password of less than 8 characters
		setValue("password", "Miro@12");

		// get & validate password hit
		String text = getPageText(pwdHintPath);
		Assert.assertEquals("Please use 8+ characters for secure password", text);
	}
	
	@Test
	public void testCase12_MiroTerms() {
		
		//click terms link
		click(linkPath+"a[1]");
		
		//get & validate terms of service
		String text = clickTermsPrivacy(termsPath);
		Assert.assertEquals("Terms of Service", text);
	}
	
	@Test
	public void testCase13_MiroPrivacyPolicy() {
		
		//click privacy policy link
		click(linkPath+"a[2]");
		
		//get & validate term of service
		String text = clickTermsPrivacy(privacyPolicyPath);
		Assert.assertEquals("Privacy Policy", text);
	}
}
