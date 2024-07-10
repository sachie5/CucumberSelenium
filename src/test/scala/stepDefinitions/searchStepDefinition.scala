package stepDefinitions
import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebDriver, WebElement}
import pages.HomePage

import java.util

// Extension necessary for scalal to recognise keywords
class searchStepDefinition extends ScalaDsl with EN {
  System.setProperty("webdriver.chrome.driver", "C:\\Users\\winni\\eclipse-workspace\\libs\\chromedriver.exe")
  var homePage: HomePage = new HomePage()
  private var driver: WebDriver = homePage.driver;
  var productName: String = "";
  Given("""User is on GreenKart Landing page""") { () =>
    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    driver.getTitle.contains("GreenKart")
  }
  When("""user searched with Shortname {string} and extracted actual name of product""") { (shortname: String) =>
    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
    Thread.sleep(2000)
    productName  = driver.findElement(By.className("product-name")).getText.split("-")(0);
  }

  Then("""user searched for {string} shortname in offers page""") { (shortname: String) =>

    var parentWindowHandle : String = driver.getWindowHandle
    System.out.println(parentWindowHandle)
    homePage.dealsPage
    Thread.sleep(2000)
  }

  Then("""validate product name in offers page matches with Landing Page""") { () =>
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.scala.PendingException()
  }

}
