#  while 的循环中断

Scala内置控制结构特地去掉了**break**和**continue**，是为了更好的适应函数化编程，推荐使用**函数式的风格**解决break和contine的功能，而不是一个关键字

```scala
package com.stanlong

import  util.control.Breaks._
/**
  * @author 矢量
  * @date 2020/7/19-21:45
  * while 的循环中断
  */
object WhileDemo {

  def main(args: Array[String]): Unit = {
    var n = 1;
    // breakable() 是一个高阶函数（可以接收一个函数作为参数的函数）
    // def breakable(op:=>Unit){
    //	try{
    //		op
    //	}catch{
    //		case ex: BreakControl =>
    //			if(ex ne breakException) throw ex
    //	}
    //}
    //1. op:=>Unit 表示接收的参数是一个没有输入，也没有返回值的函数
    //2. breakable 对 break() 抛出的异常做了处理
    //3. 当传入的是代码块是，可以把()改成{}
    breakable(
      while(n<=20){
        n += 1
        println("n=" + n)
        if(n == 18){
          // 中断while
          // 1. 在scala中使用函数式的break函数中断循环
          // 2. def break(): Nothing = {throw break Exception}
          break()
        }
      }
    )
    println("ok~")
  }
}
```



