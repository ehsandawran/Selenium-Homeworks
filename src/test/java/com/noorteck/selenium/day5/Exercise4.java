package com.noorteck.selenium.day5;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Hooks;

public class Exercise4 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://www.dummyticket.com/");

		Thread.sleep(5000);

		driver.findElement(By.xpath(
				"//a[contains(@class,'btn-w-auto fg-text-light ffb-button1-1')]//span[contains(@class,'btn-text')][normalize-space()='BUY TICKET']"))
				.click();

		System.out.println(driver.getTitle());

		driver.findElement(By.cssSelector("input#product_3186")).click();

		Thread.sleep(5000);

		String message = driver.findElement(By.cssSelector("div.woocommerce-message")).getText();
		System.out.println(message);

		driver.findElement(By.cssSelector("input#travname")).sendKeys("Barry");

		driver.findElement(By.cssSelector("input#travlastname")).sendKeys("Alan");

		driver.findElement(By.cssSelector("input#dob")).click();
		Thread.sleep(1000);
		WebElement dobMonth = driver.findElement(By.cssSelector("select.ui-datepicker-month"));
		Select selectMnth = new Select(dobMonth);
		selectMnth.selectByVisibleText("Sep");

		WebElement dobYear = driver.findElement(By.cssSelector("select.ui-datepicker-year"));
		Thread.sleep(1000);
		Select selectYer = new Select(dobYear);
		selectYer.selectByVisibleText("1970");

		driver.findElement(By.cssSelector("tbody tr:nth-child(3) td:nth-child(7) a:nth-child(1)")).click();

		driver.findElement(By.id("sex_1")).click();

		driver.findElement(By.id("traveltype_2")).click();

		driver.findElement(By.id("fromcity")).sendKeys("Knoxville");

		driver.findElement(By.id("tocity")).sendKeys("Honolulu");

		driver.findElement(By.id("departon")).click();
		Thread.sleep(1000);

		WebElement departMonth = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select selectDprtMnth = new Select(departMonth);
		selectDprtMnth.selectByVisibleText("Mar");

		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[normalize-space()='20']")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("returndate")).click();

		Thread.sleep(500);

		WebElement returnMonth = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select selectRtrnMnth = new Select(returnMonth);
		selectRtrnMnth.selectByVisibleText("Aug");
		Thread.sleep(500);

		driver.findElement(By.xpath("//a[normalize-space()='25']")).click();

		driver.findElement(By.id("notes")).sendKeys("This is gonna be a great holiday!!!");

		Thread.sleep(500);

		driver.findElement(By.id("select2-reasondummy-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Prank a friend']")).click();

		driver.findElement(By.id("deliverymethod_1")).click();

		driver.findElement(By.id("billname")).sendKeys("Barry");

		driver.findElement(By.id("billing_phone")).sendKeys("865-568-3322");

		driver.findElement(By.id("billing_email")).sendKeys("balan@gmail.com");

		// TODO select country --> dropdown with span tagname ?????
		WebElement selectCountry = driver.findElement(By.id("select2-billing_country-container"));
		selectCountry.click();
		Thread.sleep(1000);
		WebElement selectUS = driver.findElement(By.xpath("//li[text()='United States (US)']"));
		selectUS.click();
		// Actions actions = new Actions(driver);
		// actions.click(selectUS).build().perform();

		driver.findElement(By.id("billing_address_1")).sendKeys("123 way drive");

		driver.findElement(By.id("billing_address_2")).sendKeys("Apt 303");

		driver.findElement(By.id("billing_city")).sendKeys("Reston");

		// TODO select state ??????
		driver.findElement(By.id("select2-billing_state-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Virginia']")).click();

		driver.findElement(By.id("billing_postcode")).sendKeys("20190");

		driver.findElement(By.id("payment_method_paypal")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("place_order")).click();

		Thread.sleep(1000);

		driver.findElement(By.linkText("Cancel and return to KTINI")).click();

		String finalMessage = driver
				.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div/div/div/div/div[1]")).getText();
		System.out.println(finalMessage);
		finalMessage.trim();

		if (finalMessage.equals("Your order was cancelled.")) {
			System.out.println("TESTCAE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		tearDown();

	}

}
