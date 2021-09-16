package com.stanlong.scala


/**
 * 控制抽象
 * 1. 值调用：把计算后的值传递过去
 * 2. 名调用：把代码传递过去
 */
object Exercise01 {
    def main(args: Array[String]): Unit ={
        // 1. 传值参数
        def f0(a:Int):Unit={
            println("a: " + a)
        }
        f0(20)

        def f1():Int={
            println("f1调用")
            12
        }
        f0(f1())

        // 2. 传名参数
        def f2(a: => Int): Unit ={ // => Int 表示一段代码块，代码块的返回值是 Int
            println("a: " + a)
        }
        f2(23)
        // 或者
        f2({23})
        // 或者
        f2({
            println("这是一个代码块")
            0
        })

        f2(f1()) // 说明 a 调用的几次，f1() 会跟着调用几次
    }

}
