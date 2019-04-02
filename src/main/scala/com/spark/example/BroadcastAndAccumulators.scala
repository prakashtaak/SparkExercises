package com.spark.example
import org.apache.spark.{SparkConf, SparkContext}

object BroadcastAndAccumulators {
def main(args: Array[String]): Unit = {
  val sconfig =new  SparkConf().setAppName("accumulators").setMaster("local[4]")
  val sc = new SparkContext(sconfig)

  val lonfAcculutator = sc.longAccumulator("mylongCounter")

   sc.parallelize(0 to 3).foreach(x => lonfAcculutator.add(x))

  println(lonfAcculutator.value)

}
}
