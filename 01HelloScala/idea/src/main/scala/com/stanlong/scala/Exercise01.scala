package com.stanlong.scala

/**
 * 多态
 */
object Exercise01{
    def main(args: Array[String]): Unit = {
        val student = new Student
        val emp = new Emp
        test(student)
        test(emp)
    }

    def test(person: Person):Unit = {
        if (person.isInstanceOf[Student]){
            person.asInstanceOf[Student].studying()
        }else if(person.isInstanceOf[Emp]){
            person.asInstanceOf[Emp].working()
        }else{
            println("不知道是啥类型")
        }
    }
}


class Person(){
    var name : String = _
    var age : Int = _

    def showInfo(): Unit = {
        println("学生信息如下")
        println("名字: " + this.name)
        println("年龄: " + this.age)
    }
}

class Student extends Person{
    def studying(): Unit = {
        println("学习scala...")
    }
}

class Emp extends Person{
    def working(): Unit = {
        println("用scala搬砖...")
    }
}