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
  println("\nf symbol: " + f.asTerm.symbol)
  println("\nref symbol: " + ref.asTerm.symbol)

  /*
  f match {
    case '{ (x: scala.Int => y) } => println(y.show)
  }
  */

  // println("\nf symbol owner: " + f.asTerm.symbol.ownner) // Error: NoDenotation.owner

  val refId: Ident = ref.asTerm match {
    case Inlined(_, _, id@Ident(_)) => id
  }
  println("\nref ident: " + refId)
  println("\nref ident tree: " + refId.show(using Printer.TreeStructure))

  /*
  // NOT AVAILABLE FOR Expr[Int => Int]
  val fValue = f.value
  println("\f value: " + refValue)

  val refValue = ref.value
  println("\nref value: " + refValue)
  */

  /*
  val fTpe = f.asTerm.tpe
  println("\nf tpe: " + fTpe)
  println("\nf tpe symbol: " + fTpe.typeSymbol)

  val refTpe = ref.asTerm.tpe
  println("\nref tpe: " + refTpe)
  println("\nref tpe symbol: " + refTpe.typeSymbol)
  */

  ref
