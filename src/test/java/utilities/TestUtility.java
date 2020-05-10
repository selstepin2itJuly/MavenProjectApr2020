package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.TestBase;

public class TestUtility extends TestBase{

	
	public static void scrollToElement(WebElement e)
	{
		//JavascriptExecutor je= (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", e);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);", "");
	}
	public static void clickOnElementJavascriptExecutor(WebElement e) 
	{
		//JavascriptExecutor je= (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
	}
	
	public static void captureScreenInJPG() throws IOException
	{
		//TakesScreenshot ts= (TakesScreenshot) driver;
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(getDateStamp()+"_images.jpg"));
	}
	public static void captureScreenInPNG() throws IOException
	{
		//TakesScreenshot ts= (TakesScreenshot) driver;
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(getDateStamp()+"_images.png"));
	}
	
	public static String getDateStamp() 
	{
		Date dt= new Date();
		//System.out.println(dt);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS");
		String s=sdf.format(dt);
		//System.out.println(s);
		return s;
	}
	
	//Explicit wait timer
	public static void waitForElement(WebElement ele) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public static void waitForElementClickable(WebElement ele) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public static void waitForElementInvisible(WebElement ele) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
