package com.stanlong.scala

object Test_Access {
    def main(args: Array[String]): Unit = {
        // 创建对象
        val person:Person = new Person()
        // person.idCard  error 私有属性无法访问
        // person.name  error  protected 修饰符在 当前类，子类可以访问，同包无法访问
        println(person.age)
        println(person.sex)
        println(person.printInfo())


        val worker = new Worker
        worker.printInfo()

    }

}

// 定义一个子类
class Worker extends Person{
    override def printInfo(): Unit ={
        // println(idCard) // error 子类不能访问父类的私有属性
        name ="bob"
        age = 25
        sex = "male"
        println(s"Worker: $name, $age, $sex")

    }

}
