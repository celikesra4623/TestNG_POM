package tests.day01;

import org.testng.Assert;
import org.testng.annotations.*;

public class C01_Annotations {

	@BeforeClass
	public void setup() {
		System.out.println("Before class notasyon çalıştı");
	}

	@AfterClass
	public void teardown() {
		System.out.println("After class notasyon çalıştı");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method notasyon çalıştı");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method çalıştı");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test çalıştı");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After test çalıştı");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite");
	}
	@Test
	public void test01() {
		System.out.println("test 01 çalıştı");
		Assert.assertTrue(3 > 2);
	}

	@Test(priority = 7)
	public void test02() {
		System.out.println("test 02 çalıştı");
		Assert.assertEquals(3, 3);
	}

	@Test
	public void test03() {
		System.out.println("test 03 çalıştı");
		Assert.assertFalse(3 > 5, "test03 failed!");
	}
}
