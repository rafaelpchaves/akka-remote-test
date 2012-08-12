import AssemblyKeys._

organization := "thesmith.akka"

name := "akka-remoting-test"

version := "1.0"

scalaVersion := "2.9.1"

seq(assemblySettings: _*)

jarName in assembly := "remote-test.jar"

test in assembly := {}

mainClass in (Compile, packageBin) := Some("thesmith.akka.App")

mainClass in (Compile, run) := Some("thesmith.akka.App")

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor" % "2.0.2",
  "com.typesafe.akka" % "akka-kernel" % "2.0.2",
  "com.typesafe.akka" % "akka-remote" % "2.0.2"
)
  
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Scala-Tools Maven2 Releases Repository" at "http://scala-tools.org/repo-releases"
