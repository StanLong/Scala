package com.stanlong.scala

/**
 * 嵌套类-》类型投影
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val outer1 : ScalaOuterClass = new ScalaOuterClass();
        val outer2 : ScalaOuterClass = new ScalaOuterClass();
        // Scala创建内部类的方式和Java不一样，将new关键字放置在前，使用  对象.内部类  的方式创建
        val inner1 = new outer1.ScalaInnerClass()
        val inner2 = new outer2.ScalaInnerClass()    //创建静态内部类对象

        //说明下面调用test 的 正确和错误的原因：
        //1.Java中的内部类从属于外部类,因此在java中 inner.test(inner2) 就可以，因为是按类型来匹配的。
        //2 Scala中内部类从属于外部类的对象，所以外部类的对象不一样，创建出来的内部类也不一样，无法互换使用
        //3. 比如你使用ideal 看一下在inner1.test()的形参上，
        // 它提示的类型是 outer1.ScalaOuterClass, 而不是ScalaOuterClass

        inner1.test(inner1) // ok
        // inner1.test(inner2) // 错误
    }
}

class ScalaOuterClass {
    myOuter =>  class ScalaInnerClass {
        //成员内部类
        def test( ic : ScalaInnerClass ) : Unit = {
            System.out.println(ic);
        }
    }
}

object ScalaOuterClass {
    //伴生对象
    class ScalaStaticInnerClass {
        //静态内部类
    }
}
