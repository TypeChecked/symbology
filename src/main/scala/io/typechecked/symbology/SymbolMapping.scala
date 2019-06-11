package io.typechecked
package symbology

// Mapping from a symbol to a backend Nat implementation
trait SymbolMapping[Backend, S <: Symbol] { type Out <: Backend }

object SymbolMapping {

  type Aux[Backend, S <: Symbol, Out0 <: Backend] = SymbolMapping[Backend, S] { type Out = Out0 }

  trait Implementation[Backend, S <: Symbol, B <: Backend] extends SymbolMapping[Backend, S] { type Out = B }

}
