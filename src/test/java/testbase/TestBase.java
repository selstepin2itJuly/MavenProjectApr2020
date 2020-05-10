package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String browser;
	public static Logger logger = Logger.getLogger(TestBase.class);
	
	public static WebDriver getInstance() throws IOException 
	{
		logger.info("Start reading properties");
		String file="./src/main/java/config/config.properties";
		FileInputStream inStream=new FileInputStream(new File(file));
		prop=new Properties();
		prop.load(inStream);
		
		browser=prop.getProperty("browser");
		logger.info("Get Browser from properties:"+browser);
		if(browser.equalsIgnoreCase("chrome")) 
		{
			driver=getChrome();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=getFirefox();
		}else if(browser.equalsIgnoreCase("IE")) 
		{
			driver=getIE();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			driver=getEdge();
		}else 
		{
			Throwable th=new Throwable();
			logger.info("Browser not set in properties");
			th.initCause(null);
		}
		
		//implicite wait time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		logger.info("Maximize Browser");
		driver.manage().window().maximize();
		//375, 812
		//Dimension dim=new Dimension(375,812);
		//driver.manage().window().setSize(dim);
		//driver.manage().window().fullscreen();
		driver.get(prop.getProperty("url"));
		logger.info("URL:"+prop.getProperty("url"));
		return driver;
	}
	
	private static WebDriver getEdge() 
	{
		WebDriver dr;
		String value=prop.getProperty("edgeAgent");
		String key="webdriver.edge.driver";
		//System.setProperty(key, value);
		dr=new EdgeDriver();
		return dr;
	}

	private static WebDriver getIE() {
		WebDriver dr;
		String value=prop.getProperty("IEAgent");
		String key="webdriver.ie.driver";
		System.setProperty(key, value);
		dr=new InternetExplorerDriver();
		return dr;
	}

	private static WebDriver getFirefox() 
	{
		WebDriver dr;
		String value=prop.getProperty("geckoAgent");
		String key="webdriver.gecko.driver";
		System.setProperty(key, value);
		dr=new FirefoxDriver();
		return dr;
	}

	private static WebDriver getChrome() 
	{
		WebDriver dr;
		String value=prop.getProperty("chromeAgent");
		String key="webdriver.chrome.driver";
		System.setProperty(key, value);
		dr=new ChromeDriver();
		return dr;
	}

	public static WebDriver getInstance(String browser2) throws IOException {
		logger.info("Start reading properties");
		String file="./src/main/java/config/config.properties";
		FileInputStream inStream=new FileInputStream(new File(file));
		prop=new Properties();
		prop.load(inStream);
		
		//browser=prop.getProperty("browser");
		logger.info("Get Browser from properties:"+browser2);
		if(browser2.equalsIgnoreCase("chrome")) 
		{
			driver=getChrome();
		}else if(browser2.equalsIgnoreCase("firefox"))
		{
			driver=getFirefox();
		}else if(browser2.equalsIgnoreCase("IE")) 
		{
			driver=getIE();
		}else if(browser2.equalsIgnoreCase("edge"))
		{
			driver=getEdge();
		}else 
		{
			Throwable th=new Throwable();
			logger.info("Browser not set in properties");
			th.initCause(null);
		}
		
		//implicite wait time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		logger.info("Maximize Browser");
		driver.manage().window().maximize();
		//375, 812
		//Dimension dim=new Dimension(375,812);
		//driver.manage().window().setSize(dim);
		//driver.manage().window().fullscreen();
		driver.get(prop.getProperty("url"));
		logger.info("URL:"+prop.getProperty("url"));
		return driver;
	}
}
