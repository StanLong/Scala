package com.stanlong.scala

import scala.collection.mutable.ArrayBuffer

/**
 * 递归
 * 递归求阶乘
 */
object Exercise01 {
    def main(args: Array[String]): Unit ={
        val test = ArrayBuffer("1", "2", "3")
        test(0) = "100"
        println(test(0))
    }
}