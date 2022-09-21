package ru.netology

data class Chat(
    var messages: MutableList<Message> = mutableListOf()
)

data class Message(
    val messageId: Int,
    val text: String = "",
    val date: Double = 01.01,
    val time: Double = 00.00,
    var read: Boolean = false
)
//data class Chats(
//    val userId: Int = 0,
//    val friendId: Int = 0,
//    val chatCount: Int = 0,
//    val messages: MutableList<Message> = mutableListOf()
//)

