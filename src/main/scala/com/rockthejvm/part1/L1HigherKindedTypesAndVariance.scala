package com.rockthejvm.part1

object L1HigherKindedTypesAndVariance extends App {

  // Higher kinded types
  trait HigherKindedType[F[_]]

  trait SequenceChecker[F[_]] {
    def isSequential: Boolean
  }

  val listChecker = new SequenceChecker[List] {
    override def isSequential: Boolean = true
  }
}
