package com.stanlong.scala

/**
 * for表达式中的模式
 */
object Exercise01{
    def main(args: Array[String]): Unit = {
        val map = Map("A"->1, "B"->0, "C"->3)
        for ( (k, v) <- map ) {
            println(k + " -> " + v)
        }
        for ((k, 0) <- map) {
            // for中匹配会自动忽略失败的匹配，这里结果是 "B"->0，  "A"->1 和 "C"->3 会被忽略
            println(k + " --> " + 0)
        }

        for ((k, v) <- map if v == 0) {
            println(k + " ---> " + v)
        }


    }
}
