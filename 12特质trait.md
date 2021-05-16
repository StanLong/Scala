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

# 在特质中重写抽象方法

```scala
package com.stanlong.scala

/**
 * 在特质中重写抽象方法
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        println("123")
    }
}
trait Operate {
    def insert(id : Int)
}
trait File extends Operate {
    // 如果在自特质中重写了父特质的抽象方法，但是同时调用super
    // 这时我们的方法不是完全实现，因此需要声明为 abstract override
    //
    abstract  override def insert( id : Int ): Unit = {
        println("将数据保存到文件中..")
        super.insert(id)
    }
}
```

# 富接口

富接口：即该特质中既有抽象方法，又有非抽象方法

```scala
trait Operate {
    def insert( id : Int ) //抽象方法
    def pageQuery(pageno:Int, pagesize:Int): Unit = { // 非抽象方法
        println("分页查询")
    }
}
```

# 特质中的具体字段

```scala
package com.stanlong.scala

/**
 * 特质中的具体字段
 *
 * 特质中可以定义具体字段，如果初始化了就是具体字段，如果不初始化就是抽象字段。
 * 混入该特质的类就具有了该字段，字段不是继承，而是直接加入类，成为自己的字段。
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        var mysql = new MySQL with DB
        //通过反编译，可以看到 opertype
        println(mysql.opertype)
    }
}

trait Operate {

    //抽象的字段
    var opertype : String
    //抽象的方法
    def insert()
}
trait DB extends  Operate {
    var opertype : String = "insert"

    def insert(): Unit = {

    }
}
class MySQL {

}
```

# 特质构造顺序

1. 调用当前类的超类构造器
2. 第一个特质的父特质构造器
3. 第一个特质构造器
4. 第二个特质构造器的父特质构造器, 如果已经执行过，就不再执行
5. 第二个特质构造器
6. .......重复4,5的步骤(如果有第3个，第4个特质)
7. 当前类构造器

```scala
package com.stanlong.scala

/**
 * 特质构造顺序
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val ff1 = new FF()
        println(ff1) //输出的内容如下：
        //    E...
        //    A...
        //    B....
        //    C....
        //    D....
        //    F....

        println("--------------------------")
        val ff2 = new KK() with CC with DD
        println(ff2) //输出的内容如下：
        //    E...
        //    K....
        //    A...
        //    B....
        //    C....
        //    D....
    }
}

trait AA {
    println("A...")
}

trait BB extends  AA {
    println("B....")
}

trait CC extends  BB {
    println("C....")
}
trait DD extends  BB {
    println("D....")
}

class EE {
    println("E...")
}
class FF extends EE with CC with DD {
    println("F....")
}

class KK extends EE {
    println("K....")
}
```

# 扩展类的特质

```scala
package com.stanlong.scala

/**
 * 扩展类的特质
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val unhappyException = new UnhappyException
        unhappyException.getMessage()
    }
}

/**
 * LoggedException 继承了 Exception
 * LoggedException 就可以使用 Exception 功能
 */
trait LoggedException extends Exception{
    def log(): Unit ={
        println(getMessage()) // 方法来自于Exception类
    }
}

// 所有混入该特质的类，会自动成为那个特质所继承的超类的子类
// UnhappyException 就是Exception的子类.
class UnhappyException extends LoggedException{
    // 已经是Exception的子类了，所以可以重写方法
    override def getMessage = "错误消息！"
}
```

# 自身类型

自身类型：主要是为了解决特质的循环依赖问题，同时可以确保特质在不扩展某个类的情况下，依然可以做到限制混入该特质的类的类型。

```scala
package com.stanlong.scala

/**
 * 扩展类的特质
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
    }
}

//Logger就是自身类型特质
trait Logger{
    // 明确告诉编译器，我就是Exception,如果没有这句话，下面的getMessage不能调用
    this: Exception =>
    def log(): Unit ={
        // 既然我就是Exception, 那么就可以调用其中的方法
        println(getMessage)
    }
}

//下面会报错 llegal inheritance, self-type Console does not conform to Exception
//分析原因
//1. Logger 已经是Exception了
//2. 但是这里Console 并没有说明是Excepton的子类，因此出现了
// self-type Console does not conform to Exception，即自身类型的约束。
//class Console extends  Logger { //错误×
//
//}

// 如果我们需要混入Logger这种自身类型的特质，需要让该类也继承Excetion
// 这样Console 才能混入Logger,保证都是Excetpion类型

// 此处必须继承Exception类，否则无法混入logger特质
class Console extends Exception with Logger {

}
```



