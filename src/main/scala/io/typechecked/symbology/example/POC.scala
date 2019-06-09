package io.typechecked
package symbology
package example


trait Plus20Times3[A <: Symbol] { type Out <: Symbol }

object Plus20Times3 {
  type Aux[A <: Symbol, Out0 <: Symbol] = Plus20Times3[A] { type Out = Out0 }

  implicit def instance[
    A <: Symbol,
    GcdOut <: Symbol,
    SumOut <: Symbol,
    MultOut <: Symbol
  ](implicit
    sum: ApplyOperation.Aux[SumOp, A, Symbol._20, SumOut],
    mult: ApplyOperation.Aux[MultOp, SumOut, Symbol._3, MultOut],
  ): Plus20Times3.Aux[A, MultOut] = null

}


object POC {

  import AllMappings._
  import Symbol._

  def foo[A <: Symbol](implicit ev: Plus20Times3[A]): ev.Out = ???

  foo[_22]: _126

}
