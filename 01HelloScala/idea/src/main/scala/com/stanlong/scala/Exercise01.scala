package com.stanlong.scala

/**
 * 属性修饰词
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val worker = new Worker("Stanlong")
        println(worker.name)
        // println(worker.inName)
        // worker 只能访问到name，可读可写。 不能访问inName

        val worker2 = new Worker2("Stanlong")
        println(worker2.name)
        println(worker2.inName)
        // worker2 能访问到name,可读可写。也可以访问到 inName, 只读

        val worker3 = new Worker3("Stanlong")
        println(worker3.name)
        println(worker3.inName)
        worker3.inName = "沈万三"
        println(worker3.inName)
        // worker3 能访问到name, 可读可写。可以访问到 inName, 可读可写
    }
}

// 没有修饰词, 则inName 是一个局部变量
class Worker(inName:String){
    var name = inName
}

// val 修饰 inName, 那inName是worker2的一个private的只读属性
class Worker2(val inName:String){
    var name = inName
}

// var 修饰 inName, 那inName是worker3的一个private的可读写属性
class Worker3(var inName:String){
    var name = inName
}