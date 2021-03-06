```scala
package com.stanlong

/**
  * @author 矢量
  * @date 2020/7/12-18:03
  */
object forDemo {
  def main(args: Array[String]): Unit = {
    // 循环输出10句 HelloWorld
    val start = 1
    val end = 10
    for (i <- start to end){
      println("HelloWorld " + i)
    }

    // 遍历集合
    var list = List("Hello", 10, 20, "world")
    for (item <- list){
      println(item)
    }

    // until 遍历 与上面to遍历不同的是， to 闭合的 相当于[], until 是左闭右开的 相当于 [)
    for (i <- 1 until 3){
      println(i + " ")
    }

    // 循环守卫 相当于 continue 写法
    for (i <- 1 to 3 if i != 2){
      println(i + " ") // 输出 1 3
    }

    // 引入变量
    for(i <- 1 to 3 ; j = 4-i){
      println("j = " + j)
      /** 输出结果
        * j = 3
        * j = 2
        * j = 1
        */
    }

    // 嵌套循环
    for(i <- 1 to 3; j <- 1 to 3){
      println("i=" +i +" ," + "j= " + j)
      // 输出结果
      /**
        * i=1 ,j= 1
        * i=1 ,j= 2
        * i=1 ,j= 3
        * i=2 ,j= 1
        * i=2 ,j= 2
        * i=2 ,j= 3
        * i=3 ,j= 1
        * i=3 ,j= 2
        * i=3 ,j= 3
        */
    }

    // 循环返回值
    // yield i 将每次循环得到的 i 放入集合 vector 中，并返回给res
    val res = for(i <- 1 to 10) yield i
    println("res= " + res)
    //  输出结果
    // res= Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // 输出偶数
    val res2 = for(i <- 1 to 10) yield {
      if(i % 2 == 0){
        i
      }else{
        "不是偶数"
      }
    }
    println("res2= " + res2)
    // 输出结果
    // res2= Vector(不是偶数, 2, 不是偶数, 4, 不是偶数, 6, 不是偶数, 8, 不是偶数, 10)

    // 步长控制
    for(i <- Range(1, 10, 2)){// Range(start, end, step)
      println("i=" + i)
    }
    // 输出结果
    /**
      * i=1
      * i=3
      * i=5
      * i=7
      * i=9
      */


  }

}
```

