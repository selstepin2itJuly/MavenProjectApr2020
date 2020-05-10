package testcases_junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;

public class TestCaseTwo {

	private static WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;


	@Before
	public void setUp() throws Exception {
		System.out.println("Before Method");
		dr=TestBase.getInstance();
		lp=new LoginPage(dr);
		dp=new DashboardPage(dr);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After Method");
		dr.quit();
	}
	@Ignore("Test is ignored as a demonstration")
	@Test
	public void test() {
		System.out.println("Test ");
		fail("Not yet implemented");
	}
	@Ignore("Test is ignored as a demonstration")
	@Test
	public void test1() 
	{
		System.out.println("Test1");
		lp.loginToapplication(TestBase.prop.getProperty("email"), TestBase.prop.getProperty("password"));
		Assert.assertTrue(dp.isUserDisplayed());
	}
	@Test
	public void test2()
	{
		System.out.println("Test 2");
		lp.loginToapplication(TestBase.prop.getProperty("email"), TestBase.prop.getProperty("password"));
		Assert.assertTrue(dp.isUserDisplayed());
		dp.clickOnLogout();
		
	}
	
}
