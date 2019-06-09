package io.typechecked
package symbology

import io.typechecked.numerology.ternary
import io.typechecked.numerology.ternary.TNat
import io.typechecked.numerology.binary
import io.typechecked.numerology.binary.BNat

trait Operation2[Op <: OperationName] {
  type Interface
  type Out[_ <: Interface, _ <: Interface, _ <: Interface]
}

object Operation2 {

  type Aux[OpName <: OperationName, Backend, Op[_ <: Backend, _ <: Backend, _ <: Backend]] =
    Operation2[OpName] {
      type Interface = Backend
      type Out = Op[_, _, _]
    }

  // These MUST be def - no idea why, very weird
  implicit def gcdOp: Operation2.Aux[GcdOp, shapeless.Nat, shapeless.ops.nat.GCD.Aux] = null

  // implicit def sumOp: Operation2.Aux[SumOp, shapeless.Nat, shapeless.ops.nat.Sum.Aux] = null
  implicit def sumOp: Operation2.Aux[SumOp, TNat, ternary.Sum.Aux] = null

  implicit def multOp: Operation2.Aux[MultOp, ternary.TNat, ternary.Mult.Aux] = null
  // implicit def multOp: Operation2.Aux[MultOp, binary.BNat, binary.Mult.Aux] = null

}
