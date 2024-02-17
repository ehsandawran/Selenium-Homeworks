package com.noorteck.selenium.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class Exercise7 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-\n" + "summary.html");

		Thread.sleep(2000);

		WebElement seleniumPackage = driver.findElement(By.linkText("org.openqa.selenium"));
		seleniumPackage.click();

		Thread.sleep(2000);

		WebElement alert = driver.findElement(By.linkText("Alert"));
		alert.click();

		Thread.sleep(2000);

		WebElement textMessage = driver.findElement(By.xpath("//h1[@class='title']"));
		String message = textMessage.getText();
		if (message.equals("Interface Alert")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();

		Thread.sleep(2000);

		WebElement chromePackage = driver.findElement(By.linkText("org.openqa.selenium.chrome"));
		chromePackage.click();

		Thread.sleep(1000);

		WebElement chromeDriver = driver.findElement(By.linkText("ChromeDriver"));
		chromeDriver.click();

		Thread.sleep(1000);

		WebElement message2 = driver.findElement(By.xpath("//h1[@class='title']"));
		String text2 = message2.getText();
		if (text2.equals("Class ChromeDriver")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		tearDown();
	}

}
