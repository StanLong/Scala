package com.stanlong.scala

import scala.collection.mutable.ListBuffer

/**
 * 可变列表
 */
object HelloScala {

    def main(args: Array[String]): Unit = {
        // 创建可变列表
        val list0 = ListBuffer[Int](1, 2, 3)
        val list1 = ListBuffer(12,23,45)

        println(list0)
        println(list1)

        // 添加元素
        list0.append(5) // 在后面添加
        list0.prepend(0) // 在前面添加
        list0.insert(2,300) // 指定位置添加

        // 合并列表
        val list2 = list0 ++ list1
        println(list0) // 不变
        println(list1) // 不变
        println(list2) // 合并

        list0 ++= list1 // 如果是 ++=: 那结果就是 list0 不变, list1 合并
        println(list1) // 不变
        println(list0) // 合并

        // 修改元素
        list1(0) = 0
        list1.update(2, 20)
        println(list1)

        // 删除
        list1.remove(1)
        list1 -= 45
        println(list1)
    }
}

