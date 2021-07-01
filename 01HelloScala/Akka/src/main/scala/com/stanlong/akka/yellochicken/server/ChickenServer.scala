package com.stanlong.akka.yellochicken.server

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.stanlong.akka.yellochicken.common.{ClientMessage, ServerMessage}
import com.typesafe.config.ConfigFactory

class ChickenServer extends Actor{
    override def receive: Receive = {
        case "start" =>{
            println("小黄鸡客服开始工作")
        }
        case ClientMessage(msg) =>{
            // 使用match case 匹配(模糊)
            msg match {
                case "姓名" => sender() ! ServerMessage("沈万三")
                case "性别" => sender() ! ServerMessage("男")
                case "年龄" => sender() ! ServerMessage("25")
                case _ => sender() ! ServerMessage("您问的什么?")
            }
        }
    }
}

// 主程序-入口
object ChickenServer extends App{

    val host = "127.0.0.1" //服务端ip地址
    val port = 9999
    //创建config对象,指定协议类型，监听的ip和端口
    val config = ConfigFactory.parseString(
        s"""
           |akka.actor.provider="akka.remote.RemoteActorRefProvider"
           |akka.remote.netty.tcp.hostname=$host
           |akka.remote.netty.tcp.port=$port
        """.stripMargin)

    // 创建ActorSystem
    val serverActorSystem =  ActorSystem("Server", config)

    // 创建ChickenServer的actor和返回的actorRef
    val chickenServerRef : ActorRef = serverActorSystem.actorOf(Props[ChickenServer], "ChickenServer")

    // 启动
    chickenServerRef ! "start"




}