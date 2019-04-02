package com.spark.example
import org.apache.spark.sql.SparkSession

object DFCsv {
def main(args: Array[String]): Unit = {


  //System.setProperty("hadoop.home.dir", "C:\\Installations\\hadoop")
  val sc = SparkSession.builder().master("local").appName("my-app").getOrCreate()
  val csvFile = sc.read.option("header",true).option("charset","UTF8").option("delimiter",",").option("inferSchema", "true")
    .csv("resources\\businesses_plus.csv").
    select("business_id","name","owner_city","owner_zip","owner_state").
    where("owner_zip > 90000").where("owner_zip < 91000")

  //stores data in buckets with specified format in specified order
 // csvFile.write.bucketBy(5,"owner_zip").saveAsTable("bucketTable")

 // csvFile.write.partitionBy("owner_zip").saveAsTable("bucketPartTable")
  val sqlSc = sc.sql("select *from bucketTable")
  sqlSc.show()
  //csvFile.show()
}
}
