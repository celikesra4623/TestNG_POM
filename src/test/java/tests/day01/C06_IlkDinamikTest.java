package tests.day01;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C06_IlkDinamikTest {

	@Test
	public void test01() {
		//test otomasyonu sayfasına gidin
		Driver.getDriver().get("https://www.testotomasyonu.com");

		//phone için arama yapın
		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();

		testOtomasyonPage.searchBox.sendKeys("phone", Keys.ENTER);

		//arama sonucunda ürün bulunabildiğini test edin
		List<WebElement> bulunanUrunElement = testOtomasyonPage.bulunanUrunElementList;

		int bulunanUrunSayisi = bulunanUrunElement.size();

		Assert.assertTrue(bulunanUrunSayisi > 0);

		// ikinci ürüne tıklayın
		bulunanUrunElement.get(1).click();
		ReusableMethods.wait(1);

		//ikinci ürünün isminde phone geçtiğini test edin
		String expectedName = "phone";
		String actualName = testOtomasyonPage.productNameElement.getText().toLowerCase();

		Assert.assertTrue(actualName.contains(expectedName));

		Driver.quitDriver();
	}
}
