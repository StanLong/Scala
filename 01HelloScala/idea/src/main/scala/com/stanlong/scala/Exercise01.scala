package com.stanlong.scala

/**
 * 高阶函数
 * 能够接受函数作为参数的函数，叫做高阶函数
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        // 案例一
        val result = test(sum2, 3.5)
        println(result)

        // 案例二
        // 在scala中，可以把一个函数直接赋值给一个变量，但是不执行函数，使用下面这种写法
        val f1 = myPrint _
        f1() // 执行

        // 案例三
        test2(sayOK)

        // 案例四
        val res = test4(sum, mod, 5.0)
        println(res)

        // 案例五
        // 高阶函数可以返回函数类型
        // 1. 分步执行
        val f2 = minusxy(3) // 匿名函数f2 = 3-y
        println(f2(1))  // 3-1
        println(f2(9))  // 3-9

        // 2. 一步到位执行
        val result3 = minusxy(3)(5) // 返回的匿名函数可以用变量接受
        println(result3)

    }

    // 案例一
    // test是一个高阶函数
    // f:Double=>Double 表示一个函数，该函数可以接受一个Double， 返回double
    // n1:Double 普通参数
    // f(n1) 执行传入的函数
    def test(f:Double=>Double, n1:Double)={
        f(n1)
    }

    def sum2(d:Double):Double={
        d + d
    }

    // 案例二
    def myPrint(): Unit ={
        println("Hello World")
    }

    // 案例三
    // 说明test2是一个高阶函数，可以接受一个没有输入，返回哦Unit的函数
    def test2(f: () => Unit) = {
        f()
    }
    def sayOK() = {
        println("sayOKKK...")
    }

    def test4(f:Double=>Double, f2:Double=>Int, n1:Double) ={
        f(f2(n1))
    }

    def sum(d:Double):Double ={
        d + d
    }
    def mod(d:Double):Int={
        d.toInt % 2
    }

    // minusxy(3)执行minusxy(x: Int)得到 (y: Int) => 3 - y 这个匿名函
    //minusxy(3)(5)执行 (y: Int) => x - y 这个匿名函数
    //也可以分步执行: val f1 = minusxy(3);   val res = f1(9)
    def minusxy(x: Int) = {
        (y: Int) => x - y // 该函数返回一个匿名函数
    }

}