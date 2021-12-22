package com.stanlong.scala

import scala.util.control.Breaks.{break, breakable}

/**
 * 约瑟夫环
 */
object ForDemo {
    def main(args: Array[String]): Unit = {




    }

    // 模拟内存中的节点
    class Node(in_data:Int){
        var data = this.in_data
        var next:Node = null

        override def toString: String = "Node[" + "data=" + data + "]"
    }

    // 双向链表
    class CircleSingleLinkedList{
        var headNode = null // 定义头指针作为环形链表的引子
        // 新增
        def add(nums: Int): Unit ={
            var temp = null // 定义赋值指针，帮助遍历
            for(i <- 1 until(nums)){

            }

        }

        def show(): Unit ={

        }

        def out(): Unit ={

        }
    }

}