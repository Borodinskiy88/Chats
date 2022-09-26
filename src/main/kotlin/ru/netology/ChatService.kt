package ru.netology


object ChatService {
    private val chats = mutableMapOf<Int, Chat>()

    fun getChats(): MutableMap<Int, Chat> = chats


    fun size(): Int = chats.values.size


    fun deleteChat(userId: Int) = chats.remove(userId)


    fun getListChat() = chats.forEach { (println(it)) }


    fun getUnreadChatCount(): Int {
        return chats.values.count { chat: Chat -> chat.messages.any { !it.read } }
    }


    fun getNotEmptyChat(): Map<Int, Chat> {
        return chats.filter { chats.isNotEmpty() }
    }


    fun getMessages(userId: Int, count: Int): List<Message> {
        val chat = chats[userId] ?: throw NoChatException()
        return chat.messages.takeLast(count).onEach { it.read = true }
    }


    fun addMessage(userId: Int, message: Message) {
        chats.getOrPut(userId) { Chat() }.messages.add(message)
    }

    fun printChats() {
        println(chats)
    }


    fun deleteMessage(userId: Int, message: Message) {
        chats[userId]?.messages?.remove(message)
        chats[userId]?.messages?.ifEmpty { chats.remove(userId) }
    }


    fun updateMessage(userId: Int, indexMessage: Int, newMessage: Message): Message {
        chats[userId]?.messages?.set(indexMessage - 1, newMessage)
        return newMessage
    }


    fun clear() {
        chats.clear()
    }

}


