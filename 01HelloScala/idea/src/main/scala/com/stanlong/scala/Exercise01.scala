package com.stanlong.scala

/**
 * 叠加特质
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        // 同时混入多个特质，称之为叠加
        // Scala在叠加特质的时候，会首先从后面的特质开始执行
        // Scala中特质中如果调用super，并不是表示调用父特质的方法，而是向前面（左边）继续查找特质，如果找不到，才会去父特质查找
        val mysql = new MySQL with DB with File
        // 修改在测试一下。。
        //val mysql = new MySQL with File with DB

        // 向数据库插入数据
        // 向文件插入数据
        // 向文件向数据库插入数据
        mysql.insert(888)

        // 打印结果
        //Operate...
        //Data
        //DB
        //File
        //向文件
        //向数据库
        //插入数据 = 888

    }
}

trait Operate {
    println("Operate...")
    def insert(id : Int)
}
trait Data extends Operate {
    println("Data")
    override  def insert(id : Int): Unit = {
        println("插入数据 = " + id)
    }
}
trait DB extends Data {
    println("DB")
    override def insert(id : Int): Unit = {
        println("向数据库")
        //Scala中特质中如果调用super，并不是表示调用父特质的方法，而是向前面（左边）继续查找特质，如果找不到，才会去父特质查找
        //这里就是找Data4的insert
        super.insert(id)
    }
}
trait File extends  Data {
    println("File")
    override def insert(id : Int): Unit = {
        println("向文件")
        //Scala中特质中如果调用super，并不是表示调用父特质的方法，而是向前面（左边）继续查找特质，如果找不到，才会去父特质查找
        //这里就是找DB4的insert
        super.insert(id)
    }
}
class MySQL {

}

