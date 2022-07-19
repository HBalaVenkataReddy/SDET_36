package org.hms.genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class WebDriverUtility
{
	private WebDriver driver;
	private Actions act;
	private WebDriverWait wait ;
	public WebDriver setupDriver(String browser)
	{
		switch (browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
            break;
		default:
			System.out.println("you have entered wrong Browser key in the property file");
			break;
		}
		return driver;
	}
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	public void implicitWait(long longtimeOut)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longtimeOut));
	}
	public void intiallizeExplicitWait(long timeOuts,long pollingTime)
	{
		 wait = new WebDriverWait(driver,Duration.ofSeconds(timeOuts));
		 wait.pollingEvery(Duration.ofMillis(pollingTime));
		 wait.ignoring(Exception.class);
	}
	public void waitTillElementVisible(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitTillElementInvisible(WebElement element)
	{
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void openApplication(String url)
	{
		driver.get(url);
	}
	public void intiallizeActions()
	{
		act=new Actions(driver);
	}
	public void mouseHoverOnElement(WebElement element)
	{
		act.moveToElement(element).perform();
	}
	public void rightClickElement(WebElement element)
	{
		act.contextClick(element).perform();
	}
	public void doubleClickElement(WebElement element)
	{
		act.doubleClick(element).perform();
	}
	public void switchFrame(String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	public void switchFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	public void selectText(WebElement element, String visibleText)
	{
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	public void selectValue(String value, WebElement element)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	public void selectIndexNumber(WebElement element, int indexNumber)
	{
		Select s = new Select(element);
		s.selectByIndex(indexNumber);
	}
	public void closeBrowser()
	{
		driver.quit();
	}
	public void closeTab()
	{
		driver.close();
	}
}
