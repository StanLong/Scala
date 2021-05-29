package com.stanlong.scala

/**
 * 高阶函数
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val list = List(3,5,7)
        // list.map 的执行过程
        // 将list集合中的元素依次遍历
        // 将遍历出的元素传递给multiple函数， 并将得到的返回值放入一个新的集合
        val list2 = list.map(multiple)
        println(list2)
    }

    def multiple(n:Int):Int={
        2 * n
    }
}
