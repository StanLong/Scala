package com.stanlong.scala

import scala.util.control.Breaks.{break, breakable}

/**
 * 循环中断
 * breakable 是一个高阶函数：可以接收函数作为参数的函数
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        var n = 10
        breakable{
            while (n < 20){
                n = n+1
                if(n==18){
                    break()
                }
                println(n)
            }
        }
    }
}
