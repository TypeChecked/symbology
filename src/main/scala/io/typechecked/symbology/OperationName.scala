package io.typechecked
package symbology

// Names of operations, equivalent of function names in the JVM
// Here `trait Foo extends OperationName` is the same as `def Foo` (implementation to be attached elsewhere)
sealed trait OperationName

trait SumOp extends OperationName
trait MultOp extends OperationName
trait GcdOp extends OperationName
