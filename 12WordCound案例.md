# WordCount

## 普通WordCount

需求: 将集合中出现的相同的单词进行计数，取计数排名前三的结果

```scala
package com.stanlong.scala

/**
 * 普通 WordCount
 */
object HelloScala {

    def main(args: Array[String]): Unit = {
        val stringList = List(
            "hello",
            "hello world",
            "hello scala",
            "hello spark from scala",
            "hello flink from scala"
        )

        // 1. 对字符串进行切分，得到一个打散所有单词的列表
        // val wordList1 = stringList.map(_.split(" "))
        // val wordList2 = wordList1.flatten
        // 简写
        val wordList = stringList.flatMap(_.split(" "))
        // List(hello, hello, world, hello, scala, hello, spark, from, scala, hello, flink, from, scala)

        // 2. 相同的单词进行分组
        val groupMap = wordList.groupBy((word: String) => word)
        // Map(world -> List(world), flink -> List(flink), spark -> List(spark), scala -> List(scala, scala, scala), from -> List(from, from), hello -> List(hello, hello, hello, hello, hello))

        // 3. 对分组之后的list取长度，得到每个单词的个数
        val countMap = groupMap.map(kv => (kv._1, kv._2.length))
        // Map(world -> 1, flink -> 1, spark -> 1, scala -> 3, from -> 2, hello -> 5)

        // 4. 将map转换为list并排序取前三
        val sortList = countMap.toList.sortWith(_._2 > _._2).take(3)
        println(sortList)
        // List((hello,5), (scala,3), (from,2))

    }
}
```

## 复杂WordCount

```scala
package com.stanlong.scala


/**
 * 复杂 WordCount
 */
object HelloScala {

    def main(args: Array[String]): Unit = {
        val tupleList = List(
            ("hello", 1),
            ("hello world", 2),
            ("hello scala", 3),
            ("hello spark from scala", 1),
            ("hello flink from scala", 2)
        )

        val newStringList = tupleList.map(
            kv => {
                (kv._1.trim + " ") * kv._2
            }
        )
        println(newStringList)

        // 思路一：按普通版本操作
        val wordCountList = newStringList
          .flatMap(_.split(" "))
          .groupBy(word => word)
          .map(kv => (kv._1, kv._2.size))
          .toList
          .sortBy(_._2)(Ordering[Int].reverse)
          .take(3)
        println(wordCountList)

        // 思路二： 基于预统计的结果进行转换
        // 1. 将字符串打散为单词，并结合对应的个数包装成二元组
        val preCountList = tupleList.flatMap(
            tuple => {
                val strings = tuple._1.split(" ")
                strings.map(word => (word, tuple._2))
            }
        )
        // List((hello,1), (hello,2), (world,2), (hello,3), (scala,3), (hello,1), (spark,1), (from,1), (scala,1), (hello,2), (flink,2), (from,2), (scala,2))

        // 2. 对二元组按照单词进行分组
        val preCountMap = preCountList.groupBy(_._1)
        // Map(world -> List((world,2)), flink -> List((flink,2)), spark -> List((spark,1)), scala -> List((scala,3), (scala,1), (scala,2)), from -> List((from,1), (from,2)), hello -> List((hello,1), (hello,2), (hello,3), (hello,1), (hello,2)))

        // 3. 叠加每个单词预统计的个数值
        val countMap = preCountMap.mapValues(
            tupleList => tupleList.map(_._2).sum
        )
        // Map(world -> 2, flink -> 2, spark -> 1, scala -> 6, from -> 3, hello -> 9)
        
        // 4. 转换成 list， 排序取前3
        val countList = countMap.toList
          .sortWith(_._2 > _._2)
          .take(3)
        println(countList)
        // List((hello,9), (scala,6), (from,3))
    }
}
```



