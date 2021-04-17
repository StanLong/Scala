package com.stanlong.scala

/**
 * 抽象类
 */
object Exercise01 {
    def main(args: Array[String]): Unit = {
        val bank = new Bank("StanLong", 100.00, "123456")
        //bank.query("StanLong", "123456")
        //bank.withdraw("StanLong", "123456", 10.00)
        bank.save("StanLong", "123456", 10.00)

    }
}

/**
 * 属性：账号，余额，密码
 * 方法：查询，存款，取款
 */
class Bank(inAccount:String, inBalance:Double, inPwd:String){
    val accountNo = inAccount
    val balance = inBalance
    var pwd = inPwd

    // 查询
    def query(accountNo:String, pwd:String):Unit={
        if(!this.accountNo.equals(accountNo) && !this.pwd.equals(pwd)){
            println("用户名或密码错误！")
            return
        }
        printf("账号为 %s 当前余额是%.2f\n", this.accountNo, this.balance)
    }

    // 取钱
    def withdraw(accountNo:String, pwd:String, balance:Double): Unit ={
        if(balance > this.balance){
            println("余额补足")
        }else{
            printf("%s 取出金额 %.2f， 剩余金额%.2f", this.accountNo, this.balance, (this.balance-balance))
        }
    }

    // 存钱
    def save(accountNo:String, pwd:String, balance:Double): Unit ={
        printf("%s 取出金额 %.2f， 剩余金额%.2f", this.accountNo, this.balance, (this.balance+balance))
    }
}



