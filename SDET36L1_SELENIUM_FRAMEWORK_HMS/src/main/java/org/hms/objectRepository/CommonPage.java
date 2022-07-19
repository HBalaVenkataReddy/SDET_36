package org.hms.objectRepository;

import org.hms.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage 
{
	public CommonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[text()='Patients']/following-sibling::div[@class='button']/child::span/a[text()='Click Here']")
	private WebElement patientLogin;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameTextField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement lognBtn;
	
	@FindBy(xpath = "//i[@class='ti-angle-down']")
	private WebElement logoutdown;
	
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logOut;
	public void clickPatientLogin()
	{
		patientLogin.click();
	}
	public void loginAction(String userName, String password)
	{
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		lognBtn.click();
	}
	public void logOutAction()
	{
		logoutdown.click();
		logOut.click();
	}
}