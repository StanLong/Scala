package com.stanlong.akka.yellochicken.client

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.stanlong.akka.yellochicken.common.{ClientMessage, ServerMessage}
import com.typesafe.config.ConfigFactory

import scala.io.StdIn

class ChickenClient(serverHost:String, serverPort:Int) extends Actor{
    // 定义一个ChickServerRef
    var serverActorRef : ActorSelection = _

    // preStart() 将初始化的代码放在这个方法里
    override def preStart(): Unit = {
        // println("preStart 已被调用")
        serverActorRef = context.actorSelection(s"akka.tcp://Server@${serverHost}:${serverPort}/user/ChickenServer")

    }
    override def receive: Receive = {
        case "start" =>{
            println("客户端运行，可以咨询问题")
        }
        case msg:String=>{
            // 发送消息给服务端
            serverActorRef ! ClientMessage(msg) // 这里是使用了样例类的 apply 方法
        }
        case ServerMessage(msg)=>{
            println(s"接收到服务端的回复：$msg")
        }

    }
}


//  主程序入口
object ChickenClient extends App{
    val (clientHost,clientPort,serverHost,serverPort) = ("127.0.0.1",9990,"127.0.0.1",9999)
    val config = ConfigFactory.parseString(
        s"""
           |akka.actor.provider="akka.remote.RemoteActorRefProvider"
           |akka.remote.netty.tcp.hostname=$clientHost
           |akka.remote.netty.tcp.port=$clientPort
        """.stripMargin)

    // 创建ActorSystem
    val clientActorSystem =  ActorSystem("client", config)

    // 创建chickenClient的actor和返回的actorRef
    val chickenClientRef: ActorRef = clientActorSystem.actorOf(Props(new ChickenClient(serverHost, serverPort)), "ClientActor")

    // 启动， 发送start
    chickenClientRef ! "start"

    // 客户端发送消息给服务器
    while (true){
        println("请输入要咨询的问题：")
        val msg = StdIn.readLine()
        chickenClientRef ! msg
    }

}