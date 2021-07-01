package com.stanlong.akka.yellochicken.common

// 使用样例类来构建客户端发给服务端的协议，样例类默认实现序列化
case class ClientMessage(msg:String)


// 使用样例类来构建服务端发给客户端的协议，样例类默认实现序列化
case class ServerMessage(msg:String)