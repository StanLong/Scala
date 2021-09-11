package com.stanlong.scala

/**
 * 伴生对象: 不使用 static 关键字并实现 static 功能
 */
object Exercise01 {
    def main(args: Array[String]): Unit ={
        val student1 = new Student("张三", 25)
        val student2 = new Student("张三", 20)
        student1.printInfo()
        student2.printInfo()
    }
}

class Student(name:String, age:Integer){
    def printInfo(): Unit ={
        println(name + " " + age + " " + Student.school)
    }
}

// object Student 为 class Student 的伴生对象，里面的各种属性、方法class Student都可以调用
object Student{
    val school:String = "北京大学" //  class Student 中只需要初始化一次的对象都可以放到伴生对象里
}