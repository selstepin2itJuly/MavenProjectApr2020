package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

	private WebDriver dr;
	
	public LoginPage(WebDriver d)
	{
		this.dr=d;
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(dr, 20);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	//@FindBys(value = { @FindBy(name="Password"), @FindBy(css="[type='password']") })
	@FindBy(name="Password")
	WebElement pass;
	
	@FindAll(value = { @FindBy(css="[type='submit']"),@FindBy(xpath="//*[@value='Log in']") })
	WebElement loginButton;
	
	@FindBy(xpath="//form[@method='post']/div/ul/li")
	WebElement passErrorCheck;
	
	@FindBy(xpath="#Email-error")
	WebElement userErrorCheck;
	
	@FindBy(css="div.title>strong")
	WebElement welcomeScreen;
	
	public String getWrongUserText()
	{
		return userErrorCheck.getText();
	}
	public boolean welcomeMsgDisplay()
	{
		boolean b=false;
		try {
			b=welcomeScreen.isDisplayed();
		}catch(Exception e) {}
		return b;
	}
	public String welcomeMsg() 
	{
		return welcomeScreen.getText();
	}
	public void enterUsername(String user) 
	{
		email.clear();
		email.sendKeys(user);
	}
	public void enterPassword(String password)
	{
		pass.clear();
		pass.sendKeys(password);
	}
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	public void loginToapplication(String username, String password) 
	{
		email.clear();
		email.sendKeys(username);
		pass.clear();
		pass.sendKeys(password);
		loginButton.click();
	}
	
	public boolean getEmailErrorCheck()
	{
		boolean b=false;
		try 
		{
			b=userErrorCheck.isDisplayed();
		}catch(Exception e) {}
		return b;
	}
	public boolean getPassErrorCheck()
	{
		boolean b=false;
		try 
		{
			b=passErrorCheck.isDisplayed();
		}catch(Exception e) {}
		return b;
	}
	public String getPassErrorCheckMessage()
	{
		return	passErrorCheck.getText();
	}
}
