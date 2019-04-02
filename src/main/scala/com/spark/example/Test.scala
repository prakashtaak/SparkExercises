package com.spark.example

object Test {
def main(args: Array[String]): Unit = {

  type SomeType = (Int,String) => String

  def display(x:SomeType,s :Int,v:String) = x(s,v)

  def someFun :SomeType ={
    (a,y) => {
      a + y
    }
  }
  print(display(someFun,3,"vas"))
}
}
