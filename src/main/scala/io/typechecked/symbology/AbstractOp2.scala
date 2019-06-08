package io.typechecked
package symbology

import io.typechecked.numerology.ternary
import io.typechecked.numerology.ternary.TNat
import io.typechecked.numerology.binary
import io.typechecked.numerology.binary.BNat

trait AbstractOp2[Op <: OperationName] {
  type Interface
  type Out[_ <: Interface, _ <: Interface, _ <: Interface]
}

object AbstractOp2 {

  type Aux[OpName <: OperationName, Backend, Op[_ <: Backend, _ <: Backend, _ <: Backend]] =
    AbstractOp2[OpName] {
      type Interface = Backend
      type Out = Op[_, _, _]
    }

  // These MUST be def - no idea why, very weird
  implicit def sumOp: AbstractOp2.Aux[SumOp, TNat, ternary.Sum.Aux] = null
  implicit def gcdOp: AbstractOp2.Aux[GcdOp, shapeless.Nat, shapeless.ops.nat.GCD.Aux] = null
  implicit def multOp: AbstractOp2.Aux[MultOp, binary.BNat, binary.Mult.Aux] = null

}
