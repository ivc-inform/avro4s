import com.typesafe.sbt.SbtGit.git
import sbt.{Credentials, Path}

name := "avro4s"

lazy val root = (project in file("."))
  .enablePlugins(GitVersioning)
  .aggregate(avro4sMacros, avro4sCore, avro4sJson)
  .settings(
      inThisBuild(Seq(
          scalaVersion := CommonSettings.settingValues.scalaVersion,
          git.baseVersion := CommonSettings.settingValues.baseVersion,
          publishTo := {
              val corporateRepo = "http://toucan.simplesys.lan/"
              if (isSnapshot.value)
                  Some("snapshots" at corporateRepo + "artifactory/libs-snapshot-local")
              else
                  Some("releases" at corporateRepo + "artifactory/libs-release-local")
          },
          credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
      ) ++ CommonSettings.defaultSettings),
      publishArtifact in(Compile, packageBin) := false,
      publishArtifact in(Compile, packageDoc) := false,
      publishArtifact in(Compile, packageSrc) := false
  )


lazy val avro4sMacros = Project(id = "avro4s-macros", base = file("avro4s-macros"))
  .dependsOn()
  .settings(
      libraryDependencies ++= Seq(
          CommonDeps.shapeless,
          CommonDeps.scalaReflect.value,
          CommonDeps.avro,
          CommonDeps.scalaTest
      )
  )

lazy val avro4sCore = Project(id = "avro4s-core", base = file("avro4s-core"))
  .dependsOn(avro4sMacros)
  .settings(
      libraryDependencies ++= Seq(
          CommonDeps.scalaReflect.value,
          CommonDeps.avro,
          CommonDeps.scalaTest
      )
  )

lazy val avro4sJson = Project(id = "avro4s-json", base = file("avro4s-json"))
  .dependsOn(avro4sCore)
  .settings(
      libraryDependencies ++= Seq(
          CommonDeps.json4sNative,
          CommonDeps.scalaTest
      )
  )

