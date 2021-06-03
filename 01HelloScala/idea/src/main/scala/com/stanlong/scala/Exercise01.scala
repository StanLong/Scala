package com.stanlong.scala

/**
 * 扫描
 * 扫描，即对某个集合的所有元素做fold操作，但是会把产生的所有中间结果放置于一个集合中保存
 * scan 默认等于 scanleft
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {

        //5 (1,2,3,4,5) =>(5,4,2,-1,-5,-10)
        // 执行步骤
        // 5
        // 5-1 = 4
        // 5-1-2 = 2
        // 5-1-2-3 = -1
        // 5-1-2-3-4 = -5
        // 5-1-2-3-4-5 = -10
        val i7 = (1 to 5).scan(5)(minus) //IndexedSeq[Int]
        println(i7)
        // Vector(5, 4, 2, -1, -5, -10)

        val i8 = (1 to 5).scanLeft(5)(minus) //IndexedSeq[Int]
        println(i8)
        // Vector(5, 4, 2, -1, -5, -10)

        // 执行步骤, 从右边开始看
        // 5
        // 5-5 = 0
        // 4-(5-5) = 4
        // 3-(4-(5-5)) = -1
        // 2-(3-(4-(5-5))) = 3
        // 1-(2-(3-(4-(5-5)))) = -2
        val i6 = (1 to 5).scanRight(5)(minus) //IndexedSeq[Int]
        println(i6)
        // Vector(-2, 3, -1, 4, 0, 5)

        // 执行步骤
        //5
        //5+1 = 6
        //5+1+2 = 8
        //5+1+2+3 = 11
        //5+1+2+3+4 = 15
        //5+1+2+3+4+5 = 20
        val i9 = (1 to 5).scanLeft(5)(add) //IndexedSeq[Int]
        println(i9)
        // Vector(5, 6, 8, 11, 15, 20)
    }
    def minus( num1 : Int, num2 : Int ) : Int = {
        num1 - num2
    }

    def add( num1 : Int, num2 : Int ) : Int = {
        num1 + num2
    }
}