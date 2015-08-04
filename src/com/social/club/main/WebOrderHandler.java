package com.social.club.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.social.club.starter.FitnessProcessor;

public class WebOrderHandler {
	private static List<String> days = Arrays.asList(new String[]{
			"周一（中午）", 
			"周三（中午）", 
			"周五（中午）"
	});
	private static String userName = "baron.chu@oracle.com";
	
	public static void main(String[] args) throws IOException {
		boolean flag = true;
		int i = 0;
		while (flag) {
			FitnessProcessor processor = new FitnessProcessor();
			if (processor.navigateToOrderPage()) {
				processor.checkSpecificDay(days);
				processor.inputUserName(userName);
				processor.setNotice();
				WebElement captcha = processor.clickToGetCapcha();
				processor.fillInRecognizedCaptcha(captcha);
				processor.submit();
				i++;
			} else {
				flag = false;
			}
			System.out.println("visit count: " + i);
		
		}
	}
}
