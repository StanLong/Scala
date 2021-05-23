package com.stanlong.scala

/**
 * List
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        // 在scala中List默认为不可变的集合
        // 如果需要使用可变List， 则使用ListBuffer
        val list01 = List(1, 2, 3) //创建时，直接分配元素 List 中可以放任何数据类型
        println(list01)
        val list02 = Nil  //空集合
        println(list02)

    }
}
