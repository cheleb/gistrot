addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.5.11")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.6.0")

val BindgenVersion =
  sys.env.getOrElse("SN_BINDGEN_VERSION", "0.2.4")

resolvers ++= Resolver.sonatypeOssRepos("snapshots")

addSbtPlugin("com.indoorvivants" % "bindgen-sbt-plugin" % BindgenVersion)
