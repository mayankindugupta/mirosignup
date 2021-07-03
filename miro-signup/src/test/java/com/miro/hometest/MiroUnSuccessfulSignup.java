package com.miro.hometest;

/*This test class validates all the 
 * unsuccessful use case to signup
 * createdBy Mayank Gupta*/

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import com.miro.utility.MiroUtility;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MiroUnSuccessfulSignup extends MiroUtility {

	private static String tcName, tcEmail, tcPassword;
	private String miroTermCheckboxPath = "//label[@for='signup-terms']";
	private String miroUpdateCheckboxPath = "//label[@for='signup-subscribe']";
	private String pwdHintPath = "//div[contains(@class,'signup__input-hint-text')]";
	private static final String random = new SimpleDateFormat("ddMMyyHHmmss").format(Calendar.getInstance().getTime());

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

	@Test // click signup button without entering field values
	public void testCase01_UnSuccessfulSignup() {

		// click signup button
		submit();

		// get the error msg
		String text = errorMsg();

		// validate the error msg
		Assert.assertEquals("Please enter your password.", text);
	}

	@Test // click signup button without entering password
	public void testCase02_UnSuccessfulSignup() {

		tcName = "Test Mak" + random;
		tcEmail = "test.mak" + random + "@gmail.com";

		// enter name & email field values only
		setValue("name", tcName);
		setValue("email", tcEmail);
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String text = errorMsg();

		// validate the error msg
		Assert.assertEquals("Please enter your password.", text);
	}

	@Test // click signup button without entering name & email fields value
	public void testCase03_UnSuccessfulSignup() {

		tcPassword = "MiroTest@" + random;

		// enter password field value
		setValue("password", tcPassword);

		// click signup button
		submit();

		// get the error msg
		String text = errorMsg();

		// validate the error msg
		Assert.assertTrue(text.contains("Please enter your name."));
		Assert.assertTrue(text.contains("Please enter your email address."));
		Assert.assertTrue(text.contains("Please agree with the Terms to sign up."));
	}

	@Test // click signup button without entering email
	public void testCase04_UnSuccessfulSignup() {

		// enter name & password field value
		setValue("name", "Test Mak" + random);
		setValue("password", "MiroTest@" + random);

		// click signup button
		submit();

		// get the error msg
		String text = errorMsg();

		// validate the error msg
		Assert.assertTrue(text.contains("Please enter your email address."));
		Assert.assertTrue(text.contains("Please agree with the Terms to sign up."));
	}

	@Test // click signup button without checking miro terms checkbox
	public void testCase05_UnSuccessfulSignup() {

		tcName = "Test Mak" + random;
		tcEmail = "test.mak" + random + "@gmail.com";
		tcPassword = "MiroTest@" + random;

		// enter name, email & password field value
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);

		// click signup button
		submit();

		// get the error msg
		String text = errorMsg();

		// validate the error msg
		Assert.assertTrue(text.contains("Please agree with the Terms to sign up."));
	}

	@Test // click signup button without checking miro terms checkbox, but checking miro updates option
	public void testCase06_UnSuccessfulSignup() {

		tcName = "Test Mak" + random;
		tcEmail = "test.mak" + random + "@gmail.com";
		tcPassword = "MiroTest@" + random;

		// enter name, email & password field value and checking miro update option
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String text = errorMsg();

		// validate the error msg
		Assert.assertTrue(text.contains("Please agree with the Terms to sign up."));
	}

	@Test // set email ID which is already registered
	public void testCase07_UnSuccessfulSignup() {

		tcName = "Test Mak";
		tcEmail = "test.mak@gmail.com";
		tcPassword = "MiroTest@" + random;

		// enter email ID is like @gmail. without com
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("TV");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String errorMsg = errorMsg();

		// validate that user can register only once using the same emailID
		Assert.assertEquals("Sorry, this email is already registered", errorMsg);
	}

	@Test // set password less than 8 character
	public void testCase08_UnSuccessfulSignup() {

		tcName = "Test Mak" + random;
		tcEmail = "test.mak" + random + "@gmail.com";
		tcPassword = "1234567";

		// enter password less than 8 character
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Social Media");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String errorMsg = getPageText(pwdHintPath);

		// validate that password can't be less than 8 characters
		Assert.assertEquals("Please use 8+ characters for secure password", errorMsg);
	}

	@Test // set email domain as @example.com
	public void testCase09_UnSuccessfulSignup() {

		tcName = "Test Mak" + random;
		tcEmail = "test.mak" + random + "@example.com";
		tcPassword = "MiroTest" + random;

		// enter email domain as @example.com
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Blog / Article");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String errorMsg = errorMsg();

		// validate the email domain can't be any domain like example.com
		Assert.assertEquals("This email can not be registered, please try another domain", errorMsg);
	}

	@Test // set email ID as only '@gmail.com'
	public void testCase10_UnSuccessfulSignup() {

		tcName = "Test Mak" + random;
		tcEmail = "@gmail.com";
		tcPassword = "MiroTest" + random;

		// enter email ID as only '@gmail.com'
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Other");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String errorMsg = errorMsg();

		// validate the emailId can't be only '@gmail.com'
		Assert.assertEquals("This doesn’t look like an email address. Please check it for typos and try again.",
				errorMsg);
	}

	@Test // set password having more than 60 characters
	public void testCase11_UnSuccessfulSignup() {

		tcName = "Test Mak" + random;
		tcEmail = "test.mak" + random + "@gmail.com";
		tcPassword = "123456@qwdbmnbvhuplmzghash7890987654321qwertyuiopasdflkjhhgfdzxcvbbnmmlqwokingh@#$%&yhbvcfgsrevsbsa"
				+ random;

		// enter password having more than 60 characters
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Search Engine (Google, Bing)");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String errorMsg = errorMsg();

		// validate the password can't be more than 60 characters
		Assert.assertEquals("Sorry, your password cannot exceed 60 characters", errorMsg);
	}

	@Test // set email & password as same
	public void testCase12_UnSuccessfulSignup() {

		tcName = "1222446940";
		tcEmail = tcName + "@gmail.com";
		tcPassword = tcEmail;

		// enter email & password as same
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Search Engine (Google, Bing)");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String errorMsg = errorMsg();

		// validate that email & password can't be same
		Assert.assertEquals("Sorry, login and password cannot be the same", errorMsg);
	}

	@Test // set name & password as same
	public void testCase13_UnSuccessfulSignup() {

		tcName = "MiroUser" + random;
		tcEmail = tcName + "@gmail.com";
		tcPassword = tcName;

		// enter name & password as same
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("In the mail");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String errorMsg = errorMsg();

		// validate the name & password can't be same
		Assert.assertEquals("Sorry, name and password cannot be the same.", errorMsg);
	}

	@Test // set email domain as gmail.mak
	public void testCase14_UnSuccessfulSignup() {

		tcName = "Test Mak" + random;
		tcEmail = "test.mak" + random + "@gmail.mak";
		tcPassword = "MiroTest" + random;

		// enter email domain as gmail.mak
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Search Engine (Google, Bing)");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String errorMsg = errorMsg();

		// validate that email domain as gmail.mak is invalid for miro signup
		Assert.assertEquals("This doesn’t look like an email address. Please check it for typos and try again.",
				errorMsg);
	}

	@Test // set email name has blank space
	public void testCase15_UnSuccessfulSignup() {

		tcName = "Test Mak" + random;
		tcEmail = "Test"+"    "+ random + "Mak@gmail.com";
		tcPassword = "MiroTest" + random;

		// enter emailID having blank space
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Search Engine (Google, Bing)");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String errorMsg = errorMsg();

		// validate that email name having blank space is invalid for miro signup
		Assert.assertEquals("This doesn’t look like an email address. Please check it for typos and try again.",
				errorMsg);
	}

	@Test // set email ID has @ in its before domain itself
	public void testCase16_UnSuccessfulSignup() {

		tcName = "Test Mak" + random;
		tcEmail = "Miro@user@gmail.com";
		tcPassword = "MiroTest@" + random;

		// enter email ID has @ in its before domain itself
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("TV");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String errorMsg = errorMsg();

		// validate that email ID has @ in its before domain itself is invalid for miro
		// signup
		Assert.assertEquals("This doesn’t look like an email address. Please check it for typos and try again.",
				errorMsg);
	}

	@Test // set email ID is like @gmail. without com
	public void testCase17_UnSuccessfulSignup() {

		tcName = "Test Mak" + random;
		tcEmail = random + "miro@gmail.";
		tcPassword = "MiroTest@" + random;

		// enter email ID is like @gmail. without com
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("TV");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String errorMsg = errorMsg();

		// validate that given format of email ID is invalid for miro signup
		Assert.assertEquals("This doesn’t look like an email address. Please check it for typos and try again.",
				errorMsg);
	}

	@Test // set name is sequence of blank spaces
	public void testCase18_UnSuccessfulSignup() {

		tcName = "       ";
		tcEmail = "test.mak" + random + "@gmail.com";
		tcPassword = "MiroTest@" + random;

		// enter name is sequence of blank spaces
		setValue("name", tcName);
		setValue("email", tcEmail);
		setValue("password", tcPassword);
		selectDropdown("Podcast");
		click(miroTermCheckboxPath);
		click(miroUpdateCheckboxPath);

		// click signup button
		submit();

		// get the error msg
		String errorMsg = errorMsg();

		// validate the name can't be blank spaces
		Assert.assertEquals("Please enter your name.", errorMsg);
	}
}
