package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonPage {

	public TestOtomasyonPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "global-search")
	public WebElement searchBox;

	@FindBy(xpath = "//*[@class='product-box my-2  py-1']")
	public List<WebElement> bulunanUrunElementList;

	@FindBy(xpath = "(//*[text()='Account'])[1]")
	public WebElement accountLink;

	@FindBy(id = "email")
	public WebElement emailBox;

	@FindBy(id = "password")
	public WebElement passwordBox;

	@FindBy(id = "submitlogin")
	public WebElement loginButton;

	@FindBy(xpath = "//span[text()='Logout']")
	public WebElement logoutButton;

	@FindBy(xpath = "//*[@*='add-to-cart']")
	public WebElement addToCartButton;

	@FindBy(xpath = "//*[@class='fas fa-sharp fa-regular fa-plus']")
	public WebElement incrementProductNumberButton;

	@FindBy(xpath = "(//div[@class='prod-detail']/div)[1]")
	public WebElement productNameElement;

}
