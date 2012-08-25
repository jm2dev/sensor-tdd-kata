resolvers ++= Seq (
    "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"
)

addSbtPlugin("org.ensime" % "ensime-sbt-cmd" % "0.0.10")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.0.0")
