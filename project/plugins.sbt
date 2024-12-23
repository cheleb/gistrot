addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.5.6")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2")

val BindgenVersion =
  sys.env.getOrElse("SN_BINDGEN_VERSION", "0.1.4")

resolvers ++= Resolver.sonatypeOssRepos("snapshots")

addSbtPlugin("com.indoorvivants" % "bindgen-sbt-plugin" % BindgenVersion)
