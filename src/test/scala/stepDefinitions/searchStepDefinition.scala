package stepDefinitions
import io.cucumber.scala.{EN, ScalaDsl}
import junit.framework.TestCase.assertEquals
import org.hamcrest.MatcherAssert.assertThat
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}
import pages.{HomePage, OfferPage}
import utils.GlobalVariables

import java.util

// Extension necessary for scalal to recognise keywords
class searchStepDefinition extends ScalaDsl with EN {

  var globalVariables = new GlobalVariables;
  private var driver: WebDriver = globalVariables.driver;
  var homePage: HomePage = new HomePage(driver)
  var offerPage: OfferPage = new OfferPage(driver);
  var productName: String = "";
  var offerPageProductName = "";

  Given("""User is on GreenKart Landing page""") { () =>
    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    driver.getTitle.contains("GreenKart")
  }
  When("""^user searched with Shortname (.+) and extracted actual name of product$""") { (shortname: String) =>
    homePage.searchItem(shortname)
    Thread.sleep(2000)
    productName = homePage.getProductName.split("-")(0).trim();
  }

  Then("""^user searched for (.+) shortname in offers page$""") { (shortname: String) =>
    offerPage.getDeals
    val s1: util.Set[String] = driver.getWindowHandles;
    val i1: util.Iterator[String] = s1.iterator;
    val parentWindow: String = i1.next()
    val childWindow: String = i1.next()
    driver.switchTo().window(childWindow);
    offerPage.searchItem(shortname)
    Thread.sleep(2000)
    offerPageProductName = offerPage.findOfferProduct;
  }

  Then("""validate product name in offers page matches with Landing Page""") { () =>
      assertEquals(productName, offerPageProductName)
  }

}
