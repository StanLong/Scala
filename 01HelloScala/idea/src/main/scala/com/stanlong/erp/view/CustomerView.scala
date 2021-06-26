package com.stanlong.erp.view

import com.stanlong.erp.bean.Customer
import com.stanlong.erp.service.CustomerService

import scala.io.StdIn

class CustomerView {

    // 定义循环变量，推出循环
    var loop = true

    // 接受用户输入的选项
    var key = ' '

    val customerService = new CustomerService()

    def mainMenu():Unit = {
        do {
            println("-----------------客户信息管理软件-----------------")
            println("                 1 添 加 客 户")
            println("                 2 修 改 客 户")
            println("                 3 删 除 客 户")
            println("                 4 客 户 列 表")
            println("                 5 退       出")
            println("请选择(1-5):")
            key = StdIn.readChar()
            key match {
                case '1' => {
                    this.add()
                }
                case '2' => {
                    this.update()
                }
                case '3' => {
                    this.delete()
                }
                case '4' => {
                    this.list()
                }
                case '5' =>{
                    println("退       出")
                    this.loop = false
                }
                case _ =>{
                    println("输入错误，请重写输入")
                }
            }

        }while(loop)
    }

    // 列表展示
    def list(): Unit ={
        println()
        println("---------------------------客户列表---------------------------")
        println("编号\t姓名\t性别\t年龄\t电话\t邮箱")
        val customers = customerService.list()
        for (customer <- customers){
            println(customer)
        }
    }

    // 添加
    def add(): Unit ={
        println("---------------------添加客户---------------------")
        print("姓名：")
        val name = StdIn.readLine()
        print("性别：")
        val gender = StdIn.readChar()
        print("年龄：")
        val age = StdIn.readShort()
        print("电话：")
        val tel = StdIn.readLine()
        print("邮箱：");
        val email = StdIn.readLine()

        val customer = new Customer(name, gender, age, tel, email)
        customerService.add(customer)
        println("---------------------添加完成---------------------")

    }

    // 修改
    def update(): Unit ={
        println("---------------------修改客户---------------------")
        println("请选择待修改客户编号(-1退出)：")
        val id = StdIn.readInt()
        if(id == -1){
            println("---------------------退出---------------------")
            return
        }
        val customer = customerService.findCustomerById(id)
        print(customer)
        println()
        print("姓名：")
        val name = StdIn.readLine()
        print("性别：")
        val gender = StdIn.readChar()
        print("年龄：")
        val age = StdIn.readShort()
        print("电话：")
        val tel = StdIn.readLine()
        print("邮箱：");
        val email = StdIn.readLine()

        val customerNew = new Customer(id, name, gender, age, tel, email)
        val flag = customerService.update(customerNew)
        if(flag){
            println("---------------------修改成功---------------------")
            return
        }
        println("---------------------修改失败---------------------")
    }

    // 删除
    def delete(): Unit ={
        println("---------------------删除客户---------------------")
        println("请选择待删除客户编号(-1退出)：")
        val id = StdIn.readInt()
        if(id == -1){
            println("---------------------删除没有完成---------------------")
            return
        }
        println("确认是否删除(Y/N)：")
        var choice = StdIn.readChar().toLower
        if (choice == 'y'){
            if(customerService.delete(id)){
                println("---------------------删除完成---------------------")
                return
            }
        }
        println("---------------------删除没有完成---------------------")
    }
}
