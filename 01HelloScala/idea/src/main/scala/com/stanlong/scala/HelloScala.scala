package com.stanlong.scala

/**
 * 对象匹配
 * 针对对象实例的内容进行匹配使用样例类是最为简单快捷的， 不需要定义伴生对象并实行相关的方法
 */
object HelloScala {

    def main(args: Array[String]): Unit = {

        val student = new Student("zhangsan", 18)

        // 针对对象实例的内容进行匹配
        val result = student match {
            case Student("zhangsan", 18) => "Alice, 18"
            case _ => "Else"
        }
        println(result)
    }
}

// 定义样例类， 针对对象实例的内容进行匹配使用样例类是最为简单快捷的
case class Student(val name: String, val age: Int)