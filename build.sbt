version := "0.1.2-SNAPSHOT"
organization := "com.eed3si9n"
description := "sbt plugin to vimquit"
licenses := Seq("MIT License" -> uri("https://github.com/sbt/sbt-vimquit/blob/master/LICENSE"))
scalacOptions := Seq("-deprecation", "-unchecked")
publishMavenStyle := true

lazy val plugin = (projectMatrix in file("plugin"))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "sbt-vimquit",
    pluginCrossBuild / sbtVersion := {
      scalaBinaryVersion.value match
        case "2.12" => "1.5.8"
        case _      => "2.0.0"
    },
    scriptedSbt := {
      scalaBinaryVersion.value match
        case "2.12" => "1.10.6"
        case _      => (pluginCrossBuild / sbtVersion).value
    },
    scalacOptions ++= {
      scalaBinaryVersion.value match
        case "2.12" =>
          Seq("-Xsource:3", "-release:8", "-Xlint")
        case "3" => Nil
    },
  )
  .jvmPlatform(
    scalaVersions = Seq("3.8.4", "2.12.20")
  )

scmInfo := Some(
  ScmInfo(uri("https://github.com/sbt/sbt-vimquit"), "scm:git@github.com:sbt/sbt-vimquit.git")
)
developers := List(
  Developer(
    id = "eed3si9n",
    name = "Eugene Yokota",
    email = "@eed3si9n",
    url = uri("https://eed3si9n.com/"),
  )
)
pomIncludeRepository := { _ =>
  false
}
publishTo := {
  val centralSnapshots = "https://central.sonatype.com/repository/maven-snapshots/"
  if version.value.endsWith("-SNAPSHOT") then Some("central-snapshots" at centralSnapshots)
  else localStaging.value
}
homepage := Some(uri("https://github.com/sbt/sbt-vimquit"))
