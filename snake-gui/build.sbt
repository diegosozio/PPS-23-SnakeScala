ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "snake-gui"
  )

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"