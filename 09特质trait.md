# 特质trait

## 基本概念和用法

Scala语言中，采用特质trait（特征）来代替接口的概念，也就是说，多个类具有相同的特质（特征）时，就可以将这个特质（特征）独立出来，采用关键字trait声明。 可以理解trait 等价于(interface + abstract class)

```scala
package com.stanlong.scala

/**
 * 特质
 */
object HelloScala {
    def main(args: Array[String]): Unit = {
        val student = new Student
        student.sayHello()
        student.study()
        student.dating()
        student.play()

    }
}

// 定义父类
class Person{
    val name: String ="person"
    val age: Int = 18

    def sayHello(): Unit ={
        println("hello from: " + name)
    }
}

// 定义一个特质
trait Young{
    // 声明抽象和非抽象属性
    val age: Int
    val name:String="young"

    // 声明抽象和非抽象方法
    def play(): Unit ={
        println("young people is playing")
    }

    def dating():Unit
}

class Student extends Person with Young{
    // 重写冲突的属性
    override val name: String = "student"

    // 实现抽象方法
    override def dating(): Unit = {
        println(s"student $name is dating")
    }

    def study(): Unit ={
        println(s"student $name is studying")
    }

    // 重写父类方法
    override def sayHello(): Unit = {
        super.sayHello()
        println(s"hello from:student $name")
    }
}

// 打印结果
hello from: student
hello from:student student
student student is studying
student student is dating
young people is playing
```

## 特质混入

```scala
package com.stanlong.scala

/**
 * 特质混入
 * 优点: 在不修改类声明/定义的情况下，扩展类的功能
 */
object HelloScala {

    def main(args: Array[String]): Unit = {

        val oracleDB = new OracleDB with Operate {
            override def update(id: Int): Unit = { // 重写特质中的抽象方法，又叫动态混入
                println(s"修改 oracle 记录id : $id")
            }
        }
        oracleDB.getPrice(10000.00) 
        oracleDB.insert(100)
        oracleDB.update(100)

        val hanaDB = new HanaDB with  Operate {
            override def update(id: Int): Unit = {  // 重写特质中的抽象方法，又叫动态混入
                println(s"修改 hana 记录 : $id")
            }

            override def say(): Unit = { // 抽象类混入特质时，需要实现抽象类中的抽象方法
                println("这是Hana数据库")
            }

        }
        hanaDB.insert(200)
        hanaDB.update(200)
        hanaDB.say()
    }
}

class DB {
    var name:String = _
    def getPrice(price: Double): Unit ={
        println(s"数据库的价格 : $price")
    }

}

trait Operate{

    def insert(id: Int): Unit ={
        println("插入数据 " + id)
    }

    // 抽象方法
    def update(id: Int): Unit
}

class OracleDB extends DB {

}


abstract class HanaDB{
    def say()
}
```

## 特质叠加

构建对象的同时如果混入多个特质，称之为叠加特质，叠加特质声明顺序从左到右，方法执行顺序从右到左

```scala
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



