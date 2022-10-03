package sketch

import scala.quoted._

def sketch(f: Expr[Int=>Int], ref: Expr[Int=>Int])(using Quotes): Expr[Int=>Int] =
  // This would need to
  // 1. Extract holes from `f`
  // 2. Encode `f` and `ref` into an SMT module
  // 3. Run the SMT module to get assignments for holes in `f`
  // 4. Substitue holes in `f` with the assignment
  import quotes.reflect._
  // How to get a tree of the body of `f`?
  // val tpe: TypeRepr = TypeRepr.of[Int => Int]
  println(s"Repr for f:\n" + f.show +  "\n\nRepr for ref:\n " + ref.show)
  println("\nf as term: " + f.asTerm)
  println("\nref as term: " + ref.asTerm)
  println("\nf tree: " + f.asTerm.show(using Printer.TreeStructure))
  println("\nref tree: " + ref.asTerm.show(using Printer.TreeStructure))

  ref
