package com.stanlong.scala

/**
 * 构造器参数
 *
 */
object HelloScala {
    def main(args: Array[String]): Unit = {
        val student = new Student()
        student.student()

        val student1 = new Student("zhangsan")
        val student2 = new Student("lisi", 20)
    }
}

// 定义一个类
class Student(){
    // 定义属性
    var name: String = _
    var age: Int = _

    println("1. 主构造器方法被调用")

    // 声明辅助构造方法
    def this(name:String){
        this() // 直接调用主构造器
        println("2. 辅助构造方法一被调用")
        this.name = name
        println(s"name:$name age:$age")
    }

    def this(name:String, age:Int){
        this(name)
        println(s"3. 辅助构造器方法二被调用")
        this.age = age
        println(s"name:$name age:$age")
    }

    def student(): Unit ={
        println("不是构造方法，而是同名方法，只是方法名和类名一样")
    }

}