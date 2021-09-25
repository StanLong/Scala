package com.stanlong.scala

/**
 * 枚举类和应用类
 */
object HelloScala {

    def main(args: Array[String]): Unit = {
        // 测试枚举类
        println(WorkDay.MONDAY)
        println(WorkDay.TUESDAY)
    }
}

// 定义枚举类对象
object WorkDay extends Enumeration{
    val MONDAY = Value(1, "Monday")
    val TUESDAY = Value(2, "Tuesday")
}

// 定义应用类对象
object TestApp extends App{
    println("app start")
}