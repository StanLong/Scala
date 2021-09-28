package com.stanlong.scala

import scala.collection.mutable.ArrayBuffer

/**
 * 可变数组
 */
object HelloScala {

    def main(args: Array[String]): Unit = {
        // 创建可变数组
        val arr01 = ArrayBuffer[Int]()
        val arr02 = ArrayBuffer(1,2,3,4)
        println(arr02) // ArrayBuffer(1, 2, 3, 4) 底层调用的是 arr02.toString()

        // 添加元素(在后面添加)
        arr01.append(5) // 或者 arr01 += 5
        println(arr01)

        // 添加元素(在前面添加)
        arr01.prepend(0) // 或者 0 +=: arr01
        println(arr01)

        // 指定索引位置添加
        arr01.insert(1,2,3,4,5)
        println(arr01)

        // 追加数组
        arr01.insertAll(2, arr02) // 同样有 appendAll 和 prependAll
        println(arr01)


        //删除
        arr01.remove(0) // 删除索引 0 位置的元素
        println(arr01)
        arr01.remove(1, 4) // 从索引1开始，往后删除4个, 包含索引1的元素
        println(arr01)
        arr01 -= 5 // 直接删除元素值， 有就删除， 有重复的话只会删掉一个
        println(arr01)

        
    }
}

