package com.stanlong.scala

object printDemo {
    def main(args: Array[String]): Unit = {
        var str = new Array[String](3)
        println(str.mkString(","))

        str(1) = str(1) + 10
        println(str.mkString(","))
    }
}
