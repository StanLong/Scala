package com.stanlong.scala

/**
 * 空类型
 * Unit
 * null
 * Nothing
 */
object Exercise01 {
    def main(args: Array[String]): Unit ={
        // 1. Unit
        def m1():Unit={
            println("m1被调用执行")
        }
        val a = m1()
        println("a: " + a) // 打印结果 a: ()

        // 2. null
        // val b:Int = null // 报错： an expression of type Null is ineligible for implicit conversion
        var student = new Student("张三", 20)
        student = null
        println(student) // 打印结果 null

        // 3. Nothing
        def m2(n:Int) :Nothing = {
            throw new NullPointerException
        }

        val b:Int = m2(2)
        println("b: " + b) // 打印结果： Exception in thread "main" java.lang.NullPointerException

        // 说明： Nothing是任何类型的子类型，如果有逻辑判断，函数方法可以做如下修改
        def m3(n:Int):Int={
            if(n == 0){
                throw new NullPointerException
            }else{
                n
            }
        }

        val c:Int = m3(2)
        println("c: " + c) // 打印结果：2


    }

    class Student(name:String, age:Int){

    }
}
