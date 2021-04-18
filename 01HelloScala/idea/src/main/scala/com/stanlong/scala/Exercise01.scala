package com.stanlong.scala

/**
 * Time 类，判断事件
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val cur = new Time(10, 20)
        val other = new Time(10, 20)
        println(other.before(cur))

    }
}

/**
 * Time 类，判断事件
 */
class Time(hrs:Int, min:Int){
    val hours = hrs
    val minutes = min
    def before(other:Time):Boolean={
        if(hours<other.hours){
            true
        }else if(hours > other.hours){
            false
        }else{
            if(minutes<other.minutes) true else false
        }
    }
}



