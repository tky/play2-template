import PlayGulp._

name := """play-template"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).settings(playGulpSettings)

scalaVersion := "2.11.11"

routesGenerator := InjectedRoutesGenerator

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
    "com.typesafe.play" %% "play-slick" % "2.1.0",
    "com.typesafe.play" %% "play-slick-evolutions" % "2.1.0",
    "joda-time" % "joda-time" % "2.9.6",
    "com.github.tototoshi" %% "slick-joda-mapper" % "2.3.0",
    "com.h2database" % "h2" % "1.4.192",
    "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0" % "test",
    "org.jsoup" % "jsoup" % "1.10.1" % "test",
    specs2 % Test
)

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

fork in run := true

javaOptions in Test += "-Dconfig.file=conf/test.conf"

TwirlKeys.templateImports += "domain.models._"
