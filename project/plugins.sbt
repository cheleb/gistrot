addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.5.8")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.5")

val BindgenVersion =
  sys.env.getOrElse("SN_BINDGEN_VERSION", "0.2.3")

resolvers ++= Resolver.sonatypeOssRepos("snapshots")

addSbtPlugin("com.indoorvivants" % "bindgen-sbt-plugin" % BindgenVersion)
