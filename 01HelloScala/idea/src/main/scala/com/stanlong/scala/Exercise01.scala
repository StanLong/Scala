package com.stanlong.scala

/**
 * 模式中的变量
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val ch = 'V'
        ch match {
            case '+' => println("ok~")
            // case mychar 含义是 mychar = ch
            case mychar => println("ok~" + mychar)
            case _ => println ("ok~~")
        }

        // match 是个表达式，可以有返回值
        val res = ch match {
            // case mychar 含义是 mychar = ch
            case mychar => println("ok~" + mychar)
            case _ => println ("ok~~")
        }
        println(res)
    }
}
