package com.stanlong.scala

import scala.beans.BeanProperty

/**
 * 计算字符串中所有字母的Unicode代码的乘积
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        var car = new Car
        car.name = "宝马"
        println(car.name)

        car.setName("奔驰")
        println(car.getName())
    }
}

class Person {
    var age: Short = 90
    var name: String
    = _
    def this (n: String, a: Int) {
        this ()
        this.name = n
        this.age = a
    }
}

var p: Person = new Person ("小倩", 20)