package ru.netology

class NoChatException : RuntimeException()

fun main() {
    ChatService.addMessage(1, Message(1, "Hello", 1.03, 11.11))
    ChatService.addMessage(1, Message(2, "Hi", 2.03, 11.22))
    ChatService.addMessage(2, Message(3, "Bye", 2.04, 11.33))
    ChatService.printChats()
    println(ChatService.getMessages(1, 1))
    ChatService.printChats()
    println(ChatService.getUnreadChatCount())
    ChatService.deleteMessage(2, Message(3, "Bye", 2.03, 11.33))
    ChatService.updateMessage(1, 1, newMessage = Message(8, "44", 4.04, 4.44))
    ChatService.getListChat()

}