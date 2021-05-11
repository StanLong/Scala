package com.stanlong.scala

/**
 * 属性重写
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val person = new Person
        val student = new Student
        println(person.name)
        println(student.name)

        val person2 = new Person
        val student2 = new Person
        println(person2.name)
        println(student2.name)

        val person3 = new Student
        val student3 = new Student
        println(person3.name)
        println(student3.name)
    }
}

class Person{
    val name:String = "StanLong"
}

class Student extends Person{
    override val name:String = "南海财神"
}