package com.stanlong.scala

import scala.beans.BeanProperty

/**
 * 类和对象
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val cat = new Cat() // 括号可以省略
        // cat.name = "小白猫" // error 私有属性不能直接访问
        cat.age = 10
        cat.color = "白色"
        printf("小猫的信息如下: %d %s", cat.age, cat.color)
    }
}
class Cat{
    private var name:String="" // 默认 public 修饰符，可自定义 private

    @BeanProperty // 相当于创建出符合 JavaBean 规范的getter / setter 方法
    var age:Int= 0
    var color :String = _ // _ 表示默认值
}