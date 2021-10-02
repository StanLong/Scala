package com.stanlong.scala

/**
 * 并行处理
 */
object HelloScala {

    def main(args: Array[String]): Unit = {


        //创建Stream
        def numsForm(n: BigInt) : Stream[BigInt] = n #:: numsForm(n + 1)
        val stream1 = numsForm(1)
        println(stream1)

        //再测试一个
        val stream2 = numsForm(10)
        println(stream2)


        //head和tail
        println("head=" + stream1.head) //1
        println(stream1.tail) //Stream(2, ?)

        println(stream1) //Stream(1, 2, ?)
        println(stream1.tail.tail) //Stream(3, ?)
        println(stream1) //Stream(1, 2, 3, ?)

        // 使用map映射stream的元素并行进行计算
        def multi(x:BigInt) : BigInt = {
            x * x
        }
        println(numsForm(5).map(multi)) //? (25,?)

    }
}
