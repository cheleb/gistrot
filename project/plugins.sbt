addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.4.12")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.0")

val BindgenVersion =
  sys.env.getOrElse("SN_BINDGEN_VERSION", "0.0.17")

resolvers ++= Resolver.sonatypeOssRepos("snapshots")

addSbtPlugin("com.indoorvivants" % "bindgen-sbt-plugin" % BindgenVersion)
