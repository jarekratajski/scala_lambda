package lambdas

import lambdas.Display._
import pl.setblack.badlam.{Cardinals, Lambda}

object Example3 extends App {
  val zero:Lambda = (f) => (x) => x
  println("0 ~ " + usingFX.display(zero))
  val one:Lambda = (f) => (x) => f(x)
  println("1 ~ " + usingFX.display(one))
  val two:Lambda = (f) => (x) => f(f(x))
  println("2 ~ " + usingFX.display(two))

  val plus:Lambda = (m) => (n) => (f) => (x) => m(f)(n(f)(x))
  println("plus ~ " + usingMN.display(plus))

  val a:Lambda =(f) => (x) => f(f(f(x)))
  val b:Lambda =(f) => (x) => f(f(f(f(x))))
  println("a ~ " + usingFX.display(a))
  println("b ~ " + usingFX.display(b))
  println("plus a b ~ " + usingFX.display(plus(a)(b)))
}
