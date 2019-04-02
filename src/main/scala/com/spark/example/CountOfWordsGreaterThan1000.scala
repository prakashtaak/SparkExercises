package com.spark.example
import org.apache.spark.sql.types.{ArrayType, StringType, StructType}
import org.apache.spark.sql.{Encoder, Encoders, Row, SparkSession}

import scala.collection.mutable

object CountOfWordsGreaterThan1000 {

  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession
      .builder()
      .appName("countOfWordsGreaterThan100")
      .master("local[4]")
      .getOrCreate()

    val columnData =
      sparkSession.read.textFile("resources\\sampleWords.txt")
  import sparkSession.implicits._
/*   val result = columnData.rdd
      .flatMap(_.split(" "))
      .map(x => (x, 1))
      .reduceByKey(_ + _)
      .filter(_._2 > 10)
      .flatMap(_._1.toCharArray)
       .map( (_,1)).reduceByKey(_+_).take(10)

    result.foreach(x => println(s"word : ${x._1} count : ${x._2}"))

  val data = columnData.rdd.flatMap(x => x.split(" "))
    .map(x => (x,1))
    .aggregateByKey(mutable.HashSet.empty[Int])((a: mutable.HashSet[Int],b:Int) => a += b,(s1:mutable.HashSet[Int],s2:mutable.HashSet[Int]) => s1++=s2)
    data.foreach(println(_))*/
    val setOfNumbers = (0 to 100).toList.toDF("num")
    val rdd= setOfNumbers.rdd
    rdd.partitions.foreach(x => println(x))

    val newRdd = rdd.repartition(2)

    newRdd.partitions.foreach(println(_))

    /*val words = columnData.flatMap(x => x.split(" ")).filter(_ != "").toDF("word")
    words.printSchema()*/
    /*words.createTempView("WordCount")
    sparkSession
      .sql(
        "select value,count(1) as ct from WordCount group by value having ct > 10 "
      )
      .show*/

  /*  implicit val charsImp = Encoders.javaSerialization(classOf[Char])
  val chars=   words.groupBy("word").count().as("count").filter("count > 10").select("word")
*/

    /*implicit def kryoEncoder[A](implicit ct: ClassTag[A]) =
    org.apache.spark.sql.Encoders.kryo[A](ct)
    val singersDF = Seq(
      ("beatles", "help|hey jude"),
      ("romeo", "eres mia")
    )

    case class Record(id:Int,value : String)

   val sampleDt = (1 to 100).map(i => Record(i, s"val_$i")).toDF()

   case class Person(name: String, age: Long)

    // Encoders are created for case classes
    val caseClassDS = Seq(Person("Andy", 32)).toDS()
    caseClassDS.show()


*/
  }
}
