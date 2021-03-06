```scala
package com.stanlong

/**
  * @author 矢量
  * @date 2020/7/2-21:15
  * scala 语言输出的三种方式
  */
object printDemo {
  def main(args: Array[String]): Unit = {
    var str1: String = "hello"
    var str2: String = " world"
    println(str1 + str2)
    // hello world
    var name: String = "tom"
    var age:Int = 10
    var sal:Float=10.67f
    var height:Double=180.15
    // 格式化输出
    printf("名字=%s 年龄是%d 薪水是%.2f 高%.3f" ,name, age, sal, height) // 保留小数点两位 %.2f， 保留小数点3位 %.3f, 默认保留小数点6位
    // 名字=tom 年龄是10 薪水是10.67 高180.150

    // scala 支持使用$输出内容，编译器回去解析$对应的变量
    println(s"\n个人信息如下: \n名字$name \n年龄$age \n薪水 $sal ")
    /**
      * 个人信息如下:
      * 名字tom
      * 年龄10
      * 薪水 10.67
      */

    // {} 里面是个表达式，可以进行运算
    println(s"\n个人信息如下2: \n 名字${name} \n年龄${age + 10} \n薪水 ${sal} ")

    /**
      * 个人信息如下2:
      * 名字tom
      * 年龄20
      * 薪水 10.67
      */
  }
}
```

