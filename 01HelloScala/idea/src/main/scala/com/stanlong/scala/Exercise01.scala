package com.stanlong.scala

/**
 * val 只能重写另一个抽象的var属性
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val student = new Student
        print(student.name)
    }
}

abstract class Person()  {
    var name : String // 抽象字段不能被初始化，否则无法重写
}

class Student() extends Person()  {
    override var name = "StanLong"
}
