package com.stanlong.scala

/**
 * 抽象控制
 *
 * 进阶用法：实现类似while的until函数
 */
object Exercise01 {
    def main(args: Array[String]): Unit ={
        //说明
        //1. 只要condition 为真，就不在执行 block代码
        def until(condition: => Boolean)(block: => Unit) {//类似while循环，递归
            if (!condition) {
                block // block就是【x -= 1 println(x)】，会导致x的减小
                //这里传入的始终是 () => {x == 0} 的匿名函数，但是x是变化,因此总会x==0成立的
                until(condition)(block)
            }
        }

        var x = 10
        until(x == 0) {
            x -= 1
            println(x)
        }
    }
}