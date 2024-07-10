package stepDefinitions
import io.cucumber.scala.{EN, ScalaDsl}
import junit.framework.TestCase.assertEquals
import org.hamcrest.MatcherAssert.assertThat
import org.openqa.selenium.{By, WebDriver, WebElement}
import pages.HomePage

import java.util

// Extension necessary for scalal to recognise keywords
class searchStepDefinition extends ScalaDsl with EN {
  System.setProperty("webdriver.chrome.driver", "C:\\Users\\winni\\eclipse-workspace\\libs\\chromedriver.exe")
  var homePage: HomePage = new HomePage()
  private var driver: WebDriver = homePage.driver;
  var productName: String = "";
  var offerPageProductName = "";

  Given("""User is on GreenKart Landing page""") { () =>
    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    driver.getTitle.contains("GreenKart")
  }
  When("""user searched with Shortname {string} and extracted actual name of product""") { (shortname: String) =>
    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
    Thread.sleep(2000)
    productName  = driver.findElement(By.className("product-name")).getText.split("-")(0).trim();
  }

  Then("""user searched for {string} shortname in offers page""") { (shortname: String) =>
    driver.findElement(By.linkText("Top Deals")).click();
    val s1: util.Set[String] = driver.getWindowHandles;
    val i1: util.Iterator[String] = s1.iterator;
    val parentWindow: String = i1.next()
    val childWindow: String = i1.next()
    driver.switchTo().window(childWindow);
    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
    Thread.sleep(2000)
    offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText;
  }

  Then("""validate product name in offers page matches with Landing Page""") { () =>
      assertEquals(productName, offerPageProductName)
  }

}
