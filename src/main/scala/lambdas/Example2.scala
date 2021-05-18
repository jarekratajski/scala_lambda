package lambdas

import pl.setblack.badlam.Lambda
import pl.setblack.badlam.analysis.SmartDisplay
import  Display._

object Example2 extends App {

  val aTrue:Lambda = (x) => (y) => x
  println("true ~ " + usingXYZ.display(aTrue))

  val aFalse:Lambda = (x) => (y) => y
  println("false ~ " + usingXYZ.display(aFalse))

  val and:Lambda = (p) => (q) => p(q)(p)
  println("and ~ " + usingXYZ.display(and))
  println("and ~ " + usingPQ.display(and))

  val res1 = and(aTrue)(aTrue)
  println("res1 " + usingXYZ.display(res1))
//
  val res2 = and(aTrue)(aFalse)
  println("res2 " + usingXYZ.display(res2))
}
