package com.spark.example
import scala.reflect.runtime.{universe => ru}
object ScalaTest {
def main(args: Array[String]): Unit = {

  val ob1= new C{ type  t= String
  }
  val ob2= new D{ type t =String}

  println(ob1.getClass.isAssignableFrom(ob2.getClass))

  //lets use scala runtime reflection

  println(checkAssinableForm(ob1,ob2))

}
def checkAssinableForm[T : ru.TypeTag,U: ru.TypeTag](a :T,b:U) ={
  val typeA = ru.typeTag[T]
  val typeB = ru.typeTag[U]

   typeB.tpe <:< typeA.tpe
}

}

class A {
  type T
  val x:Option[T] =None
}
class B extends A
class C extends B
class D extends C

