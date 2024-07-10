ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "CucumberSelenium"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
libraryDependencies += "org.scalatestplus" %% "selenium-4-21" % "3.2.19.0" % "test"
// https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "4.22.0"
libraryDependencies += "io.cucumber" %% "cucumber-scala" % "8.21.0" % Test
libraryDependencies += "io.cucumber" % "cucumber-junit" % "7.18.0"
