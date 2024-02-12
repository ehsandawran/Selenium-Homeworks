package com.noorteck.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Hooks;

public class Exercise2 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://demo.guru99.com/test/newtours/");
		Thread.sleep(2000);

		WebElement registerLink = driver.findElement(By.linkText("REGISTER"));
		registerLink.click();
		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		WebElement firstNameField = driver.findElement(By.name("firstName"));
		firstNameField.click();
		firstNameField.sendKeys("Jerry");
		Thread.sleep(2000);

		WebElement lastNameField = driver.findElement(By.name("lastName"));
		lastNameField.click();
		lastNameField.sendKeys("Jaggard");
		Thread.sleep(2000);

		WebElement phoneNumberField = driver.findElement(By.name("phone"));
		phoneNumberField.click();
		phoneNumberField.sendKeys("8652217616");
		Thread.sleep(2000);

		WebElement emailField = driver.findElement(By.id("userName"));
		emailField.click();
		emailField.sendKeys("idawran@hotmail.com");
		Thread.sleep(2000);

		WebElement addressField = driver.findElement(By.name("address1"));
		addressField.click();
		addressField.sendKeys("123 Main St.");
		Thread.sleep(2000);

		WebElement cityField = driver.findElement(By.name("city"));
		cityField.click();
		cityField.sendKeys("Knoxville");
		Thread.sleep(2000);

		WebElement stateField = driver.findElement(By.name("state"));
		stateField.click();
		stateField.sendKeys("TN");
		Thread.sleep(2000);

		WebElement zipcodeField = driver.findElement(By.name("postalCode"));
		zipcodeField.click();
		zipcodeField.sendKeys("37917");
		Thread.sleep(2000);

		WebElement selectCountry = driver.findElement(By.name("country"));
		Select selectObj = new Select(selectCountry);
		selectObj.selectByValue("UNITED STATES");

		WebElement userNameField = driver.findElement(By.id("email"));
		userNameField.click();
		userNameField.sendKeys("idawran@hotmail.com");
		Thread.sleep(2000);

		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.click();
		passwordField.sendKeys("ABC-xyz123");
		Thread.sleep(2000);

		WebElement confirmPasswordField = driver.findElement(By.name("confirmPassword"));
		confirmPasswordField.click();
		confirmPasswordField.sendKeys("ABC-xyz123");
		Thread.sleep(2000);

		WebElement submitButton = driver.findElement(By.name("submit"));
		submitButton.click();
		Thread.sleep(2000);

		WebElement confirmationMessage = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/text()[1]"));
		String message = confirmationMessage.getText();
		if (message.contains("Thank you for registering")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		tearDown();
	}

}
