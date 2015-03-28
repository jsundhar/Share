package com.o2.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class FreesimTariffPage {
 WebDriver driver;
 
 //Page Elements
 By phoneTab =  By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/div/ul/li[1]/a");
 By Sbutton_500m =  By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/button");
  By submit500mb =  By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/form/button");
 
 public FreesimTariffPage(WebDriver driver) {
	 this.driver = driver;
 }

 public void phone500Selection () {
	 driver.findElement(phoneTab).click();
	 driver.findElement(Sbutton_500m).click();
	 Select sel_500SimType = new Select(driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/form/div/select")));

	 sel_500SimType.selectByValue("NSIM");
	 driver.findElement(submit500mb).click();	 
 }
 
 
}