package com.stanlong.scala

/**
 * 计算字符串中所有字母的Unicode代码的乘积
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val person = new Person("Stanlong", inAge = 20)
        println(person)

    }



}

// 构造器快速入门
// 创建Person对象的同时初始化对象的age属性和name属性值
class Person(inName:String, inAge:Int){
    var name=inName
    var age = inAge

    override def toString: String = {
        "name=" + this.name + "\t age=" + this.age
    }
}
