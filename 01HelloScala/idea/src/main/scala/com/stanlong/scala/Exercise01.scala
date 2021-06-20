package com.stanlong.scala

/**
 * 递归
 * 递归求阶乘
 */
object Exercise01 {
    def main(args: Array[String]): Unit ={
        println(factorial(4))
    }

    // 递归求阶乘
    def factorial(n: Int): Int =
        if (n == 0) 1 else n * factorial(n - 1)

}