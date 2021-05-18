package lambdas

import pl.setblack.badlam.Lambda
import pl.setblack.badlam.analysis.SmartDisplay

object Example1 extends App {

  val identity:Lambda = (x) => x
  println(identity)
  val other = identity(identity)
  println(other)

  println(Display.usingXYZ().display(identity))
  println(Display.usingXYZ().display(other))
}
