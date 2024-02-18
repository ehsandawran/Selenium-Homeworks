package com.noorteck.selenium.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class Exercise8 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://demo.automationtesting.in/Frames.html");

		WebElement frame = driver.findElement(By.id("singleframe"));

		driver.switchTo().frame(frame);

		WebElement textField1 = driver.findElement(By.xpath("//input[@type='text']"));
		textField1.sendKeys("Accessing Iframe");

		driver.switchTo().defaultContent();

		WebElement inceptionIframe = driver.findElement(By.xpath("//a[@href='#Multiple']"));
		inceptionIframe.click();

		WebElement nestedIframe = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));

		driver.switchTo().frame(nestedIframe);

		WebElement iframeDemo = driver
				.findElement(By.cssSelector("iframe[style$='float: left;height: 250px;width: 400px']"));
		driver.switchTo().frame(iframeDemo);

		WebElement textField2 = driver.findElement(By.xpath("//input[@type='text']"));
		textField2.sendKeys("Iframe is easy");

		driver.switchTo().defaultContent();

		WebElement home = driver.findElement(By.linkText("Home"));
		home.click();

		String title = driver.getTitle();
		if (title.equals("Index")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		tearDown();
	}

}
