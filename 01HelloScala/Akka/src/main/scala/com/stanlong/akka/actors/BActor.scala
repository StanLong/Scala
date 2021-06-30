package com.stanlong.akka.actors

import akka.actor.Actor

class BActor extends Actor{
    override def receive: Receive = {
        case "Hello" =>{

            // 通过sender() 可以获取到发送消息的actorRef
            println("How are you")
            Thread.sleep(1000)
            sender() ! "How are you"
        }

    }
}
