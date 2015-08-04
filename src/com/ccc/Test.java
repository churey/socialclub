package com.ccc;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		
//		driver.get("http://alpha-colab.acg.autodesk.com/collaboration/jsapi/v1");
		
//		driver.executeScript(script, args);
		
//		JavaScriptExecutor a 
		
		String url = "http://alpha-colab.acg.autodesk.com/collaboration/jsapi/v1";
		
		String IncludeYUI = "script = document.createElement('script');script.type = 'text/javascript';script.async = true;script.onload = function(){};script.src = '"
                + url
                + "';document.getElementsByTagName('head')[0].appendChild(script);";
        driver.executeScript(IncludeYUI);
		
        String cmd = "var successFunc  = function(){adsk.collaboration.SharedDoc.init({'someid':'someidvalue', 'someproperty':'somevalue', 'property2':{'nestedproperty':12}});};" 
        			+ "var errorHandler = function(){alert('error')};"
        			+ " adsk.collaboration.SharedDoc.openAndSubscribe('generic', 'slpal3b2ic7h2311a21k', {'origin' : 'http://alpha-colab.acg.autodesk.com/channel', 'appsession':'abc31231'},successFunc, errorHandler)";
        Object o = driver.executeScript("adsk.collaboration.SharedDoc.openAndSubscribe", "generic", "slpal3b2ic7h2311a21k");
        System.out.println(o.toString());
	}
}
