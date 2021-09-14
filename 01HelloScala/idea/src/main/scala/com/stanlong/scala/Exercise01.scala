package com.stanlong.scala

object Exercise01 {
    def main(args: Array[String]): Unit ={
        val fun = (i:Int, s:String, c:Char) => {if(i==0 && s == "" && c=='0') false else true}
        println(fun(0, "", '0'))
        println(fun(1, "", '0'))
        println(fun(0, "abc", '0'))
        println(fun(0, "", '1'))
    }

}
