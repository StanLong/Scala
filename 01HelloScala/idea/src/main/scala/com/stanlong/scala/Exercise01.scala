package com.stanlong.scala

import scala.collection.mutable

/**
 * Map
 * Scala中，有可变Map (scala.collection.mutable.Map) 和 不可变Map(scala.collection.immutable.Map)
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        // 创建
        val map1 = Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> "北京") // 不可变, 输出顺序和声明顺序一致
        println(map1)

        val map2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> 30) // 可变, 输出顺序和声明顺序不一致
        println(map2)

        // 创建空映射
        val map3 = new scala.collection.mutable.HashMap[String, Int]
        println(map3)

        // 对偶元组
        //即创建包含键值对的二元组， 和第一种方式等价，只是形式上不同而已。
        //对偶元组 就是只含有两个数据的元组。
        val map4 = mutable.Map( ("A", 1), ("B", 2), ("C", 3),("D", 30) )
        println("map4=" + map4)
        println(map4("A"))

        // 遍历
        // 如果key存在，则返回对应的值
        // 如果key不存在，则抛出异常[java.util.NoSuchElementException]
        // 在Java中,如果key不存在则返回null
        val value1 = map2("Alice")
        println(value1)

        // 使用contains方法检查是否存在key
        // 返回Boolean
        // 1.如果key存在，则返回true
        // 2.如果key不存在，则返回false
        if( map4.contains("B") ) {
            println("key存在 值= " + map4("B"))
        } else {
            println("key不存在")
        }

        // 使用map.get(key).get取值
        // map.get方法会将数据进行包装
        // 如果 map.get(key) key存在返回some,如果key不存在，则返回None
        // 如果 map.get(key).get  key存在，返回key对应的值,否则，抛出异常 java.util.NoSuchElementException: None.get
        println(map4.get("A")) //Some
        println(map4.get("A").get) //得到Some在取出

        // 使用map4.getOrElse()取值
        // getOrElse 方法 : def getOrElse[V1 >: V](key: K, default: => V1)
        //说明：
        //如果key存在，返回key对应的值。
        //如果key不存在，返回默认值。在java中底层有很多类似的操作
        println(map4.getOrElse("A","默认"))

        // 修改， 删除
        val map5 = mutable.Map( ("A", 1), ("B", "北京"), ("C", 3) )
        map5("AA") = 20
        println(map5)

        // 增加单个元素
        val map6 = mutable.Map( ("A", 1), ("B", "北京"), ("C", 3) )
        map6 += ( "D" -> 4 )
        map6 += ( "B" -> 50 )
        println(map6)

        // 增加多个元素
        val map7 = mutable.Map( ("A", 1), ("B", "北京"), ("C", 3) )
        val map8 = map7 + ("E"->1, "F"->3)
        map7 += ("EE"->1, "FF"->3)
        println(map7)
        println(map8)

        // 删除元素
        val map9 = mutable.Map( ("A", 1), ("B", "北京"), ("C", 3) )
        map9 -= ("A", "B")
        println("map9=" + map9)

        // 遍历
        val map10 = mutable.Map( ("A", 1), ("B", "北京"), ("C", 3) )
        for ((k, v) <- map10){
            println(k + " is mapped to " + v)
        }
        for (v <- map10.keys) {
            println(v)
        }
        for (v <- map10.values) {
            println(v)
        }
        for(v <- map10) {
            println(v)
        }
    }
}
