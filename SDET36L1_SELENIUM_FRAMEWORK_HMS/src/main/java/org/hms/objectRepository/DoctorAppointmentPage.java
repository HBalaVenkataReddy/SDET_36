package org.hms.objectRepository;

import org.hms.genericUtility.JavaUtility;
import org.hms.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DoctorAppointmentPage
{
	public DoctorAppointmentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	WebDriverUtility webdriverUtility = new WebDriverUtility();
	JavaUtility javaUtility=new JavaUtility();
	
	@FindBy(xpath="//a[contains(text(),'Book Appointment')]")
	private WebElement createNewAppointment;
	
	@FindBy(xpath="//select[@name='Doctorspecialization']")
	private WebElement selectDoctorSpecialization;
	
	@FindBy(xpath="//select[@name='doctor']")
	private WebElement selectDoctorName;
		
	@FindBy(xpath="//input[@name='appdate']")
	private WebElement selectDate;
	
	@FindBy(xpath = "//table[@class=' table-condensed']/thead/tr/th[@class='datepicker-switch']")
	private WebElement currentMonthYear;
	
	@FindBy(xpath = "//table[@class=' table-condensed']/thead/tr/th[@class='next']")
	private WebElement clickNext;
	
	@FindBy(xpath="//td[text()='25' and @class='day']")
	private WebElement date;
	
	@FindBy(xpath = "//input[@id='timepicker1']")
	private WebElement time;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submit;
	public void clickonCreateAppointment()
	{
		createNewAppointment.click();
	}
	public void selectDoctorSpecialization(WebDriverUtility webDriverUtility, String value)
	{
		webdriverUtility.selectText(selectDoctorSpecialization, value);	
	}
	public void selectDoctorName(WebDriverUtility webDriverUtility, String value)
	{
		webdriverUtility.selectText(selectDoctorName, value);
	}
	public void selectDate()
	{
		selectDate.click();
		date.click();
		time.click();
		submit.click();
    } 
	
}