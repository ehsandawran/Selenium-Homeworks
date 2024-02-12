package com.noorteck.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class Exercise1 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://ntkhr.noortecktraining.com/web/index.php/auth/login");
		Thread.sleep(2000);

		WebElement userNameField = driver.findElement(By.name("username"));
		userNameField.click();
		userNameField.sendKeys("ntk-admin");
		Thread.sleep(2000);

		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.click();
		passwordField.sendKeys("Ntk-orange!admin.123");
		Thread.sleep(2000);

		WebElement logInButton = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		logInButton.click();
		Thread.sleep(2000);

		WebElement getHeader = driver.findElement(By.linkText("Dashboard"));
		String header = getHeader.getText();
		System.out.println("Header " + header);

		tearDown();
	}

}
