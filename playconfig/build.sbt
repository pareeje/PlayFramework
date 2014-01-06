import play.Project._

name := """playconfig"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
	javaEbean,
	"mysql" % "mysql-connector-java" % "5.1.18",	
	"com.typesafe.slick" %% "slick" % "1.0.0",
    "org.webjars" %% "webjars-play" % "2.2.0",
	"org.webjars" % "bootstrap" % "2.3.1")
	
playJavaSettings

