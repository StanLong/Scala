/**
 * 用嵌套风格定义包
 * 特点如下:
 * 1. 一个源文件中可以声明多个 package
 * 2. 内部的包可以直接访问外部包中的内容，而无需导包
 * 3. 外部包如果要访问内部包中的类则需要导包
 */

// package com.stanlong.scala 一般定义风格
package com{
    // 在外层包中定义单例对象
    object Outer{
        var out:String="out"
    }

    package stanlong {
        package  scala {
            // 内层包中定义单例对象
            object  Inner{
                def main(args: Array[String]): Unit = {
                    println(Outer.out)
                    Outer.out = "outer"
                    println(Outer.out)
                }
            }
        }
    }
}
