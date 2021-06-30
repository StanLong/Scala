package com.stanlong.akka.actors

import akka.actor.{ActorRef, ActorSystem, Props}

object ActorGame extends App{

    // 创建ActorSystem
    val actoryfactory = ActorSystem("actorfactory")

    // 创建BActorRef
    val bActorRef:ActorRef = actoryfactory.actorOf(Props[BActor], "bActor")

    // 创建AActorRef, AActor有参数，需要用new的形式实现反射
    val aActorRef:ActorRef = actoryfactory.actorOf(Props(new AActor(bActorRef)), "aActor")

    // aActor 说话
    aActorRef ! "start"

}
