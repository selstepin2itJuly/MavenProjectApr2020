package testcases_testng;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestcaseOne {
	private static WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
  @Test(description="TestCaseOne.validate Valid User")
  public void test1() {
	  System.out.println("Test1");
		lp.loginToapplication(TestBase.prop.getProperty("email"), TestBase.prop.getProperty("password"));
		Assert.assertTrue(dp.isUserDisplayed());
  }
  @Test(description="TestCaseOne.validate Valid User Logout")
  public void test2() {
	  System.out.println("Test 2");
		lp.loginToapplication(TestBase.prop.getProperty("email"), TestBase.prop.getProperty("password"));
		Assert.assertTrue(dp.isUserDisplayed());
		dp.clickOnLogout();
  }
  @Test(description="TestCaseOne.validate Not implemented")
  public void test3() {
	  System.out.println("Test ");
	  fail("Not yet implemented");
  }
  @Parameters("browser")
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod(String str) throws IOException {
	  System.out.println("Before Method");
	  System.out.println("STR:"+str);
	  if(str.isEmpty()) {
		  dr=TestBase.getInstance();
	  }else {
		dr=TestBase.getInstance(str);
	  }
		lp=new LoginPage(dr);
		dp=new DashboardPage(dr);
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod() {
	  System.out.println("After Method");
	  dr.quit();
  }

}
