package com.noorteck.selenium.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class Exercise6 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://demo.automationtesting.in/Alerts.html");

		String title = driver.getTitle();
		System.out.println("Title" + title);

		WebElement alertWithTextbox = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a"));
		alertWithTextbox.click();
		Thread.sleep(1000);

		WebElement clickTheButton = driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button"));
		clickTheButton.click();
		Thread.sleep(1000);

		Alert alertObj = driver.switchTo().alert();
		alertObj.sendKeys("Randy");
		alertObj.accept();
		Thread.sleep(1000);

		WebElement prompt = driver.findElement(By.id("demo1"));
		String promptText = prompt.getText();
		System.out.println(promptText);
		Thread.sleep(1000);

		driver.navigate().refresh();

		WebElement alertWithOk = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a"));
		alertWithOk.click();
		Thread.sleep(1000);

		WebElement alertButton2 = driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button"));
		alertButton2.click();
		Thread.sleep(1000);

		Alert alertObj2 = driver.switchTo().alert();
		alertObj2.dismiss();
		Thread.sleep(1000);

		WebElement alertWithOkandCancel = driver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a"));
		alertWithOkandCancel.click();
		Thread.sleep(1000);

		WebElement clickTheButtonToDisplay = driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button"));
		clickTheButtonToDisplay.click();
		Thread.sleep(1000);

		Alert alertObj3 = driver.switchTo().alert();
		String alertText = alertObj3.getText();
		if (alertText.contains("Press a Button")) {
			alertObj3.dismiss();
		} else {
			alertObj3.accept();
		}

		Thread.sleep(1000);

		WebElement message = driver.findElement(By.id("demo"));
		String messageText = message.getText();
		System.out.println(messageText);

		tearDown();
		
		// Homework complete...

	}

}
