package com.stanlong.scala

/**
 * 类和对象
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val cat = new Cat()
        cat.name = "小白猫"
        cat.age = 10
        cat.color = "白色"
        println("ok~")
        printf("\n小猫的信息如下: %s %d %s", cat.name, cat.age, cat.color)
    }

    class Cat{
        var name:String=""
        var age:Int= 0
        var color = ""
    }
}
