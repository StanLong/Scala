package com.stanlong.scala

import scala.collection.mutable

/**
 * 元组
 * 可以存放各种相同或不同类型的数据
 * 元组中最大只能有22个元素
 */
object HelloScala {

    def main(args: Array[String]): Unit = {

        // 创建
        val tuple1 = (1, 2, 3, "hello", 4, true)
        println(tuple1)

        // 访问
        println(tuple1._1) //访问元组的第 _x 个元素
        println(tuple1._2)
        println(tuple1._3)
        println(tuple1.productElement(0)) // 按索引范围，从0开始

        // 遍历
        for ( item <- tuple1.productIterator ) {
            println(item)
        }

        // 嵌套
        val tuple2 = (1, 2, 3, "hello", 4, true, (1, 2, 3, "hello", 4, true))
        println(tuple2._7._6)
    }
}

