# 特质trait

从面向对象来看，接口并不属于面向对象的范畴，Scala是纯面向对象的语言，在Scala中，没有接口。Scala语言中，采用特质trait（特征）来代替接口的概念，也就是说，多个类具有相同的特征（特征）时，就可以将这个特质（特征）独立出来，采用关键字trait声明。 理解trait 等价于(interface + abstract class)

```scala
package com.stanlong.scala

/**
 * 特质 trait
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        var con = new Console()
        con.log("日志 2018-11-11 11:11:11")
    }
}

trait Logger {
    def log(msg: String)
}
// 所有的java接口都可以当做Scala特质使用
// 说明
// 1. class Console extends Logger with Cloneable with Serializable 中的 Serializable 是scala的trait
// 2. Serializable 是scala的trait 继承了 java.io.Serializable接口
// 看源码 trait Serializable extends Any with java.io.Serializable
// 3. 所以我们说所有的java接口都可以当做Scala特质使用，因为是间接继承的.
class Console extends Logger with Cloneable with Serializable {
    def log(msg: String) {
        println(msg)
    }
}
```



```scala
package com.stanlong.scala

/**
 * 动态混入
 * 可在不修改类声明/定义的情况下，扩展类的功能
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val oracleDB = new OracleDB with Operate
        oracleDB.insert(100)

        val mysqlDB = new MysqlDB with Operate
        mysqlDB.insert(200)

        // 抽象类中有抽象方法时，动态混入特质的写法
        val hanaDB = new HanaDB with  Operate {
            override def say(): Unit = {
                println("Hana数据库")
            }
        }
        hanaDB.insert(300)
        hanaDB.say()
    }
}

trait Operate{
    def insert(id:Int): Unit ={
        println("插入数据 = " + id)
    }
}

class OracleDB{

}

abstract class MysqlDB{

}

abstract class HanaDB{
    def say()
}
```

# 叠加特质

构建对象的同时如果混入多个特质，称之为叠加特质，叠加特质声明顺序从左到右，方法执行顺序从右到左

```scala
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
```

