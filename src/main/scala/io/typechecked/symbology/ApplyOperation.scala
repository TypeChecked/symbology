package io.typechecked
package symbology

// Application of an Operation2
// Typelevel equivalent of telling the JVM to apply a Function2 to two arguments
// Therefore it takes a name, and two arguments
trait ApplyOperation[Op <: OperationName, S1 <: Symbol, S2 <: Symbol] { type Out <: Symbol }

object ApplyOperation {

  type Aux[Op <: OperationName, S1 <: Symbol, S2 <: Symbol, Out0 <: Symbol] =
    ApplyOperation[Op, S1, S2] { type Out = Out0 }

  implicit def performOperation[
    Op <: OperationName,
    Backend,
    OpImpl[_ <: Backend, _ <: Backend, _ <: Backend],
    S1 <: Symbol,
    S2 <: Symbol,
    N1 <: Backend,
    N2 <: Backend,
    N <: Backend,
    Out <: Symbol
  ](implicit
    opImpl: Operation2.Aux[Op, Backend, OpImpl],
    n1: SymbolMapping.Aux[Backend, S1, N1],
    n2: SymbolMapping.Aux[Backend, S2, N2],
    res: OpImpl[N1, N2, N],
    s: ReverseSymbolLookup.Aux[Backend, N, Out],
  ): ApplyOperation.Aux[Op, S1, S2, Out] = null

}
