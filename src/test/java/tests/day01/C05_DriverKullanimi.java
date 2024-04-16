package tests.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_DriverKullanimi {

	@Test
	public void test01() {
		Driver.getDriver().get("https://www.testotomasyonu.com");
		ReusableMethods.wait(2);
		WebElement searchBox = Driver.getDriver().findElement(By.id("global-search"));
		searchBox.sendKeys("phone", Keys.ENTER);
		ReusableMethods.wait(2);
		//Driver.getDriver().get("https://www.testotomasyonu.com");
		//ReusableMethods.wait(2);

		Driver.quitDriver();
	}
}
