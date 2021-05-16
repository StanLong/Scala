package com.stanlong.scala

/**
 * 扩展类的特质
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
    }
}

//Logger就是自身类型特质
trait Logger{
    // 明确告诉编译器，我就是Exception,如果没有这句话，下面的getMessage不能调用
    this: Exception =>
    def log(): Unit ={
        // 既然我就是Exception, 那么就可以调用其中的方法
        println(getMessage)
    }
}

//下面会报错 llegal inheritance, self-type Console does not conform to Exception
//分析原因
//1. Logger 已经是Exception了
//2. 但是这里Console 并没有说明是Excepton的子类，因此出现了
// self-type Console does not conform to Exception，即自身类型的约束。
//class Console extends  Logger { //错误×
//
//}

// 如果我们需要混入Logger这种自身类型的特质，需要让该类也继承Excetion
// 这样Console 才能混入Logger,保证都是Excetpion类型

// 此处必须继承Exception类，否则无法混入logger特质
class Console extends Exception with Logger {

}
