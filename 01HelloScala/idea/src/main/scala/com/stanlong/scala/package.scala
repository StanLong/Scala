package com.stanlong

/**
 * 包对象
 * 定义在包对象中的成员，其下所有的 class 和 object 共享，可以被同一层级下的对象直接访问
 */
package object scala {
    // 定义当前包共享的属性和方法
    val commonValue = "中国"
    def commonMethod(): Unit ={
        println("实现中华民族的伟大复兴")
    }
}
