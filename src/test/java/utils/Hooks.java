package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	public static WebDriver driver;

	public static void setUp() {

		WebDriverManager.safaridriver().setup();

		driver = new SafariDriver();

		driver.manage().window().maximize();

	}

	public static void tearDown() {

		try {
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
	}

}
