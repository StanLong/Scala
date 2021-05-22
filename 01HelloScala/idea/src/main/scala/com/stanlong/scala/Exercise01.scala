package com.stanlong.scala

/**
 * 隐式类
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        // DB 会对应生成隐式类，当在该隐式类的作用域范围创建MySql 类的实例时，该隐式类就会生效
        // 隐式类必须被定义在“类”或“伴生对象”或“包对象”里，即隐式类不能是 顶级的
        implicit class DB(val m: MySql){ // 其所带的构造参数有且只能有一个
            def addSuffix():String={
                m + "scala"
            }
        }

        val mySql = new MySql
        mySql.sayOK()
        mySql.addSuffix()
    }
}

class MySql{
    def sayOK(): Unit ={
        println("Ok~")
    }
}