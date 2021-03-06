```scala
package com.stanlong

/**
  * @author 矢量
  * @date 2020/7/12-15:18
  */
object IfDemo {

  def main(args: Array[String]): Unit = {
    // scala 中任意表达式都是有返回值的，也就意味着if elase 其实是有返回结果的，具体返回结果的值取决于满足条件的代码的最后一行内容
    val age = 70
    val res = if(age > 20){
      println("age > 20") // age > 20
      9 + 10
      "yes ok"
    }else{
      7
    }
    println("res=" +res)
    // 输出结果为  res=yes ok

    // scals 没有三元运算符,它的计算方式是
    var flg = true
    var result = if(flg) 1 else 0
    println("result:" + result)
    // 输出结果为  result:1
  }
}
```

