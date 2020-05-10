package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DashboardPage {

	private WebDriver dr;
	public DashboardPage(WebDriver d)
	{
		this.dr=d;
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(dr, 20);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(css=".account-info")
	WebElement user;

	@FindBy(linkText="Logout")
	WebElement logout;
	
	@FindBy(css="ul[class='sidebar-menu tree'] > li.treeview > a > span")
	List<WebElement> sidemenu;
	
	public boolean isUserDisplayed()
	{
		boolean b=false;
		try 
		{
			b=user.isDisplayed();
		}catch(Exception e) {}
		return b;
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}
	public List<String> getSideMenu()
	{
		List<String> str=new ArrayList<String>();
		for(WebElement e: sidemenu)
		{
			str.add(e.getText());
		}
		return str;
	}
	
}
