package lambdas

import lambdas.Display._
import pl.setblack.badlam.{Cardinals, Lambda}

object ExampleFull extends App {
  val aTrue:Lambda = (x) => (y) => x

  val aFalse:Lambda = (x) => (y) => y
  val pred:Lambda = (n) => (f) => (x) => n((g) => (h) => h(g(f)))((u) => x)((u) => u)

  val ifLambda:Lambda = (c) => (t) => (f) => c(t)(f)((x:Lambda) => x)

  val isZero:Lambda = (n) => n((x) => aFalse)(aTrue)

  //begin magical math
  val autocall:Lambda = (x) => x(x)
  val Y:Lambda = (f) => autocall((y) => f((v) => y(y)(v)))
  //end magical math

  val G:Lambda = (r) => (n) =>
    (ifLambda(isZero(n))
    ((x) => Cardinals.ONE)
    ((x) => Cardinals.MULT(n)(r(pred(n))))
      )//end

  val fact = Y(G)
  val a = Cardinals.fromInteger(6)
  println("a ~ " + usingFX.display(a))
  val result = fact(a)
  println("a! ~ " + usingFX.display(result))
  println("a! = " + Cardinals.toInteger(result))
}
