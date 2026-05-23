addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.5.12")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.6.1")

val BindgenVersion =
  sys.env.getOrElse("SN_BINDGEN_VERSION", "0.4.4")

resolvers ++= Resolver.sonatypeOssRepos("snapshots")

addSbtPlugin("com.indoorvivants" % "bindgen-sbt-plugin" % BindgenVersion)
