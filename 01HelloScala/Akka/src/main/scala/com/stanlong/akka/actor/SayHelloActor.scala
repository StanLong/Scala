package com.stanlong.akka.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

// 继承Actor， 重写receive方法
class SayHelloActor extends Actor{

    // 当该 Actor 的MailBox接收到消息，就会调用reveive
    // type Receive = PartialFunction[Any, Unit]
    override def receive: Receive = {
        case "hello" => println("收到Hello， 回应Hello too:)")
        case "ok" => println("收到ok， 回鹰ok too：)")
        case "exit" => {
            println("接收到exit指令，退出系统")
            context.stop(self) // 停止actorf
            context.system.terminate() // 退出actorsystem
        }
        case _ => println("匹配不到")

    }
}

object SayHelloActorDemo {

    // 1. 先创建一个 ActorSystem， 专门用于创建Actor
    private val  actoryFactory = ActorSystem("actoryFactory")
    // 2. 创建一个Actor的同时，返回Actor的ActorRef
    //  Props[SayHelloActor] 使用反射机制创建了一个SayHelloActor实例
    //  sayHelloActor 给actor取名
    //  sayHelloActorRef:ActorRef 就是 Props[SayHelloActor] 的 ActorRef
    //  创建的SayHelloActor实例被ActorSystem接管
    private val sayHelloActorRef:ActorRef = actoryFactory.actorOf(Props[SayHelloActor], "sayHelloActor")


    def main(args: Array[String]): Unit = {
        // 给SayHelloActor 发消息(邮箱)
        sayHelloActorRef ! "ok"
        sayHelloActorRef ! "exit"

    }

}
