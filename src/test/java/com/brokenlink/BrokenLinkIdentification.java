package com.brokenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkIdentification {

	public static void main(String[] args) throws IOException{
	
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));		
		
		System.out.println(Links.size());
		
		for (int i = 0; i < Links.size(); i++) {
			
			String attribute = Links.get(i).getAttribute("href");
			
			System.out.println(attribute);
			
		}
		int brokenlistcount = 0;
for (int i = 0; i < Links.size(); i++) {
			
			String attribute = Links.get(i).getAttribute("href");
		
			if (attribute!=null) {
				
			URL url = new URL(attribute);
			
			URLConnection openConnection = url.openConnection();	
			HttpURLConnection connection = (HttpURLConnection) openConnection;
			int responseCode = connection.getResponseCode();
			
			if (responseCode>=400) {
				
				System.out.println("broken Links:"+attribute);
				brokenlistcount++;
				
		
			
			}
			}
			System.out.println("Brokenlink Count:"+brokenlistcount);
			
			
		}
		
		
		
		
		
	}
	
}
