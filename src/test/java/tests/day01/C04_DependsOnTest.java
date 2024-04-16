package tests.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C04_DependsOnTest {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	// https://www.testotomasyonu.com/ adresine gidin.
	//1. Test : Testotomasyonu ana sayfaya gittiginizi test edin
	@Test
	public void anaSayfaTesti() {
		driver.get("https://www.testotomasyonu.com");
		String expectedUrl = "https://www.testotomasyonu.com/";
		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	//2. Test : 1.Test PASSED ise search Box’i kullanarak “phone” icin arama yapin
	//ve arama sonucunda urun bulunabildigini test edin
	@Test(dependsOnMethods = "anaSayfaTesti")
	public void searchBoxTesti() {
		WebElement searchBox = driver.findElement(By.id("global-search"));

		searchBox.sendKeys("phone", Keys.ENTER);

		List<WebElement> bulunanUrunList = driver
				.findElements(By.xpath("//*[@class='product-box my-2  py-1']"));
		ReusableMethods.wait(1);

		Assert.assertTrue(bulunanUrunList.size() > 0);
	}

	//3.Test : 2.Test PASSED ise ilk urunu tiklayin ve urun isminin case sensitive
	//olmaksizin phone icerdigini test edin
	@Test(dependsOnMethods = "searchBoxTesti")
	public void productTest() {
		List<WebElement> bulunanUrunList = driver
				.findElements(By.xpath("//*[@class='product-box my-2  py-1']"));

		bulunanUrunList.get(0).click();

		String expectedProductName = "phone";
		String actualProductName = driver
				.findElement(By.xpath("(//div[@class ='prod-detail']/div)[1]"))
				.getText()
				.toLowerCase();
		ReusableMethods.wait(1);
		Assert.assertTrue(actualProductName.contains(expectedProductName));
	}
}
