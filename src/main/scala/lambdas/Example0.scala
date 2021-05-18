package lambdas

trait Lambda {
  def apply(x:Lambda) : Lambda
}
