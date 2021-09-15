package com.stanlong.scala

/**
 * 柯里化
 * 把一个参数列表的多个参数，变成多个参数列表
 * 即把 fun(1,2,3,4)  变成 fun(1)(2)(3)(4)
 */
object Exercise01 {
    def main(args: Array[String]): Unit ={
        def add(a:Int, b: Int):Int = {
            a + b
        }

        // 1. 考虑固定一个加数的场景
        def addByFour(b:Int):Int={
            4 + b
        }

        // 2. 当固定加数改变时，扩展将固定加数作为参数传入，但是是作为"第一层参数"传入
        def addByA(a:Int): Int => Int = {
            def addB(b:Int):Int = {
                a + b  // 闭包
            }
            addB
        }

        // 闭包采用柯里化的方式来写
        def addCurrying(a:Int)(b:Int):Int={
            a + b
        }

        println(addCurrying(10)(20))
    }

}
