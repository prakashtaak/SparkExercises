package com.spark.example
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{SQLContext, SparkSession}

object ScalaMain {
  System.setProperty("hadoop.home.dir", "C:\\Installations\\hadoop")
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("my-app")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val txtFileDataSet = sc.textFile("resources\\sampleWords.txt")

    val result1 = txtFileDataSet.map(x => x.contains("a")).count()

    //val result1 =txtFileDataSet.map(x => x.contains("b")).count()
    //println(s"result1 is ${result} and result2 is ${result1}")
    val result = txtFileDataSet
      .flatMap(x => x.split(" "))
      .filter(_ != "")
      .map(x => (x, 1))
      .reduceByKey((a, b) => a + b, 4)

    result.foreach(x => println(s"${x}"))

    val listOfData = Array("foo=A", "foo=A", "hot=C")
    val listOfData2 = Array("foo=A", "bar=A", "bar=B")

    //mapPartition is called once per partition, main advant. is we can do initialization  on per partition bases instead of
    // per element bases(as done by map() and foreach())
    val rdd1 = sc
      .parallelize(listOfData)
      .mapPartitions(x => {
        println("Called in Partition ")
        val temp = x.toList.map(y => y.split("="))
        temp.map(y => (y(0), y(1))).iterator
      }, false)

    val rdd2 =
      sc.parallelize(listOfData2).map(x => x.split("=")).map(y => (y(0), y(1)))

    rdd1.join(rdd2).collect.foreach(println(_))
    //rdd1.reduceByKey(_ + _).take(5).foreach(println(_))

  }
}
case class Person(str: String, age: Int) {
  /*override def toString= {
   s"name  ${str} | age ${age} "
  }*/
}
