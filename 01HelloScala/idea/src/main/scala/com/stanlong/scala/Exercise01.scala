package com.stanlong.scala

/**
 * 闭包
 * 请编写一个程序，具体要求如下
 * 编写一个函数 makeSuffix(suffix: String)  可以接收一个文件后缀名(比如.jpg)，并返回一个闭包
 * 调用闭包，可以传入一个文件名，如果该文件名没有指定的后缀(比如.jpg) ,则返回 文件名.jpg , 如果已经有.jpg后缀，则返回原文件名。
 * 要求使用闭包的方式完成
 * String.endsWith(xx)
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {

        val f = makeSuffix(".jpg")
        println(f("dog"))
        println(f("cat"))
        println(f("monster.jpg"))

        // 返回的函数和 makeSuffix (suffix: String) 的 suffix 变量 和返回的函数组合成一个闭包,
        // 因为 返回的函数引用到suffix这个变量
        //我们体会一下这个闭包的好处，如果使用传统的方法，也可以轻松实现这个功能，但是传统方法需要每次都传入 后缀名，比如 .jpg ,
        // 而闭包因为可以保留上次引用的某个值，所以我们传入一次就可以反复使用。大家可以仔细的体会一把！
    }

    def makeSuffix(suffix: String) = (name: String) => {
        if (name.endsWith(suffix) == false) {
            name + suffix
        }else {
            name
        }
    }
}