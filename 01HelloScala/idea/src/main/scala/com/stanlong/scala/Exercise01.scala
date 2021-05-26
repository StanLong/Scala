package com.stanlong.scala

import scala.collection.mutable


/**
 * Queue
 * 队列是一个有序列表，在底层可以用数组或是链表来实现
 * 其输入和输出要遵循先入先出的原
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {

        // 创建队列
        val q = new mutable.Queue[Int]()
        println(q)

        // 往队列里新增元素
        q += 9
        println(q)
        q ++= List(1,2,3)
        println(q)

        val q1 = new mutable.Queue[Int]
        q1 += 12
        q1 += 34
        q1 ++= List(2,9)
        q1.dequeue() //从队列头部取出元素
        println(q1)
        q1.enqueue(20,60) //在队列尾部添加元素
        println(q1)

        // 返回队列的元素
        println(q1.head) // 返回队列的第一个元素
        println(q1.last) // 返回队列最后一个元素
        println(q1.tail) // 返回除了第一个以外剩余的元素， 可以级联使用，这个在递归时使用较多
        println(q1.tail.tail)


        //补充操作符重载...
        val cat = new Cat
        println(cat.age)
        cat += 9
        println(cat.age)
    }
}

class Cat {
    var age: Int = 10
    def +=(n:Int): Unit = {
        this.age += n
        println("xxx")
    }
}