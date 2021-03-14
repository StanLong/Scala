package com.stanlong.scala

import scala.io.StdIn

/**
 * 从控制台接收信息
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        println("请输入姓名: ")
        val name = StdIn.readLine()
        print("请输入年龄: ")
        val age = StdIn.readInt()
        print("请输入薪资: ")
        val salary = StdIn.readDouble()
        printf("姓名%s, 年龄%d, 薪资%f", name, age, salary)

    }
}
