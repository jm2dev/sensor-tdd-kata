import sbt._
import Keys._

object SensorBuild extends Build
{
  lazy val root =
    Project("root", file("."))
      .configs( IntegrationTest )
      .settings( Defaults.itSettings : _*)
      .settings( libraryDependencies += specs )

  lazy val specs ="org.scalatest" % "scalatest_2.10.0-RC2" % "2.0.M5" % "it"
}
