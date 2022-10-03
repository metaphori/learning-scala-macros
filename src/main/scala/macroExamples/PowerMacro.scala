package macroExamples

import scala.quoted._

def powerCode(
  x: Expr[Double],
  n: Expr[Int]
)(using Quotes): Expr[Double] =
  val value: Double = pow(x.valueOrError, n.valueOrError)
  Expr(value)
  
def pow(x: Double, n: Int): Double =
  if n == 0 then 1 else x * pow(x, n - 1)
