package com.stanlong.scala

/**
 * 集合计算高级函数
 */
object HelloScala {

    def main(args: Array[String]): Unit = {
        val list1 = List(1,2,3,4,5,6,7)
        val list2 = List(("a", 10),("b", 5),("c", 100),("d", 1),("e", 0))

        // 1. 过滤
        // 选取偶数
        val evenList = list1.filter((elem: Int) => {elem % 2 ==0 })
        // 简写
        // val evenList = list1.filter(_ % 2 ==0)
        println(evenList)

        // 2. map 映射
        // 把集合中每个数乘2
        println(list1.map(_ * 2))

        // 3. 扁平化
        val nestedList = List(List(1,2,3), List(4,5,6), List(7,8,9))
        val flatList = nestedList(0) ::: nestedList(1) ::: nestedList(2)
        println(nestedList) // List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
        println(flatList) // List(1, 2, 3, 4, 5, 6, 7, 8, 9)

        val flatList2 = nestedList.flatten
        println(flatList2) // List(1, 2, 3, 4, 5, 6, 7, 8, 9)

        // 4. 扁平映射
        // 将一组字符串进行分词，并保存成单词的列表
        val strings = List("hello world", "hello scala", "hello java", "hello spark")
        val splitList:List[Array[String]] = strings.map( string => string.split(" "))
        val flattenList = splitList.flatten
        println(flattenList)

        // 或者直接调用 flatMap 方法
        val flatmapList = strings.flatMap(_.split(" "))
        println(flatmapList)

        // 5. 分组 groupBy
        // 分成奇偶两组
        val groupMap = list1.groupBy(_%2)
        println(groupMap) // Map(1 -> List(1, 3, 5, 7), 0 -> List(2, 4, 6))


        val groupMap2 = list1.groupBy( (data: Int) => if(data % 2 == 0) "偶数" else "奇数")
        println(groupMap2) // Map(奇数 -> List(1, 3, 5, 7), 偶数 -> List(2, 4, 6))

        // 给定一组词汇，按照单词的首字母进行分组
        val wordList = List("china", "america", "alice", "canada", "cary", "bob", "japan")
        println(wordList.groupBy(_.charAt(0))) // Map(c -> List(china, canada, cary), a -> List(america, alice), b -> List(bob), j -> List(japan))

        // 6. reduce
        println(list1.reduce(_+_)) // 28
        println(list1.reduce(_-_)) // -26 计算规则 1-2-3-4-5-6-7
        println(list1.reduceRight(_-_)) // 4 计算规则 1 - (2 - (3 - ( 4- (5 -( 6-7)))))

        // 7. fold , 注意初始值的位置
        println(list1.fold(10)(_+_)) // 38  10是初始值， 计算规则 10+1+2+3+4+5+6+7
        println(list1.fold(10)(_-_)) // -18  计算规则 10-1-2-3-4-5-6-7
        println(list1.foldRight(10)(_-_)) // -6 计算规则 1 - (2 - (3 - ( 4- (5 -( 6- (7- 10))))))
    }
}

