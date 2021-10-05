package com.stanlong.scala

/**
 * 泛型上下限
 */
object HelloScala {

    def main(args: Array[String]): Unit = {
        // 泛型上下限
        def test[A <: Child](a:A): Unit ={
            println(a.getClass.getName)
        }
        // test[Parent](new Child) 报错, Parent 超出泛型上限了
        // 以下三种方式的调用都没有超出定义的泛型上限
        test[Child](new Child)
        test[Child](new SubChild)
        test[SubChild](new SubChild)
    }
}

// 定义继承关系
class Parent{}
class Child extends Parent{}
class SubChild extends Child{}

// 定义带泛型的集合类型
// +E 协变
// -E 逆变
class MyCollection[-E]{}

