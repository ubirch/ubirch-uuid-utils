
/*
 * BASIC INFORMATION
 ********************************************************/

name := "ubirch-uuid-utils"
version := "0.1.4"
description := "UUID related utils"
organization := "com.ubirch.util"
homepage := Some(url("http://ubirch.com"))
scalaVersion := "2.11.12"
scalacOptions ++= Seq(
  "-feature"
)
scmInfo := Some(ScmInfo(
  url("https://github.com/ubirch/ubirch-uuid-utils"),
  "https://github.com/ubirch/ubirch-uuid-utils.git"
))

/*
 * CREDENTIALS
 ********************************************************/

(sys.env.get("CLOUDREPO_USER"), sys.env.get("CLOUDREPO_PW")) match {
  case (Some(username), Some(password)) =>
    println("USERNAME and/or PASSWORD found.")
    credentials += Credentials("ubirch.mycloudrepo.io", "ubirch.mycloudrepo.io", username, password)
  case _ =>
    println("USERNAME and/or PASSWORD is taken from /.sbt/.credentials")
    credentials += Credentials(Path.userHome / ".sbt" / ".credentials")
}


/*
 * RESOLVER
 ********************************************************/

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"))


/*
 * PUBLISHING
 ********************************************************/

val resolverUbirchUtils = "cloudrepo.io" at "https://ubirch.mycloudrepo.io/repositories/ubirch-utils-mvn"

publishTo := Some(resolverUbirchUtils)
publishMavenStyle := true


/*
 * DEPENDENCIES
 ********************************************************/

lazy val scalaUuid = "io.jvm.uuid" %% "scala-uuid" % "0.2.3"
lazy val apacheCommonsCodec = "commons-codec" % "commons-codec" % "1.11"
lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"

libraryDependencies ++= Seq(
  scalaUuid,
  apacheCommonsCodec % "test",
  scalaTest % "test"
)
