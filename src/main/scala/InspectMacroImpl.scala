import scala.quoted._

def inspectCode(x: Expr[Any])(using Quotes): Expr[Any] =
  println(x.show)
  x
