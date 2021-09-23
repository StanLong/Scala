package com.stanlong.scala

/**
 * 特质叠加
 * 叠加特质声明顺序从左到右，方法执行顺序从右到左
 */
object HelloScala {

    def main(args: Array[String]): Unit = {
        // 叠加特质声明顺序从左到右

        val mysql = new MySQL with DB with File // 先混入DB,在混入File
        // 打印结果
        /**
         * 1. Data
         * 2. DB
         * 3. File
         */

        val mysql1 = new MySQL with File with DB // 先混入File,在混入DB
        // 打印结果
        /**
         * 1. Data
         * 3. File
         * 2. DB
         */

        // Scala中特质中如果调用super，并不是表示调用父特质的方法，而是向前面（左边）继续查找特质，如果找不到，才会去父特质查找

        mysql.insert(888)
        // 打印结果
        /**
         * 3. 向文件
         * 2 .向数据库
         * 1. 插入数据 = 888
         */

        mysql1.insert(888)
        // 打印结果
        /**
         * 2 .向数据库
         * 3. 向文件
         * 1. 插入数据 = 888
         */

    }
}

trait Operate {
    def insert(id : Int)
}
trait Data extends Operate {
    println("1. Data")
    override  def insert(id : Int): Unit = {
        println("1. 插入数据 = " + id)
    }
}
trait DB extends Data {
    println("2. DB")
    override def insert(id : Int): Unit = {
        println("2 .向数据库")
        super.insert(id)
    }
}
trait File extends  Data {
    println("3. File")
    override def insert(id : Int): Unit = {
        println("3. 向文件")
        super.insert(id)
    }
}
class MySQL {

}