package tests.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_TestOtomasyonAssertions {
	//Bir class oluşturun: TestOtomasyonAssertions
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.testotomasyonu.com");
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	//1) https://www.testotomasyonu.com adresine gidin

	//2) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin

	//○ titleTest => Sayfa başlığının “Test Otomasyonu” içerdiğini test edin
	@Test(priority = 0)
	public void titleTest() {
		String expectedTitle = "Test Otomasyonu";
		String actualTitle = driver.getTitle();

		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}

	//○ imageTest => Test Otomasyon resminin görüntülendiğini (isDisplayed()) test edin
	@Test(priority = -1)
	public void imageTest() {
		WebElement imageElement = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

		Assert.assertTrue(imageElement.isDisplayed());
	}

	//○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
	@Test(priority = 0)
	public void searchBoxTest() {
		WebElement searchBox = driver.findElement(By.id("global-search"));

		Assert.assertTrue(searchBox.isEnabled());
	}

	//○ wrongTitleTest => Sayfa basliginin “testotomasyonu” olmadigini dogrulayin
	@Test(priority = -10)
	public void wrongTitleTest() {
		String expectedWrongTitle = "testotomasyonu";
		String actualTitle = driver.getTitle();

		//Assert.assertFalse(driver.getTitle().equals(expectedWrongTitle));
		Assert.assertNotEquals(actualTitle, expectedWrongTitle);
	}
}
