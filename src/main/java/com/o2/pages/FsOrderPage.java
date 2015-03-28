package com.o2.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FsOrderPage {

	WebDriver driver;
	By microsimRadio = By.id("microSimRadioButton");
	By firstNameText = By.id("firstName");
	By lastNametext = By.id("lastName");
	By emailText = By.id("email");
	By mobileText = By.id("mobile");
	By houseNumberText = By.id("houseNumber");
	By postcodetext = By.id("postcode");
	By findAddressBtn = By.id("findAddress");
	By houseName = By.id("houseName");
	By termsChk = By.id("termsAndConditionsAgreement");
	
	public FsOrderPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public String placeOrder(String fn, String ln, String email, String mobile, String hn, String postcode) {
		
		  driver.findElement(microsimRadio).click();
		  Select title = new Select(driver.findElement(By.id("title")));
		  title.selectByVisibleText("Mr");
		  driver.findElement(firstNameText).sendKeys(fn);
		  driver.findElement(lastNametext).sendKeys(ln);
		  driver.findElement(emailText).sendKeys(email);
		  driver.findElement(mobileText).sendKeys(mobile);
		  
		  driver.findElement(houseNumberText).sendKeys(hn);
		  
		  driver.findElement(postcodetext).sendKeys(postcode);
		  
		  driver.findElement(By.id("findAddress")).click();
		  
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  
		  if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addressSelection"))) != null) {
			  System.out.print("Address lookup success");

			  Select addressselect = new Select(driver.findElement(By.id("addressSelection")));
			  //addressselect.selectByValue("{"houseName":"02 UK","houseNumber":"260","line1":"02 UK","line2":"BATH RD","town":"SLOUGH","county":"BERKS","postcode":"SL1 4DX"}");
			 // System.out.print(addressselect.);
			  addressselect.selectByVisibleText("02 UK, BATH RD");
		  } else {
			  
			  System.out.print("Address lookup failed");
		  }
		  driver.findElement(By.id("houseName")).clear();
		  
		  driver.findElement(termsChk).click();
		  driver.findElement(termsChk).submit();
		  

		 // if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Back to Free Sim"))) != null) {
		  
		  //String ordernumber = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/div[2]/div/div/div/div[1]/h6")).getText();
		  String ordernumber = driver.findElement(By.cssSelector("div[class*=\"confirmationContainer\"] h6")).getText();
		  
		 // System.out.println("Order number: "+ ordernumber);
		  
		
		return ordernumber;
		  //}
		  //return  new String ("no order placed");
	}
}
