package com.social.club.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Fitness {
	public static String WEB_URL = "http://www.sojump.com/jq/3325408.aspx";
	private static WebDriver page = null;
	private WebElement pageTitle;
	private List<WebElement> checkboxDivList;
	
	private static String PAGE_TITLE_XPATH = ".//*[contains(@class, 'survey')]/div/h1/span[1]";
	
	private static String DATE_CHECK_BOX_DIV_XPATH = ".//*[@id='divquestion1']//*[contains(@class, 'ulradiocheck')]/li[1]/div[1]";
	
	public boolean navigateToOrderPage() {
		if (page == null) {
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("network.proxy.type", "2");
			profile.setPreference("network.proxy.autoconfig_url", "http://wpad/wpad.dat");
			page = new FirefoxDriver(profile);
			page.get(WEB_URL);
		} else {
			page.navigate().refresh();
		}
		try {
			if (getPageTitle() == null) {
				return false;
			}
		} catch (Exception e) {
			page.close();
			throw e;
		}
		return true;
	}
	
	public String getPageTitle() {
		pageTitle = page.findElement(By.xpath(PAGE_TITLE_XPATH));
		return pageTitle.getText();
	}
	
	public List<WebElement> getCheckboxDivList() {
		checkboxDivList = page.findElements(By.xpath(DATE_CHECK_BOX_DIV_XPATH));
		return checkboxDivList;
	}
	
	public WebElement getUserName() {
		return page.findElement(By.id("q2"));
	}
	
	public WebElement getCaptchaLabel() {
		return page.findElement(By.id("yucinput"));
	}
	
	public WebElement getCaptchaInput() {
		return page.findElement(By.id("yucinput"));
	}
	
	public WebElement getCaptcha() {
		return page.findElement(By.id(".//*[@id='divCaptcha']/img"));
	}
	
	public WebElement getSubmitButton() {
		return page.findElement(By.id("submit_button"));
	}
	
	public WebDriver getBrowser() {
		return this.page;
	}
}
