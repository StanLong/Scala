package com.stanlong.scala

import scala.io.StdIn

/**
 * 异常注解
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        print("请输入金字塔的层级:")
        var num = StdIn.readInt()
        for(i <- 1 to num){
            println(" " * (num-i) + "*" * ((2 * i)-1))
        }
    }
}
