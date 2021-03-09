package com.stanlong.scala

object printDemo {
    def main(args: Array[String]): Unit = {
        var str1:String = "贵出如粪土"
        var str2:String = "贱取如珠玉"
        println(str1 + str2) // 字符串拼接

        var money:Float = 7000.00F
        var year:Int = 2021
        printf("%d年， 基金亏了%f", year, money) // 变量占位符
        printf("%d年， 基金亏了%.2f", year, money) // 变量占位符,%f保留两位小数

        println(s"$year 年，基金亏了$money") // 使用$变量名的方式输出变量值
        println(s"${year + 10} 年，基金亏了${money}") // ${}会被解析成一个表达式，可以进行运算

    }
}
