addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.4.3")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.3")


val BindgenVersion =
  sys.env.getOrElse("SN_BINDGEN_VERSION", "0.0.6+9-6e023df9-SNAPSHOT")

resolvers += Resolver.sonatypeRepo("snapshots")

addSbtPlugin("com.indoorvivants" % "bindgen-sbt-plugin" % BindgenVersion)
