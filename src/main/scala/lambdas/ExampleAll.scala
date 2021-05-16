package lambdas

import pl.setblack.badlam.Lambda
import pl.setblack.badlam.analysis.SmartDisplay

object ExampleAll extends App {

  val identity:Lambda = (x) => x
  println(Display.usingXYZ().display(identity))

  val funny:Lambda = (x) => (y) => x
  println(SmartDisplay.web.display(funny))

  val aTrue:Lambda = (x) => (y) => x
  println("true ~ " + SmartDisplay.web.display(aTrue))

  val aFalse:Lambda = (x) => (y) => y
  println("false ~ " + SmartDisplay.web.display(aFalse))

  val and:Lambda = (p) => (q) => p(q)(p)
  println("and ~ " + SmartDisplay.webP.display(and))

  val result1:Lambda = and (aFalse) (aTrue)
  println("resutlt1 ~ " + SmartDisplay.web.display(result1))

  val or:Lambda = (p) => (q) => p(p)(q)
  println("or ~ " + SmartDisplay.webP.display(or))

  val result2:Lambda = or(aFalse) (aTrue)
  println("result2 ~ " + SmartDisplay.web.display(result2))

  val not:Lambda = (p) => (a) => (b) => p(b)(a)
  println("not false ~ " + SmartDisplay.web.display(not(aFalse)))

  println("toJVMBoolean(result2) = " + pl.setblack.badlam.Boolean.toBoolean(result2))

}
