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
    mimaPreviousArtifacts := {
      val o = organization.value
      val n = moduleName.value
      val sbtV = (pluginCrossBuild / sbtBinaryVersion).value
      val scalaV = scalaBinaryVersion.value
      Set("0.1.1").map: v =>
        Defaults.sbtPluginExtra(o %% n % v, sbtV, scalaV)
    }
  )
  .jvmPlatform(scalaVersions = Seq("3.7.2", "2.12.20"))

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
  val centralSnapshots = "https://central.sonatype.com/repository/maven-snapshots/"
  if (version.value.endsWith("-SNAPSHOT")) Some("central-snapshots" at centralSnapshots)
  else localStaging.value
}
homepage := Some(url("https://github.com/sbt/sbt-vimquit"))
LocalRootProject / mimaReportBinaryIssues := Set.empty
