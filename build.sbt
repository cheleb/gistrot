import bindgen.interface.Binding
import scala.scalanative.build._
import bindgen.interface.LogLevel

import java.nio.file.Paths

val scribeVersion = "3.13.0"

inThisBuild(
  Seq(
    resolvers ++= Resolver.sonatypeOssRepos("snapshots"),
    scalacOptions ++= Seq("-Yexplicit-nulls", "-Xfatal-warnings"),
    scalafmtOnCompile := true,
    scalaVersion := "3.3.1",
    libraryDependencies += "com.novocode" % "junit-interface" % Versions.junit % Test,
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v"),
    libraryDependencies += "org.scala-native" %% "junit-runtime_native0.4" % "0.4.8" % Test,
//    scalacOptions += "-deprecation",
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
    scalaVersion := "3.3.1",
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
        Binding
          .builder(gitinclude / "git2.h", "libgit")
          .withLinkName("git2")
          .withCImports(Seq("git2.h"))
          .withClangFlags(Seq(s"-I$gitinclude"))
          .build
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
        .withMode(Mode.releaseSize)
        .withGC(GC.none)
    },
    libraryDependencies += "com.outr" %%% "scribe" % scribeVersion,
    libraryDependencies += "com.monovore" %%% "decline" % "2.4.1",
    libraryDependencies += "com.lihaoyi" %%% "os-lib" % "0.9.2",
    libraryDependencies += "com.lihaoyi" %%% "fansi" % "0.4.0"
  )
  .enablePlugins(ScalaNativePlugin)
  .dependsOn(libgit2)
