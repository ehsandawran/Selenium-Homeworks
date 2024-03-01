package com.noorteck.selenium.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.Hooks;

public class Exercise11 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		rightClick();

		tearDown();

	}

	public static void rightClick() throws InterruptedException {

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		Thread.sleep(2000);

		WebElement rightClick = driver.findElement(By.cssSelector(".context-menu-one.btn.btn-neutral"));

		Actions actions = new Actions(driver);

		actions.contextClick(rightClick).build().perform();

		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();

		String alertStr = driver.switchTo().alert().getText();

		System.out.println(alertStr);

		if (alertStr.contains("copy")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

	}

}
