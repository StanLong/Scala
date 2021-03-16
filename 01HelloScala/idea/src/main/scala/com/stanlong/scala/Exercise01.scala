package com.stanlong.scala

import scala.io.StdIn

/**
 * 流程控制
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        print("请输入参数a的值")
        val a = StdIn.readInt()
        print("请输入参数b的值")
        val b = StdIn.readInt()
        print("请输入参数c的值")
        val c = StdIn.readInt()
        val num = math.pow(b,2) - 4*a*c
        var x = 0.0
        var y = 0.0
        if(num>0){
            x = (-b + math.sqrt(num))/2*a
            y = (-b - math.sqrt(num))/2*a
            print(s"实根x: ${x}, 实根y: ${y}")
        }else if((math.pow(b,2) - 4*a*c)==0){
            x = -b/2*a
            print(s"实根x: ${x}")
        }else{
            print("该方程无实根")
        }
    }
}
