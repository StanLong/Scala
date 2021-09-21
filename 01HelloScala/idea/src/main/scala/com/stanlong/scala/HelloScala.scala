package com.stanlong.scala

/**
 * 继承
 */
object HelloScala {
    def main(args: Array[String]): Unit = {
        val student1 = new Student("zhangsan", 18)
        val student2 = new Student("lisi", 19, "1142061140")
        student1.showInfo()
        student2.showInfo()
    }
}


class Person(){
    var name : String = _
    var age : Int = _

    println("1. 父类的主构造器被调用")

    def this(name:String, age:Int){
        this()
        println("2. 父类的辅助构造器被调用")
        this.name = name
        this.age = age
    }

    def showInfo(): Unit = {
        println(s"人物的年龄: $name, 年龄: $age")
    }
}

class Student(name:String, age:Int) extends Person{
    var stdNo:String = _
    println("3. 子类的主构造器被调用")

    def this(name:String, age:Int, stdNo:String){
        this(name, age)
        println("4. 子类的辅助构造器被调用")
        this.stdNo = stdNo
    }

    override def showInfo(): Unit ={
        println(s"学生名字: $name, 年龄: $age, 学号: $stdNo")
    }
}