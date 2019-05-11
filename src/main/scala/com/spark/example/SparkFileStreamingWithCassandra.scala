package com.spark.example
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

class SparkFileStreamingWithCassandra {

  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder().master("local").appName("FileStreamingPlusCassandra").getOrCreate()
    val schema = StructType(StructField("name", StringType,true) ::StructField("age", IntegerType,true) ::Nil)

    val dataFrame = sparkSession.readStream.option("sep",",").schema(schema).csv("data")

    val stream = dataFrame.select("name").writeStream.format("console").start()
    stream.awaitTermination()
  }

}
