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

        // Scala中特质中如果调用super，默认时从右向做查找特这，如果找不到，才会去父特质查找。如果想要直接调用指定类的特质，需要这么写 super[类名].方法

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
        // super[Dta].insert(id)  直接调用父类的 insert 方法
    }
}
class MySQL {

}
```

## 自身类型

自身类型可实现依赖注入的功能

```scala
package com.stanlong.scala

/**
 * 自身类型
 * 实现依赖注入的功能
 */
object HelloScala {

    def main(args: Array[String]): Unit = {
        val user = new RegisterUser("zhangsan", "123456")
        user.insert()
    }
}

// 用户类
class User(val name: String, val password: String)


trait UserDao{
    // UserDao 想要使用 User 里的属性，但是不想有继承关系，就可以把 User 定义为自身类型
    _: User =>

    def insert(): Unit ={
        println(s"insert into db: ${this.name} ${this.password}") // 使用 this.属性 的方式访问自身类型
    }
}

// 定义注册用户类
class RegisterUser(name: String, password: String) extends User(name, password) with UserDao
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







