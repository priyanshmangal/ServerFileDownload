name := "FileDownload"

version := "0.1"

scalaVersion := "2.11.0"


// Source and Sink Library
// libraryDependencies += "com.databricks" %% "spark-csv" % "1.3.0"

libraryDependencies += "com.jcraft" % "jsch" % "0.1.43-1"

libraryDependencies += "commons-net" % "commons-net" % "3.6"

libraryDependencies += "org.scalaj" % "scalaj-http_2.10" % "2.3.0"

libraryDependencies += "com.typesafe" % "config" % "1.3.4"

libraryDependencies += "joda-time" % "joda-time" % "2.9.4"


// Scala Unit Test Library
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0"

libraryDependencies += "net.liftweb" % "lift-json_2.10" % "2.6.2"
