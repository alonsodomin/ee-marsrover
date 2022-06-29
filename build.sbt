import Dependencies._

ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.github.alonsodomin"
ThisBuild / organizationName := "A. Alonso Dominguez"

lazy val root = (project in file("."))
  .settings(
    name := "ee-marsrover",
    libraryDependencies += scalaTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
