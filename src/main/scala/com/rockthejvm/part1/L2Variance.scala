package com.rockthejvm.part1

import scala.annotation.tailrec

object L2Variance extends App {

  // OOP - substitution
  class Animal
  class Dog(name: String) extends Animal {
    def greet: String = s"Hi, my name is $name"
  }

  val loki: Dog = new Dog("Loki")
  val ruby: Dog = new Dog("Ruby")
  // As per substitution, anAnimal will not have access to `greet` method
  // Even though we have assigned it a Dog object
  val anAnimal: Animal = loki

  // Variance is an extension of the substitution model for generic types
  // The variance question for the List type:
  // If we want a Dog to be a subtype of Animal [Dog <: Animal]
  // Then should a List[Dog] be a subtype of a List[Animal]?
  // If the answer is YES, then the List data type should be COVARIANT
  // The below statements works because the List data type is COVARIANT
  val dogList: List[Dog] = List(loki, ruby)
  val animalList: List[Animal] = dogList
  dogList.foreach(dog => println(dog.greet))

  // Our simple custom Covariant list
  class MyList[+A]
  val myAnimalList: MyList[Animal] = MyList[Dog]
}
