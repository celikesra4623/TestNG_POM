package tests.day01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_DependsOnMethods {

	@Test
	public void test01() {
		System.out.println("Test 1 çalıştı");
	}
	@Test(dependsOnMethods = "test01")
	public void test02() {
		System.out.println("Test 2 çalıştı");
		//Assert.assertTrue(false);
	}

	@Test(dependsOnMethods = "test02")
	public void test03() {
		System.out.println("Test 3 çalıştı");
	}

	@Test(dependsOnMethods = "test03")
	public void test04() {
		System.out.println("test4");
	}
}
