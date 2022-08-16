import bindgen.interface.Binding
import scala.scalanative.build._
import bindgen.interface.Platform
import bindgen.interface.LogLevel

import java.nio.file.Paths

val scribeVersion = "3.10.2"

inThisBuild(
  Seq(
    resolvers += Resolver.sonatypeRepo("snapshots"),
    scalacOptions ++= Seq("-Yexplicit-nulls", "-Xfatal-warnings"),
    scalafmtOnCompile := true,
    scalaVersion := "3.1.3",
    
    libraryDependencies += "com.novocode" % "junit-interface" % Versions.junit % Test,
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v"),
    libraryDependencies += "org.scala-native" %% "junit-runtime_native0.4" % "0.4.5" % Test,
    addCompilerPlugin(
      "org.scala-native" % "junit-plugin" % nativeVersion cross CrossVersion.full
    )
  )
)

// Set to false or remove if you want to show stubs as linking errors

lazy val libgit2 = project
  .in(file("libgit2"))
  .enablePlugins(ScalaNativePlugin, BindgenPlugin)
  .settings(
    scalaVersion := "3.1.1",
    Compile / run / envVars := Map(
      // As we're not installing libgit globally,
      // we're just point binaries to the location of compiled
      // dynamic libraries
      "LD_LIBRARY_PATH" -> (baseDirectory.value / "native" / "build").toString,
      "DYLD_LIBRARY_PATH" -> (baseDirectory.value / "native" / "build").toString
    ),
    // Generate bindings to Tree Sitter's main API
    bindgenBindings := {
      val gitinclude = baseDirectory.value / "native" / "include"

      Seq(
        Binding(
          gitinclude / "git2.h",
          "libgit",
          linkName = Some("git2"),
          cImports = List("git2.h"),
          clangFlags = List(s"-I$gitinclude")
        )
      )
    },
    nativeConfig := {
      val base = baseDirectory.value
      val libFolder = base / "native" / "build"
      val headersFolder = base / "native" / "include"
      val conf = nativeConfig.value 

      conf
        .withLinkingOptions(
          conf.linkingOptions ++ List(
            "-lgit2",
            s"-L$libFolder"
          )
        )
        .withCompileOptions(
          conf.compileOptions ++ List(s"-I$headersFolder")
        )
    },
    libraryDependencies += "com.outr" %%% "scribe" % scribeVersion
  )

lazy val gistrot = project
  .in(file("app"))
  .settings(
    nativeLinkStubs := true,
    nativeConfig ~= {
      _.withLTO(LTO.default)
        .withMode(Mode.debug)
        .withGC(GC.none)
    },
    libraryDependencies += "com.outr" %%% "scribe" % scribeVersion
  )
  .enablePlugins(ScalaNativePlugin)
  .dependsOn(libgit2)
