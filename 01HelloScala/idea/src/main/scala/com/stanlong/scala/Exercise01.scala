package com.stanlong.scala

/**
 * 可变形参
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        var result = sum(10, 20, 30, 40)
        println(result)

    }
    // args:Int* 可变形参，可变形参得是最后一个参数
    def sum(num1:Int, args:Int*):Int ={
        var sum = num1;
        for(item <- args){
            sum = sum + item
        }
        sum
    }
}
