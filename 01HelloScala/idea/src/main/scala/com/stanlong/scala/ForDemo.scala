package com.stanlong.scala

/**
 * 数组复制
 */
object ForDemo {


    def main(args: Array[String]): Unit = {
        val a = Array('a', 'b', 'c')
        val b:Array[Char] = new Array(5)
        a.copyToArray(b)
        println(b.mkString(","))
        a.copyToArray(b,1)
        println(b.mkString(","))
        a.copyToArray(b,1,2)
        println(b.mkString(","))
    }


}
