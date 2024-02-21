package com.noorteck.selenium.day4;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Hooks;

public class Exercise10 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://testautomationpractice.blogspot.com/");

		Thread.sleep(2000);

		String parentWindow = driver.getWindowHandle();

		WebElement searchField = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
		WebElement searchIcon = driver.findElement(By.cssSelector(".wikipedia-search-button"));

		searchField.sendKeys("selenium (software)");

		searchIcon.click();

		Thread.sleep(2000);

		driver.findElement(By.linkText("Selenium (software)")).click();
		Thread.sleep(1000);
		driver.switchTo().window(parentWindow);

		Thread.sleep(1000);
		searchField.clear();
		searchField.sendKeys("eBay");
		Thread.sleep(1000);

		searchIcon.click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("EBay")).click();
		Thread.sleep(1000);
		driver.switchTo().window(parentWindow);
		Thread.sleep(1000);
		searchField.clear();
		Thread.sleep(1000);
		searchField.sendKeys("Target Corporation");
		searchIcon.click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("Target Corporation")).click();
		driver.switchTo().window(parentWindow);
		Thread.sleep(1000);
		searchField.clear();
		searchField.sendKeys("Google");

		searchIcon.click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("Google")).click();
		searchIcon.click();
		Thread.sleep(1000);

		driver.switchTo().window(parentWindow);
		Thread.sleep(1000);
		searchField.clear();
		Thread.sleep(1000);
		searchField.sendKeys("Yahoo!");

		searchIcon.click();
		Thread.sleep(1000);
		WebElement yahooLink = driver.findElement(By.linkText("Yahoo!"));
		yahooLink.click();
		Thread.sleep(1000);

		driver.switchTo().window(parentWindow);

		Thread.sleep(1000);

		Set<String> allWindows = driver.getWindowHandles();

		System.out.println("Window IDs: " + allWindows);

		for (String window : allWindows) {

			System.out.println("Window ID: " + window);

			driver.switchTo().window(window);

			Thread.sleep(1000);

			String currentPageTitle = driver.getTitle();

			if (currentPageTitle.equals("Selenium (software) - Wikipedia")) {

				System.out.println(currentPageTitle);

				driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[2]/tbody/tr[11]/td/span[1]/a"))
						.click();

				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[3]/a/span")).click();

				Thread.sleep(1000);

				String tsbap = driver.findElement(By.xpath("/html/body/div/div[1]/div/main/div/h1")).getText();

				if (tsbap.contains("The Selenium Browser Automation Project")) {
					System.out.println("Wooow, once I am done here I will read all the\n" + "available documents.");
				} else {
					System.out.println("I am still going to read all the available\n" + "documents.");
				}

				driver.close();

			} else if (currentPageTitle.equals("eBay - Wikipedia")) {

				driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[20]/td/span[1]/a"))
						.click();

				Thread.sleep(1000);

				WebElement allCategories = driver.findElement(By.xpath("//*[@id=\"gh-cat\"]"));

				Select selectObj = new Select(allCategories);

				List<WebElement> categoryList = selectObj.getOptions();

				int countN = 0;

				for (WebElement category : categoryList) {

					String categoryName = category.getText();

					if (categoryName.contains("&")) {
						countN++;
						System.out.println(categoryName);
					}

				}
				System.out.println("Number of values containg &: " + countN);

				if (countN > 6) {
					System.out.println("TESTCAE PASSED");
				} else {
					System.out.println("TESTCASE FAILED");
				}

				driver.close();
			} else if (currentPageTitle.equals("Target Corporation - Wikipedia")) {

				driver.findElement(By.linkText("target.com")).click();

				String title2 = driver.getTitle();
				System.out.println(title2);

				List<WebElement> links = driver.findElements(By.xpath("//a"));

				int containsStatic = 0;

				for (WebElement link : links) {

					String linkText = link.getAttribute("href");

					System.out.println(linkText);

					if (linkText.contains("static")) {

						containsStatic++;
					}

				}

				System.out.println("Number of links that contains 'static' : " + containsStatic);
				if (containsStatic > 50) {
					System.out.println("TESTCASE PASSED");
				} else {
					System.out.println("TESTCASE FAILED");
				}

				driver.close();

			} else if (currentPageTitle.equals("Google - Wikipedia")) {

				driver.findElement(By.xpath("//tr//a[contains(@href, 'https://about.google/')]")).click();

				Thread.sleep(1000);

			}

		}

		tearDown();
	}

}
