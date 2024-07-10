package testRunner

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith


@RunWith(classOf[Cucumber])
@CucumberOptions(features=Array("src/test/scala/features"), glue=Array("stepDefinitions"), monochrome=true)
class TestRunner  {

}
