package pages

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}
import utils.GlobalVariables

class HomePage (driver: WebDriver) {


  var search: By = By.xpath("//input[@type='search']")
  var productName: By = By.cssSelector(".product-name")

  def searchItem(name: String): Unit = {
    driver.findElement(search).sendKeys(name)
  }

  def getProductName: String = {
    driver.findElement(productName).getText;
  }

  def getTitleLandingPage: String = {
    driver.getTitle;
  }



}
