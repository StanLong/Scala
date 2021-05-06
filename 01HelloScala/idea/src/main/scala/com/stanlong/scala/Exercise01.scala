package com.stanlong.scala

/**
 * 继承
 */
object Exercise01{ // 继承App后，就可以直接在这个类中执行代码，不需要再写main入口
    def main(args: Array[String]): Unit = {
        val student = new Student
        student.name = "StanLong"
        student.age = 27
        student.studying()
        student.showInfo()
    }
}


class Person(){
    var name : String = _
    var age : Int = _

    def showInfo(): Unit = {
        println("学生信息如下")
        println("名字: " + this.name)
        println("年龄: " + this.age)
    }
}

class Student extends Person{
    def studying(): Unit = {
        println(this.name + " 学习scala...")
    }
}