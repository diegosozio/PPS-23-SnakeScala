ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "snake-gui"
  )

assembly / assemblyMergeStrategy := {
  case "reference.conf" => MergeStrategy.concat
  case PathList("META-INF", _@_*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

assembly / mainClass := Some("SnakeGameGui")

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"