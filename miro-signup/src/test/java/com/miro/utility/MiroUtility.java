package com.miro.utility;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MiroUtility {

	WebDriver driver = null;

	public void openDriver() {
		WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
	}

	public void navigateToMiro() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://miro.com/signup/");
		if (driver.findElement(By.id("onetrust-accept-btn-handler")).isDisplayed()) {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		}
		driver.navigate().refresh();
		waitUntilDOMReady(30);
	}

	public String getPageText(String path) {
		waitForElementVisible(By.xpath(path), 30);
		return driver.findElement(By.xpath(path)).getText();
	}

	public WebElement getPageElementByID(String path) {
		waitForElementVisible(By.id(path), 30);
		return driver.findElement(By.id(path));
	}

	public WebElement getPageElementByClass(String path) {
		waitForElementVisible(By.className(path), 30);
		return driver.findElement(By.className(path));
	}

	public WebElement getPageElementByXpath(String path) {
		waitForElementVisible(By.xpath(path), 30);
		return driver.findElement(By.xpath(path));
	}

	public String getElementAttribute(String path) {
		waitForElementVisible(By.id(path), 30);
		return driver.findElement(By.id(path)).getAttribute("data-auth");
	}

	public void submit() {
		waitForElementVisible(By.className("signup__submit"), 30);
		driver.findElement(By.className("signup__submit")).click();
	}

	public void click(String path) {
		waitForElementVisible(By.xpath(path), 30);
		driver.findElement(By.xpath(path)).click();
	}

	public void setValue(String path, String value) {
		waitForElementVisible(By.id(path), 30);
		driver.findElement(By.id(path)).sendKeys(value);
	}

	public String errorMsg() {
		waitForElementVisible(By.xpath("//div[contains(@class,'signup__error')]"), 30);
		return driver.findElement(By.xpath("//div[contains(@class,'signup__error')]")).getText();
	}

	public void selectDropdown(String dropdownOption) {
		String dropdownPath = "//div[@class='speero-dropdown__popup']/a[contains(text(),'" + dropdownOption + "')]";
		if (driver.findElements(By.className("speero-dropdown__title")).size() == 0)
			driver.navigate().refresh();
		waitUntilDOMReady(30);
		waitForElementVisible(By.className("speero-dropdown__title"), 30);
		driver.findElement(By.className("speero-dropdown__title")).click();
		waitForElementVisible(By.xpath(dropdownPath), 30);
		driver.findElement(By.xpath(dropdownPath)).click();
	}

	public String checkYourEmail() {
		waitForElementVisible(By.xpath("//h1[@class='signup__title-form']"), 30);
		return driver.findElement(By.xpath("//h1[@class='signup__title-form']")).getText();
	}

	public String getRegisteredEmail() {
		waitForElementVisible(By.xpath("//div[@class='signup__subtitle-form']/strong[1]"), 30);
		return driver.findElement(By.xpath("//div[@class='signup__subtitle-form']/strong[1]")).getText();
	}

	public String clickTermsPrivacy(String path) {

		switchWindow();
		waitForElementVisible(By.xpath(path), 30);
		return driver.findElement(By.xpath(path)).getText();
	}

	public void quitDriver() {
		driver.quit();
	}

	private void waitForElementVisible(By locator, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	private void waitUntilDOMReady(int timeoutInSeconds) {
		try {
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	private void switchWindow() {
		Set<String> windowSet = driver.getWindowHandles();
		String[] windowArray = new String[windowSet.size()];
		windowSet.toArray(windowArray);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.switchTo().window(windowArray[1]);
	}
}
