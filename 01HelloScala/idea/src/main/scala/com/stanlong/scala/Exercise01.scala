package com.stanlong.scala

/**
 * 视图
 * Stream的懒加载特性，也可以对其他集合应用view方法来得到类似的效果，具有如下特点：
 * view方法产出一个总是被懒执行的集合。
 * view不会缓存数据，每次都要重新计算，比如遍历View时
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        def multiple(num: Int): Int = {
            num
        }

        def eq(i: Int): Boolean = {
            //如果i这个数字倒序后，和本身相同，则返回true
            i.toString.equals(i.toString.reverse)
        }

        //说明: 没有使用view
        //1. 对 1-100 进行遍历
        //2. map(multiple) 对 1-100进行map映射操作，这里其实就是简单的复制一份
        //3. filter(eq) 使用eq方法对新的集合进行过滤，条件为i.toString.equals(i.toString.reverse)
        val viewSquares1 = (1 to 100).map(multiple).filter(eq)

        println(viewSquares1)
        for (x <- viewSquares1) {
            print(x + "，")
        }

        println("\n-----------------------------")
        //使用view
        //1. 使用和前面一样，只是使用了view
        //2. view方法产出一个总是被懒执行的集合
        //3. view不会缓存数据，每次都要重新计算
        val viewSquares2 = (1 to 100).view.map(multiple).filter(eq)

        println(viewSquares2)
        for (x <- viewSquares2) {
            print(x + "，")
        }
    }
}