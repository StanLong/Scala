package com.stanlong.scala

/**
 * 嵌套类-》类型投影
 * 类型投影主要用在有外部类和内部类，并且外部类有方法是需要传入内部类作参数的时候用的
 * 而这个传入的参数要求除了可以是自己这个对象的内部类，也可以是其他实例对象的内部类，只要都是实例化这个类就行了。
 * 格式是 Outter#Inner
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val outer1 : ScalaOuterClass = new ScalaOuterClass();
        val outer2 : ScalaOuterClass = new ScalaOuterClass();
        // Scala创建内部类的方式和Java不一样，将new关键字放置在前，使用  对象.内部类  的方式创建
        val inner1 = new outer1.ScalaInnerClass()
        val inner2 = new outer2.ScalaInnerClass()    //创建静态内部类对象

        /**
         * Scala中的内部类 必须依赖于外部类的实例 而外部类的实例各不相同 所以被之为这种对于外部类的依赖为"路径依赖"
         * 所以不同的路劲代表不同的类型, 即这里inner1和inner2并不是同一个类型
         */

        inner1.test(inner1) // ok
        // inner1.test(inner2) // 错误

        inner1.test2(inner1) // ok
        inner1.test2(inner2) // ok
    }
}

class ScalaOuterClass {
    myOuter =>  class ScalaInnerClass {
        //成员内部类
        def test( ic : ScalaInnerClass ) : Unit = {
            System.out.println(ic);
        }

        //类型投影
        def test2(ScalaInnerClass: ScalaOuterClass#ScalaInnerClass) : Unit = {
            System.out.println(ScalaInnerClass);
        }
    }
}
