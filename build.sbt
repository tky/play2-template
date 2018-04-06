import PlayGulp._

name := """play-template"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).settings(playGulpSettings)

scalaVersion := "2.12.5"

routesGenerator := InjectedRoutesGenerator

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies += guice

libraryDependencies ++= Seq(
    "com.typesafe.play" %% "play-slick" % "3.0.3",
    "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3",
    "joda-time" % "joda-time" % "2.9.6",
    "com.github.tototoshi" %% "slick-joda-mapper" % "2.3.0",
    "com.h2database" % "h2" % "1.4.192",
    "io.lemonlabs" %% "scala-uri" % "0.5.0",
    "javax.xml.bind" % "jaxb-api" % "2.3.0",
    "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
    "org.jsoup" % "jsoup" % "1.10.1" % Test,
    specs2 % Test
)

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

fork in run := true

javaOptions in Test += "-Dconfig.file=conf/test.conf"

TwirlKeys.templateImports += "domain.models._"

TwirlKeys.templateImports += "presentation._"

packageName in Universal := "play2-template"
