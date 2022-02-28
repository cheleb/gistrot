
inThisBuild(
  Seq(
    scalacOptions ++= Seq("-Yexplicit-nulls", "-Xfatal-warnings"),
    scalafmtOnCompile := true
  )
)
scalaVersion := "3.1.1"

// Set to false or remove if you want to show stubs as linking errors
nativeLinkStubs := true

enablePlugins(ScalaNativePlugin)
