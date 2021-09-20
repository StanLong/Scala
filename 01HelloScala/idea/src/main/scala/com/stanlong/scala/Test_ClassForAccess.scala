package com.stanlong.scala

object Test_ClassForAccess {

}


// 定义一个父类
class Person{
    private var idCard:String = "123465"
    protected var name:String = "zhangsan"
    var sex:String="female"
    private[scala] var age: Int = 18

    def printInfo(): Unit ={
        println(s"Person:$idCard, $name, $sex, $age")
    }
}