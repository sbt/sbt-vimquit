version := "0.1.2-SNAPSHOT"
organization := "com.eed3si9n"
description := "sbt plugin to vimquit"
licenses := Seq("MIT License" -> url("https://github.com/sbt/sbt-vimquit/blob/master/LICENSE"))
scalacOptions := Seq("-deprecation", "-unchecked")
publishMavenStyle := true

lazy val plugin = (projectMatrix in file("plugin"))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "sbt-vimquit",
  )
  .jvmPlatform(scalaVersions = Seq("3.3.4", "2.12.20"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/sbt/sbt-vimquit"),
    "scm:git@github.com:sbt/sbt-vimquit.git"
  )
)
developers := List(
  Developer(
    id = "eed3si9n",
    name = "Eugene Yokota",
    email = "@eed3si9n",
    url = url("https://eed3si9n.com/")
  )
)
pomIncludeRepository := { _ =>
  false
}
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if isSnapshot.value then Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
homepage := Some(url("https://github.com/sbt/sbt-vimquit"))
