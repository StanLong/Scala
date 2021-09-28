package com.stanlong.scala

/**
 * 不可变数组
 */
object HelloScala {

    def main(args: Array[String]): Unit = {
        // 第一种方式，使用默认值
        val arr01 = new Array[Int](4) // [Int]表示该数组只能放Int， [Any] 表示可以存任何类型
        // 第二种方式：指定初始值
        val arr02 = Array(1, 2, "xxx")

        // 通过下标修改数组
        arr02(2) = 3
        println(arr02(2))

        // 添加元素(在列表最后添加) :+
        val arr03 = arr02.:+(4) // 或者写成 val arr03 = arr02 :+ 4
        println(arr03.mkString(","))  // 1,2,3,4

        // 添加元素(在列表前面添加) +:
        val arr04 = arr02.+:(0) // 或者写成 val arr04 = 0 +: arr02 注意顺序
        println(arr04.mkString(",")) // 0,1,2,3

        // 获取数组长度
        println(arr01.length)

        // 遍历数组的集中方式

        // 1. 直接遍历(增强for循环)
        for (i <- arr02) {
            println(i)
        }

        // 2. 使用下标遍历数组
        for (index <- 0 until arr02.length){
            printf("arr02[%d]=%s ", index, arr02(index) + "\t")
        }

        // 3. 方式2 的简写
        for( i <- arr02.indices){
            println(arr02(i))
        }

        // 4. 使用迭代器
        val iter = arr02.iterator
        while (iter.hasNext){
            println(iter.next())
        }

        // 5. foreach 方法
        arr01.foreach((elem: Int) => println(elem))
        // 简写
        arr01.foreach(println)

    }
}

