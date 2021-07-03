# mirosignup
*Project Name: miro-signup*
1. This Test Project has been created using the tools & technologies like Selenium, Java, Maven & Junit.
2. Under the Project, There are three separate test classes and one test utility class.
3. All these four classes are placed under src/test/java location.
4. Test utility class named as MiroUtility.java which is having all the wrappers  methods I created to be used by test classes.
5. Other three test classes named:
   1. MiroSignUpPageFields.java : This test class validates all the UI elements on Miro Signup page.
   2. MiroSuccessfulSignup.java :This test class validates all the successful end to end use cases to signup into Miro. These are the positive test cases for test project.
   3. MiroUnSuccessfulSignup.java : This test class validates all the unsuccessful use cases to signup. These are the negative test cases for test project.
6. Selenium Webdriver version 3.141 is used to automate all the UI part.
7. Java is used to write test scripts to automated these end to end test cases.
8. Maven is used manage all the dependencies and build the test project.
9. Junit framework version 4.11 is used to execute the test cases in a systematic manner.
10. Each Test method denotes a test cases covering a specific test scenario.

*Utility Class: MiroUtility.java*
1. This class has different-different methods which are used by other three test classes to automate their respective test scenario.
2. Methods:
   01. openDriver()             : This method creates an object of Chrome webdriver at runtime with specific pre-defined settings.
   02. navigateToMiro()         : This method hit url "https://miro.com/signup/" on opened browser and close unwanted pop-ups.
   03. getPageText()            : This method takes web locator path & returns a string attached to locator.
   04. getPageElementByID()     : This method takes web locator path as ID & returns attached web element.
   05. getPageElementByClass()  : This method takes web locator path as CLASS & returns attached web element.
   06. getPageElementByXpath()  : This method takes web locator path as XPATH & returns attached web element.
   07. getElementAttribute()    : This method takes web locator path & returns attribute 'data-auth';
   08. submit()                 : This method takes web location of 'Get started now' button and then clicks it.
   09. click()                  : This method takes web location of any clickable element and then clicks it.
   10. setValue()               : This method takes web locator path & input value & set the value into text field.
   11. errorMsg()               : This method takes web location of error message & returns error message text as string.
   12. selectDropdown()         : This method takes any value under dropdown 'How did you hear about Miro?' & set it on form.
   13. checkYourEmail()         : This method takes web locator path from “Check your email” screen and returns confirmation with “Check your email” as String text.
   14. getRegisteredEmail()     : This method takes web locator path from “Check your email” screen and returns registered emailId from the same screen.
   15. clickTermsPrivacy()      : This method takes web locator path and click the hyderlinks & then switch to other window and read headline from the window.
   16. quitDriver()             : This methods quits the web driver object.

3. Private methods: These methods are private methods used by utility methods internally.
   01. waitForElementVisible()  : This is a private method used to wait for a specific web element to visible on signup form page DOM.
   02. waitUntilDOMReady()      : This is a private method used to wait for DOM to be in ready state.
   03. switchWindow()           : This is a private method used to switch between more than one open windows

*Test Class: MiroSignUpPageFields.java*
1. It has total 13 test cases validating the presence of each UI element on signup page.
2. Test Cases are:
    01. testCase01_MiroTitle              :  validating the presence of miro title of signup page.
    02. testCase02_MiroHeader             :  validate the the miro signup page header of singup page.
    03. testCase03_NameWorkPasswordFields :  validate the name, email & password fields on signup page
    04. testCase04_DropdownField          :  validate the dropdown field (How did you hear about Miro?) from signup page.
    05. testCase05_CheckboxFields         :  validate the checkbox fields from signup page.
    06. testCase06_SignUpButton           :  validate the signUp button (Get started now) on signup page.
    07. testCase07_OtherSignupOptions     :  validate the other available signup options like google, slack, office, fb, apple on signup page.
    08. testCase08_PasswordStrength       :  validate the password as combination of alphabet+specCharacter+numeric.
    09. testCase09_PasswordStrength       :  validate the password as only alphabets.
    10. testCase10_PasswordStrength       :  validate the password as combination of alphabet+numeric.
    11. testCase11_PasswordStrength       :  validate the password of less than 8 characters.
    12. testCase12_MiroTerms              :  validate the miro's terms of service link.
    13. testCase13_MiroPrivacyPolicy      :  validate the miro's privacy policy link.

*Test Class: MiroSuccessfulSignup.java*
1. It has total 14 test cases validating the positive scenarios to signup into miro's account. These are scenario's which are permitting user to register into Miro.
2. Test Cases are:
    01. testCase01_SuccessfulSignup: validate the successful signup on miro when valid values for name, email, password, checkbox are given. BUT No value for 'how did u hear' from dropdown.
    02. testCase02_SuccessfulSignup: validate the successful signup on miro when valid values for name, email, password, checkbox, & 'how did u hear' are given.
    03. testCase03_SuccessfulSignup: validate the successful signup on miro when name field value is set with leading & trailing spaces
    04. testCase04_SuccessfulSignup: validate the successful signup on miro when email domain is given as @miro.com'.
    05. testCase05_SuccessfulSignup: validate the successful signup on miro when email domain is given as @hotmail.com & only alphabetic password.
    06. testCase06_SuccessfulSignup: validate the successful signup on miro when email domain is given as @microsoft.com & only numeric password
    07. testCase07_SuccessfulSignup: validate the successful signup on miro when email domain is given as @mail.com & only special Characters password
    08. testCase08_SuccessfulSignup: validate the successful signup on miro when name, email & password field values are given as numeric value
    09. testCase09_SuccessfulSignup: validate the successful signup on miro when miro news & updates checkbox is not selected.
    10. testCase10_SuccessfulSignup: validate the successful signup on miro when name is given as single character.
    11. testCase11_SuccessfulSignup: validate the successful signup on miro when email domain is given as @gmail.co.in
    12. testCase12_SuccessfulSignup: validate the successful signup on miro when email domain is given as @google.uk
    13. testCase13_SuccessfulSignup: validate the successful signup on miro when email domain is given as some organisation domain like @accenture.com
    14. testCase14_SuccessfulSignup: validate the successful signup on miro when password with given as string having blank spaces inbetween.

*Test Class: MiroUnSuccessfulSignup.java*
1. It has total 18 test cases validating the negative scenarios for miro's signup feature. These are scenario's which are not permitting user to register into Miro.
2. Test Cases are:
    01. testCase01_UnSuccessfulSignup: validate that the user should not be registered when all fields on signup form left vacant.
    02. testCase02_UnSuccessfulSignup: validate that the user should not be registered when password field on signup form left vacant.
    03. testCase03_UnSuccessfulSignup: validate that the user should not be registered when name and email fields on signup form left vacant.
    04. testCase04_UnSuccessfulSignup: validate that the user should not be registered when email field on signup form left vacant.
    05. testCase05_UnSuccessfulSignup: validate that the user should not be registered when Miro's terms checkbox is left unselected
    06. testCase06_UnSuccessfulSignup: validate that the user should not be registered when Miro's news & updates checkbox is selected but Miro's terms checkbox is left unselected.
    07. testCase07_UnSuccessfulSignup: validate that the user should not be registered again when given emailID is already registered.
    08. testCase08_UnSuccessfulSignup: validate that the user should not be registered when password given is less than 8 character.
    09. testCase09_UnSuccessfulSignup: validate that the user should not be registered when email domain is given as @example.com.
    10. testCase10_UnSuccessfulSignup: validate that the user should not be registered when emailID is given as only '@gmail.com'.
    11. testCase11_UnSuccessfulSignup: validate that the user should not be registered when password given is more than 60 characters.
    12. testCase12_UnSuccessfulSignup: validate that the user should not be registered when emailID & password given are same.
    13. testCase13_UnSuccessfulSignup: validate that the user should not be registered when name & password given are same.
    14. testCase14_UnSuccessfulSignup: validate that the user should not be registered when an invalid email domain is given as @gmail.mak
    15. testCase15_UnSuccessfulSignup: validate that the user should not be registered when emailId has blank spaces in inbetween.
    16. testCase16_UnSuccessfulSignup: validate that the user should not be registered when emailID has @ before domain itself.
    17. testCase17_UnSuccessfulSignup: validate that the user should not be registered when emailID is like @gmail. without com.
    18. testCase18_UnSuccessfulSignup: validate that the user should not be registered when name field value is sequence of blank spaces.

Project's *pom.xml*
  <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  	<modelVersion>4.0.0</modelVersion>
  	<groupId>com.miro.hometest</groupId>
  	<artifactId>miro-signup</artifactId>
  	<version>1.0-SNAPSHOT</version>
  	<name>miro-signup</name>
  	<url>http://maven.apache.org</url>
  	<dependencies>
  		<dependency>
  			<groupId>junit</groupId>
  			<artifactId>junit</artifactId>
  			<version>4.11</version>
  			<scope>test</scope>
  		</dependency>
  		<dependency>
  			<groupId>org.seleniumhq.selenium</groupId>
  			<artifactId>selenium-java</artifactId>
  			<version>3.141.59</version>
  		</dependency>
  		<dependency>
  			<groupId>io.github.bonigarcia</groupId>
  			<artifactId>webdrivermanager</artifactId>
  			<version>4.4.3</version>
  			<scope>test</scope>
  		</dependency>
  	</dependencies>
  </project>
