package io.typechecked
package symbology

sealed trait OperationName

trait SumOp extends OperationName
trait MultOp extends OperationName
trait GcdOp extends OperationName
