package sketch

@main def helloSketch: Unit = 
  val input = 4
  println(s"Triple of ${input} is  " + triple()(input))

def tripleSketch(x: Int) = { // sketch
  val h: Int = ???
  h * x
}

val tripleRefImpl = (x: Int) => x+x+x // reference impl

inline def triple(): Int => Int = ${ sketch('tripleSketch, 'tripleRefImpl) }
