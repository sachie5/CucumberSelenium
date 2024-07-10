package pages

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}

class HomePage {


  var driver: WebDriver = new ChromeDriver();
  def HomePage(driver: WebDriver): Unit = {
    this.driver = driver
  }

  var search: By = By.xpath("//input[@type='search']")
  var productName: By = By.cssSelector(".product-name")
  var dealsPage : By = By.linkText("Top Deals")
//  By.xpath("//*[@id='root']/div/header/div/div[3]/a[1]")
  def searchItem(name: String): Unit = {
    driver.findElement(search).sendKeys(name)
  }

  def getProductName(): String = {
    driver.findElement(productName).getText;
  }

  def getTitleLandingPage: String = {
    driver.getTitle;
  }

  def getDeals = {
      driver.findElement(dealsPage).click();
  }


}
