package com.stanlong.erp.bean

class Customer {
    // 属性
    var id:Int = _
    var name:String = _
    var gender:Char = _
    var age:Short = _
    var tel:String = _
    var email:String = _

    // 设计一个辅助构造器
    def this(id:Int, name:String,gender:Char,age:Short,tel:String, email:String){
        this
        this.id = id
        this.name = name
        this.gender = gender
        this.age = age
        this.tel = tel
        this.email = email
    }
}
