package com.stanlong.erp.service

import com.stanlong.erp.bean.Customer

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}

class CustomerService {

    // 初始id
    var customerId = 1

    var customers = ArrayBuffer(new Customer(1, "沈万三", '男', 24, "100", "shenwansan@ming.com"))

    // 客户列表
    def list():ArrayBuffer[Customer]={
        this.customers
    }

    // 添加客户
    def add(customer: Customer):Boolean = {
        // 设置id
        customerId += 1
        customer.id = customerId
        customers.append(customer)
        true
    }

    // 查找单个用户在ArrayBuffer的下标索引
    def findById(id:Int): Int ={
        var index = -1 // 如果找到就返回对应的id，没找到就返回-1
        breakable{
            for(i <- 0 until customers.length){
                if(customers(i).id == id){
                    index = i
                    break()
                }
            }

        }
        index
    }

    // 查找单个用户
    def findCustomerById(id:Int):Customer={
        val customer = customers(id-1)
        return customer
    }

    // 修改客户
    def update(customer: Customer):Boolean={
        val id = customer.id
        customers(id-1) = customer
        true
    }


    // 删除
    def delete(id:Int):Boolean={
        val index = findById(id)
        if (index != -1){
            customers.remove(index)
            true
        }else{
            false
        }
    }
}
