organization := "com.jm2dev"

name := "Sensor"

version := "1.0"
                           
scalaVersion := "2.10.0-RC3"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10.0-RC2" % "2.0.M5" % "test"
)

resolvers ++= Seq(
          "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
)
