package com.stanlong.scala


/**
 * 希尔排序
 */
object ForDemo {

    def main(args: Array[String]): Unit = {
        var array = Array[Int](84, 83, 88, 87, 61, 50, 70, 60, 80, 99)
        var step:Int = Math.ceil(array.length / 2).toInt
        var temp:Int = 0
        var count:Int = 0
        while (step>0){
            count = count + 1
            for(i <- step until(array.length)){
                var j = i-step
                while (j>=0){
                    if(array(j) > array(j+step)){
                        temp = array(j)
                        array(j) = array(j+step)
                        array(j+step) = temp
                    }
                    j = j-step
                }
            }
            println("第" + count + "次排序结果: " + array.mkString(","))
            step = step / 2
        }
        println("最终排序结果: " + array.mkString(","))






    }
}
