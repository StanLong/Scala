package com.stanlong.scala

/**
 * 匿名函数案例
 */
object Exercise01 {
    def main(args: Array[String]): Unit ={
        // 定义一个二元运算函数，只操作1和2两个数，但是具体运算通过参数传入
        def dealFunOneAndTwo(fun:(Int, Int) => Int):Int={
            fun(1,2)
        }

        val add = (a:Int, b:Int) => a + b
        val minus = (a:Int, b:Int) => a-b

        println(dealFunOneAndTwo(add))
        println(dealFunOneAndTwo(minus))

        // 匿名函数简化
        println(dealFunOneAndTwo(_+_))
        println(dealFunOneAndTwo(_-_))
    }

}
