package com.stanlong.scala

object printDemo {
    def main(args: Array[String]): Unit = {
        for(i <- 1 to 3){ // to 前闭后闭
            println(i) // 1 2 3
        }
        for(i <- 1 until 3){ // until 前闭后开
            println(i) // 1 2
        }
    }
}
