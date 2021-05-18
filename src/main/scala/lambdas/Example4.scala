package lambdas

import lambdas.Display._
import pl.setblack.badlam.{Cardinals, Lambda}

object Example4 extends App {
  val one:Lambda = (f) => (x) => f(x)

  val aTrue:Lambda = (x) => (y) => x

  val aFalse:Lambda = (x) => (y) => y
  val pred:Lambda = (n) => (f) => (x) => n((g) => (h) => h(g(f)))((u) => x)((u) => u)

  val ifLambda:Lambda = (c) => (t) => (f) => c(t)(f)((x:Lambda) => x)

  val isZero:Lambda = (n) => n((x) => aFalse)(aTrue)

  val mult:Lambda = (m) => (n) => (f) => m(n(f))

  val autocall:Lambda = (x) => x(x)
  val Y:Lambda = (f) => autocall((y) => f((v) => y(y)(v)))


  val G:Lambda = (r) => (n) =>
    (ifLambda(isZero(n))
    ((x) => one)
    ((x) => mult(n)(r(pred(n))))
      )

  val fact = Y(G)
  val a:Lambda = (f) => (x) => f(f(f(f(f(f(x))))))
  println("a ~ " + usingFX.display(a))
  val result = fact(a)
  println("a! ~ " + usingFX.display(result))
  println("a! = " + Cardinals.toInteger(result))
}
