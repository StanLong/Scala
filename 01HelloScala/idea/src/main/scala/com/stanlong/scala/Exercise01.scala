package com.stanlong.scala

/**
 * 只有主构造器可以调用父类的构造器。辅助构造器不能直接调用父类的构造器
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val stu = new Student("StanLong")
        stu.printName()
    }
}

class Person( pname : String )  {
    var name : String = pname
    def printName() {
        println("Person printName() " + name)
    }
}

class Student(studentname : String ) extends  Person(studentname)  {

    var sno : Int = 20

    override def printName() {
        println("Student printName() " + name)
        super.printName()
    }
}
