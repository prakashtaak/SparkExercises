package com.spark.example
import org.apache.spark.sql.SparkSession

object DataFrameExample {
def main(args: Array[String]): Unit = {



  System.setProperty("hadoop.home.dir", "C:\\Installations\\hadoop")
  val spark = SparkSession.builder().getOrCreate()
  val txtFileDataSet = spark.read.textFile("resources\\sampleWords.txt")
  import spark.implicits._

  val words = txtFileDataSet.flatMap(x => x.split(" ")).filter(_ != "")
  val groupOfWords = words.map(x => (x,x.size)).repartition(4).toDF("id","size")

  import org.apache.spark.sql.functions._

  val groupsIwithTHeSize = groupOfWords.groupBy('id).agg(max(struct('size)) as 'maxSize).select($"id",$"maxSize")
  groupOfWords.foreach(x => print(s"id ${x.get(0)} maxSize ${x.get(1)}"))

  spark.stop()
}
}
