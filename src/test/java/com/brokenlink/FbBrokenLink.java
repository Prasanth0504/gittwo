package com.brokenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbBrokenLink {

	
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		
		List<WebElement> link = driver.findElements(By.tagName("a"));
		int brokencounts=0;
		System.out.println(link.size());
		for (int i = 0; i <link.size(); i++) {
			
			String attribute = link.get(i).getAttribute("href");
			System.out.println(attribute);
		
		if (attribute!=null) {
			
			URL url = new URL(attribute);
			URLConnection openConnection = url.openConnection();
			HttpURLConnection httpsconnection = (HttpURLConnection) openConnection;
			int responseCode = httpsconnection.getResponseCode();
		
			if (responseCode>=400) {
				System.out.println("BrokenLink:" +attribute);
				brokencounts =brokencounts++;
			}
		}
		
			
		}System.out.println(brokencounts);
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
