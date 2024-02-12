package com.noorteck.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Hooks;

public class Exercise3 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://demo.nopcommerce.com/");

		WebElement registerLink = driver.findElement(By.linkText("Register"));
		registerLink.click();
		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		WebElement genderRadio = driver.findElement(By.id("gender-male"));
		genderRadio.click();
		Thread.sleep(2000);

		WebElement firstNameField = driver.findElement(By.id("FirstName"));
		firstNameField.click();
		firstNameField.sendKeys("Randy");
		Thread.sleep(2000);

		WebElement lastNameField = driver.findElement(By.id("LastName"));
		lastNameField.click();
		lastNameField.sendKeys("Orton");
		Thread.sleep(2000);

		WebElement dobDay = driver.findElement(By.name("DateOfBirthDay"));
		Select selectDay = new Select(dobDay);
		selectDay.selectByValue("2");
		Thread.sleep(2000);

		WebElement dobMonth = driver.findElement(By.name("DateOfBirthMonth"));
		Select selectMonth = new Select(dobMonth);
		selectMonth.selectByValue("6");
		Thread.sleep(2000);

		WebElement dobYear = driver.findElement(By.name("DateOfBirthYear"));
		Select selectYear = new Select(dobYear);
		selectYear.selectByValue("1999");
		Thread.sleep(2000);

		WebElement emailField = driver.findElement(By.id("Email"));
		emailField.click();
		emailField.sendKeys("idawran@hotmail.com");
		Thread.sleep(2000);

		WebElement companyNameField = driver.findElement(By.id("Company"));
		companyNameField.click();
		companyNameField.sendKeys("WWE");
		Thread.sleep(2000);

		WebElement newsLetterCheck = driver.findElement(By.id("Newsletter"));
		newsLetterCheck.click();
		Thread.sleep(2000);

		WebElement passwordField = driver.findElement(By.id("Password"));
		passwordField.click();
		passwordField.sendKeys("ABCxyz-123");
		Thread.sleep(2000);

		WebElement confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
		confirmPasswordField.click();
		confirmPasswordField.sendKeys("ABCxyz-123");
		Thread.sleep(2000);

		WebElement registerButton = driver.findElement(By.id("register-button"));
		registerButton.click();
		Thread.sleep(2000);

		WebElement message = driver.findElement(By.className("result"));
		String messageStr = message.getText();
		if (messageStr.contains("Your registration completed")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		tearDown();

	}

}
