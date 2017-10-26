object CommonSettings {
    object settingValues {
        val scalaVersion = "2.12.4"
        val organization = "com.sksamuel.avro4s"
        val baseVersion = "1.8.2"

        val scalacOptions = Seq(
            "-feature",
            "-language:higherKinds",
            "-language:implicitConversions",
            "-language:existentials",
            "-language:postfixOps",
            "-deprecation",
            "-unchecked")
    }

    val defaultSettings = {
        import sbt.Keys._
        Seq(
            scalacOptions := settingValues.scalacOptions,
            organization := settingValues.organization
        )
    }
}
