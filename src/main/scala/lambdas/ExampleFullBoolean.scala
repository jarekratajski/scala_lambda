package lambdas

import lambdas.Display._
import pl.setblack.badlam.Lambda

object ExampleFullBoolean extends App {

  val aTrue:Lambda = (x) => (y) => x
  println("true ~ " + usingXYZ.display(aTrue))

  val aFalse:Lambda = (x) => (y) => y
  println("false ~ " + usingXYZ.display(aFalse))

  val and:Lambda = (p) => (q) => p(q)(p)
  println("and ~ " + usingXYZ.display(and))
  println("and ~ " + usingPQ.display(and))

  val or:Lambda = (p) => (q) => p(p)(q)

  val not:Lambda = (p) => (a) => (b) => p(b)(a)

  val left:Lambda = (p) => (q) => not(and(p)(q))
  val right:Lambda = (p) => (q) => or(not(p))(not(q))
  val l1 = left(aTrue)(aFalse)
  val r1 = right(aTrue)(aFalse)

  val booleans  = Set(aTrue,aFalse)
  val results = for {p <-  booleans
                                            q <- booleans}
    yield (left(p)(q), right(p)(q))
  results.foreach( r => {
    print(usingXYZ.display(r._1))
    print("  ")
    println(usingXYZ.display(r._2))
  })

}
