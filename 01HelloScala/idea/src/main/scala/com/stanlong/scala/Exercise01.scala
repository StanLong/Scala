package com.stanlong.scala

/**
 * 商品捆绑打折出售
 *
 * 现在有一些商品，请使用Scala设计相关的样例类，完成商品捆绑打折出售。要求
 * 商品捆绑可以是单个商品，也可以是多个商品。
 * 打折时按照折扣x元进行设计.
 * 能够统计出所有捆绑商品打折后的最终价格
 */
object Exercise01{
    def main(args: Array[String]): Unit = {

        val sale = Bundle("书籍", 10, Article("漫画", 40),
            Bundle("文学作品", 20, Article("《阳关》", 80), Article("《围城》", 30)))

        def price(it: Item): Double = {
            it match {
                //说明
                //1.p 就是 提取的该Aritlcle的价格
                case Article(_, p) => p
                //说明
                //1.disc 是提取的Bundle 的折扣
                //2.its@_* 是提取Bundle 所有的 Item* ,是一个集合
                //3. its.map(price _).sum - disc 表示递归的对its进行map操作
                //3.1 将从its 递归遍历取出的Aritcle对象传递给price 函数取出price 并累计求和 ,并减去折扣
                //3.2 对每一个Bundle(因为可能多个) 递归的如上操作，最终得到最后的值
                case Bundle(_, disc, its@_*) => its.map(price _).sum - disc
            }
        }
        val amountMoney = price(sale)
        println("amountMoney=" + amountMoney)
    }
}

abstract class Item

case class Article(description: String, price: Double) extends Item

case class Bundle(description: String, discount: Double, item: Item*) extends Item

