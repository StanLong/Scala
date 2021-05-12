package com.stanlong.scala

/**
 * 如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法和抽象属性，除非它自己也声明为abstract类
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        println("ok100")

    }
}

abstract class Animal{
    var name : String //抽象的字段
    var age : Int // 抽象的字段
    var color : String = "black"
    //我们发现这个父类的方法，被子类继承后，没有什么用处，但是我们还
    //希望子类将来必须有这个cry方法,但是目前cry 不用写，声明为抽象的方法
    def cry()
}

class Dog extends Animal{
    var name : String = _
    var age : Int = _
    def cry(): Unit = {
        println("小狗汪汪叫唤..")
    }
}
