package io.typechecked
package symbology

trait ReverseSymbolLookup[Backend, N <: Backend] { type Out <: Symbol }

object ReverseSymbolLookup {
  type Aux[Backend, N <: Backend, Out0 <: Symbol] = ReverseSymbolLookup[Backend, N] { type Out = Out0 }

  implicit def reverseLookup[Backend, S <: Symbol, T <: Backend](
    implicit m: SymbolMapping.Aux[Backend, S, T]
  ): ReverseSymbolLookup.Aux[Backend, T, S] = null

}
