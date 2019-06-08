package io.typechecked
package symbology

trait ReverseLookup[Backend, N <: Backend] { type Out <: Symbol }

object ReverseLookup {
  type Aux[Backend, N <: Backend, Out0 <: Symbol] = ReverseLookup[Backend, N] { type Out = Out0 }

  implicit def reverseLookup[Backend, S <: Symbol, T <: Backend](
    implicit m: SymbolMapping.Aux[Backend, S, T]
  ): ReverseLookup.Aux[Backend, T, S] = null

}
