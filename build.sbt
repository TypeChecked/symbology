
resolvers ++= Seq (
  "Maven Central Server" at "http://repo1.maven.org/maven2",
  "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype OSS Releases"  at "http://oss.sonatype.org/content/repositories/releases/",
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
)

lazy val Benchmark = config("bench").extend(Compile)

lazy val commonSettings = Seq(
  name := "symbology",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.13.0-M3",
  organization := "io.typechecked",

  libraryDependencies ++= Seq(
    "com.chuusai" %% "shapeless" % "2.3.3",
    "io.typechecked" %% "numerology" % "0.1.0-SNAPSHOT",
  ),

)

lazy val symbology = project.in(file(".")).settings(
  name := "symbology",
  commonSettings,
)
