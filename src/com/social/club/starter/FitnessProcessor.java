package com.social.club.starter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.social.club.web.Fitness;

public class FitnessProcessor {
	private Fitness fitness;
	
	public boolean isToday() {
		Calendar calendar = Calendar.getInstance();
		return true;
	}
	
	
	public boolean navigateToOrderPage() {
		fitness = new Fitness();
		return fitness.navigateToOrderPage();
	}
	
	public void checkSpecificDay(List<String> days) {
		List<WebElement> checkboxDivList = fitness.getCheckboxDivList();
		for (WebElement e : checkboxDivList) {
			if (days.contains(e.findElement(By.tagName("label")).getText())) {
				e.findElement(By.tagName("input")).click();
			}
		}
	}
	
	public void inputUserName(String userName) {
		WebElement userNameInput = fitness.getUserName();
		userNameInput.sendKeys("");
		userNameInput.sendKeys(userName);
	}
	
	public WebElement clickToGetCapcha() {
		fitness.getCaptchaLabel().click();
		return fitness.getCaptcha();
	}
	
	public void submit() {
		fitness.getSubmitButton().click();
	}


	public void fillInRecognizedCaptcha(WebElement captcha) {
		WebElement captchaInput = fitness.getCaptchaInput();
		// TODO recognize captcha
		
		captchaInput.sendKeys("aaaa");
	}


	public void setNotice() throws IOException {
		fitness.getBrowser().findElement(arg0)
	}
}
