package macroExamples

@main def main =
    println("2^6 = " + power(2,6))
    
inline def power(inline x: Double, inline n: Int) =
  ${ powerCode('x, 'n)  }
