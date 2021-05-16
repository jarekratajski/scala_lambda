package lambdas

import pl.setblack.badlam.analysis.SmartDisplay

object Display {
  def usingXYZ() = SmartDisplay.get().withLambdaSymbol("λ")

  def usingNF() = SmartDisplay.get().withLambdaSymbol("λ").withSymbols(SmartDisplay.NF)

  def usingFX() = SmartDisplay.get().withLambdaSymbol("λ").withSymbols(SmartDisplay.FXY)

  def usingPQ() = SmartDisplay.get().withLambdaSymbol("λ").withSymbols(SmartDisplay.PQ)

  def usingMN() = SmartDisplay.get().withLambdaSymbol("λ").withSymbols(SmartDisplay.MNF)
}
