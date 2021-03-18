package com.stanlong.scala

/**
 * 流程控制
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        var num = 6
        for(i <- 0 to num){
            printf("%d + %d = %d\n", i, (num-i), num)
        }
    }
}
