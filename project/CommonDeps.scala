import sbt.Keys._
import sbt._

object PluginDeps {

    val jsuereth = addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.0")
    val sbtRelease = addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.6")
    val coursier = addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC12")
}

object CommonDeps {
    val scalaTestVersion = "3.0.4"
    val AvroVersion = "1.8.2"
    val ScalatestVersion = "3.0.4"
    val ScalaVersion = "2.12.4"
    val Slf4jVersion = "1.7.25"
    val Log4jVersion = "1.2.17"

    val shapeless = "com.chuusai" %% "shapeless" % "2.3.2"
    val scalaReflect = Def.setting("org.scala-lang" % "scala-reflect" % scalaVersion.value)
    val avro = "org.apache.avro" % "avro" % AvroVersion

    val json4sNative = "org.json4s" %% "json4s-native" % "3.5.3"
    val slf4jApi = "org.slf4j" % "slf4j-api" % Slf4jVersion
    val log4j = "log4j" % "log4j" % Log4jVersion % Test
    val log4jOver = "org.slf4j" % "log4j-over-slf4j" % Slf4jVersion % Test
    val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % Test
}
