name := """tripApi"""
organization := "tripDesigner"

version := "1.0-SNAPSHOT"

lazy val myProject = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.4"

libraryDependencies += guice

libraryDependencies ++= Seq(
  jdbc,
  javaCore,
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42"
)

