package pages

import org.openqa.selenium.{By, WebDriver}
import utils.GlobalVariables

class OfferPage (driver: WebDriver) {

  var search: By = By.xpath("//input[@type='search']")
  var dealsPage : By = By.linkText("Top Deals")
  var offerProduct: By = By.cssSelector("tr td:nth-child(1)")

  def searchItem(name: String): Unit = {
    driver.findElement(search).sendKeys(name)
  }

  def getDeals = {
    driver.findElement(dealsPage).click();
  }


  def findOfferProduct = {
    driver.findElement(offerProduct).getText
  }
}
