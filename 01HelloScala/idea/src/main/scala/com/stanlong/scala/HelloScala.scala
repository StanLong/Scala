package com.stanlong.scala

/**
 * 单例对象（伴生对象）
 */
object HelloScala {
    def main(args: Array[String]): Unit = {
        val student1 = Student.getInstance()
        student1.printInfo()

        val student2 = Student.getInstance()
        student2.printInfo()

        println(student1)
        println(student2)

    }
}

class Student private (val name:String, val age:Int){ // 参数列表前加 private 修饰符表示主构造器被私有化
    def printInfo(): Unit ={
        println(s"student:name=${name} , age=${age}, school=${Student.school}")
    }
}

// 单例模式(饿汉式)
// object Student{
//     val school:String = "buaa"
//     private val student: Student = new Student("zhangsan", 18)
//     def getInstance():Student = student
// }

// 单例模式(饿汉式)
object Student{
    val school:String = "buaa"
    private var student:Student = _
    def getInstance():Student={
        if(student == null){
            // 如果没有对象实例，就创建一个
            student = new Student("zhangsan", 18)
        }
        student
    }
}

