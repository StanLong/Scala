package com.stanlong.scala

/**
 * 多态
 * Java 中属性是静态绑定的，方法是动态绑定的
 * Scala 中属性和方法都是动态绑定的，需要加 override 关键字
 */
object HelloScala {
    def main(args: Array[String]): Unit = {
        val student = new Student("lisi", 19, "1142061140")
        student.showInfo()

        val teacher = new Teacher
        teacher.showInfo()

        // 动态绑定方法
        def personInfo(person:Person): Unit ={
            person.showInfo()
        }
        personInfo(student)
        personInfo(teacher)

        // 动态绑定属性
        // 只能覆盖使用 val 修饰的属性
        val person: Person = new Teacher
        println(person.name)


    }
}


class Person(){
    val name : String = "person"
    var age : Int = _

    def showInfo(): Unit = {
        println(s"人物的年龄: $name, 年龄: $age")
    }
}

class Student(name:String, age:Int) extends Person{
    var stdNo:String = _

    def this(name:String, age:Int, stdNo:String){
        this(name, age)
        this.stdNo = stdNo
    }

    override def showInfo(): Unit ={
        println(s"学生名字: $name, 年龄: $age, 学号: $stdNo")
    }
}

class Teacher extends Person{
    override val name: String = "teacher"
    override def showInfo(): Unit = {
        println(s"Teacher")
    }

}
