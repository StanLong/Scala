package com.stanlong.akka.actors

import akka.actor.{Actor, ActorRef}

class AActor(actorRef : ActorRef) extends Actor{

    val bActorRef:ActorRef = actorRef

    override def receive: Receive = {
        case "start" => {
            println("Hi")
            self ! "Hi"
        }
        case "Hi" => {
            // 给BActor发出消息
            // 这里需要持有BActor的引用（BActorRef）
            println("Hello")
            Thread.sleep(1000)
            bActorRef ! "Hello"
        }

        case "How are you" =>{
            println("I'm fine, Thank you")
            bActorRef ! "I'm fine, Thank you"
        }
    }
}
