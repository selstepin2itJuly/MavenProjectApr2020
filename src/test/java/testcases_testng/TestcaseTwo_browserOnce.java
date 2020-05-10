package testcases_testng;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestcaseTwo_browserOnce {
	private static WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	
  @Test(enabled=true,priority=1,description="TestCaseTwo.check Valid Username")
  public void checkValidUsername() {
	  lp.enterPassword("");
	  lp.enterUsername("user"); //faulty data
	  lp.clickOnLoginButton();
	  assertTrue(lp.getEmailErrorCheck());
	  System.out.println(lp.getWrongUserText());
	  TestBase.logger.info(lp.getWrongUserText());
  }
  @Test(priority=2,description="TestCaseTwo.check Error on wrong  credentials")
  public void checkErrorOnWrongCredetial() {
	  lp.enterUsername(TestBase.prop.getProperty("email"));
	  lp.enterPassword("aefqtqrwt");
	  lp.clickOnLoginButton();
	  assertTrue(lp.getPassErrorCheck());
	  System.out.println(lp.getPassErrorCheckMessage());
	  TestBase.logger.info(lp.getPassErrorCheckMessage());
  }
  @Test(priority=3,dependsOnMethods="checkValidUsername",description="TestCaseTwo.check Welcome Message")
  public void checkWelcomeMessage() {
	  assertTrue(lp.welcomeMsgDisplay());
	  String actual=lp.welcomeMsg();
	  System.out.println(actual);
	  TestBase.logger.info(lp.welcomeMsg());
	  Assert.assertEquals(actual, "Welcome, please sign in");
  }
  @Parameters("browser")
  @BeforeClass(alwaysRun=true)
  public void beforeClass(String str) throws IOException {
	  TestBase.logger.info(this.getClass());
	  TestBase.logger.info("Before Method");
	  System.out.println("Before Method");
	  System.out.print("STR:"+str);
	  if(str.isEmpty()) {
		  dr=TestBase.getInstance();
	  }else {
		dr=TestBase.getInstance(str);
	  }
	  lp=new LoginPage(dr);
	  dp=new DashboardPage(dr);
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  System.out.println("After Method");
	  TestBase.logger.info("After Method");
	  dr.quit();
	  TestBase.logger.info("Browser Closed");
  }

}
