lazy val commonSettings: Seq[Setting[_]] = Seq(
  ThisBuild / version := "0.1.0",
  ThisBuild / organization := "com.eed3si9n",
)

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    sbtPlugin := true,
    name := "sbt-vimquit",
    description := "sbt plugin to create a single fat jar",
    licenses := Seq("MIT License" -> url("https://github.com/sbt/sbt-vimquit/blob/master/LICENSE")),
    scalacOptions := Seq("-deprecation", "-unchecked"),
    publishMavenStyle := false,
    bintrayOrganization in bintray := None,
    bintrayRepository := "sbt-plugins",
  )
