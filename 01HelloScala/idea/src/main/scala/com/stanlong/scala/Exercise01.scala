package com.stanlong.scala
import scala.util.control.Breaks.{break, breakable}

/**
 *  while循环
 *  while
 *  do..while
 *  breakable 循环中断
 */
object Exercise01 {
    def main(args: Array[String]): Unit ={
        // while
        var a = 10
        while( a>= 1){
            println("this is a while loop: " + a)
            a = a-1
        }

        // do..while
        var b = 10
        do{
            println("this is b while loop: " + b)
            b = b-1
        }while(b>0)

        // breakable 循环中断
        var n = 10
        breakable{
            while (n < 20){
                n = n+1
                if(n==18){
                    break()
                }
                println(n)
            }
        }

    }

}
