@main def hello: Unit = 
  // The following will print `scala.Predef.println("Hello macros!")` during compilation (e.g., with `sbt run`)
  // And then will just return the expression, that will be evaluated
  inspect(println("Hello macros!"))

inline def inspect(inline x: Any): Any = ${ inspectCode('x) }
