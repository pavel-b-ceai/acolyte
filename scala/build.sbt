name := "acolyte-scala"

organization := "acolyte"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.10.0"

javacOptions in Test ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

scalacOptions += "-feature"

resolvers += "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"

libraryDependencies += "org.specs2" %% "specs2" % "1.14" % "test"

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))