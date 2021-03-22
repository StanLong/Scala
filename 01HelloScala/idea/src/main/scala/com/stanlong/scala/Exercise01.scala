package com.stanlong.scala

/**
 * 惰性函数
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        lazy val result = sum(10,20) // 这段使用了lazy， 函数中的println("测试懒加载")并不会执行
        println("----------------")
        println("result = " + result) // 只有在函数调用的时候， 函数中的println("测试懒加载")才会执行
    }
    // args:Int* 可变形参，可变形参得是最后一个参数
    def sum(num1:Int, args:Int*):Int ={
        println("测试懒加载")
        var sum = num1;
        for(item <- args){
            sum = sum + item
        }
        sum
    }
}
