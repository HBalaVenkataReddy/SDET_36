package org.patient.appointment;

import org.hms.genericUtility.ExcelUtility;
import org.hms.genericUtility.FileUlitity;
import org.hms.genericUtility.IConstants;
import org.hms.genericUtility.JavaUtility;
import org.hms.genericUtility.WebDriverUtility;
import org.hms.objectRepository.CommonPage;
import org.hms.objectRepository.DoctorAppointmentPage;
import org.openqa.selenium.WebDriver;

public class BookAppointmentTest {

	public static void main(String[] args)
	{
		//Patient
		FileUlitity fileUtility = new FileUlitity();
		ExcelUtility excelUtility = new ExcelUtility();
		JavaUtility javaUtility = new JavaUtility();
		WebDriverUtility webdriverUtiltity = new WebDriverUtility();
		
		fileUtility.intiallizePropertyFile(IConstants.PATIENTAPPOINTPROPERTYFILEPATH);
		excelUtility.intiallizeExcelFile(IConstants.PATIENTAPPOINTEXCELFILEPATH);
		String browser = fileUtility.getDataProperty("browser");
		String url = fileUtility.getDataProperty("url");
		String userName = fileUtility.getDataProperty("username");
		String password = fileUtility.getDataProperty("password");
		String timeout = fileUtility.getDataProperty("timeout");
		int randomNumber=javaUtility.getRandomNumber(100);
		
		WebDriver driver = webdriverUtiltity.setupDriver(browser);
		long longTimeout = javaUtility.convertStringToLong(timeout);
		webdriverUtiltity.openApplication(url);
		webdriverUtiltity.maximizeBrowser();
		String value0 = excelUtility.getDataFromExcel(3, 1, "Patient");
		String value1 = excelUtility.getDataFromExcel(3, 2, "Patient");		
		CommonPage commonPage = new CommonPage(driver);
		DoctorAppointmentPage doctorAppointmentPage = new DoctorAppointmentPage(driver);
		commonPage.clickPatientLogin();
		commonPage.loginAction(userName, password);
		doctorAppointmentPage.clickonCreateAppointment();
		doctorAppointmentPage.selectDoctorSpecialization(webdriverUtiltity, value0);
		doctorAppointmentPage.selectDoctorName(webdriverUtiltity, value1);
		doctorAppointmentPage.selectDate();
		driver.switchTo().alert().accept();
		commonPage.logOutAction();	
	}
}
