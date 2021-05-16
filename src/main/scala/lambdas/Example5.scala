package lambdas

import lambdas.Display._
import pl.setblack.badlam.Lambda

object Example5 extends App {

  val autocall:Lambda = (x) => x(x)
  val OMEGA = autocall(autocall)

}
