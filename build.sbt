import scala.scalanative.build._
import bindgen.interface.Platform
import bindgen.interface.LogLevel

import java.nio.file.Paths

inThisBuild(
  Seq(
    scalacOptions ++= Seq("-Yexplicit-nulls", "-Xfatal-warnings"),
    scalafmtOnCompile := true
  )
)
scalaVersion := "3.1.1"

// Set to false or remove if you want to show stubs as linking errors
nativeLinkStubs := true


nativeConfig ~= {
  _.withLTO(LTO.default)
    .withMode(Mode.debug)
    .withGC(GC.none)
}

enablePlugins(ScalaNativePlugin)


lazy val libgit2 = project
  .in(file("libgit2"))
  .enablePlugins(ScalaNativePlugin, BindgenPlugin)
  .settings(
    scalaVersion := "3.1.1",
    Compile / run / envVars := Map(
      // As we're not installing libgit globally,
      // we're just point binaries to the location of compiled
      // dynamic libraries
      "LD_LIBRARY_PATH" -> (baseDirectory.value  / "build").toString,
      "DYLD_LIBRARY_PATH" -> (baseDirectory.value / "build").toString
    ),
    // Generate bindings to Tree Sitter's main API
    Bindgen.bindings := { builder =>
      val gitinclude = baseDirectory.value / "include"

      builder.define(
        gitinclude / "git2.h",
        "libgit",
        linkName = Some("git2"),
        cImports = List("git2.h"),
        clangFlags = List(s"-I$gitinclude")
      )
    },
    nativeConfig := {
      val base = baseDirectory.value
      val libFolder = base / "build"
      val headersFolder = base / "include"
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
    }
  )
