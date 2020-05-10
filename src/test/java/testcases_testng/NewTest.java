package testcases_testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test(description="NewTest.testOne")
  public void testOne() {
	  System.out.println("Test One");
  }
  @Test(description="NewTest.testTwo")
  public void testTwo() {
	  System.out.println("Test Two");
  }
  @Test(description="NewTest.testThree")
  public void testThree() {
	  System.out.println("Test Three");
  }
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() {
	  System.out.println("Before Method");
  }
  

  @AfterMethod(alwaysRun=true)
  public void afterMethod() {
	  System.out.println("After Method");
  }

  @BeforeClass(alwaysRun=true)
  public void beforeClass() {
	  System.out.println("Before Class");
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  System.out.println("After class");
  }

  @BeforeTest(alwaysRun=true)
  public void beforeTest() {
	  System.out.println("Before Test");
  }

  @AfterTest(alwaysRun=true)
  public void afterTest() {
	  System.out.println("After Test");
  }

  @BeforeSuite(alwaysRun=true)
  public void beforeSuite() {
	  System.out.println("Before Suite");
  }

  @AfterSuite(alwaysRun=true)
  public void afterSuite() {
	  System.out.println("After Suite");
  }

}
