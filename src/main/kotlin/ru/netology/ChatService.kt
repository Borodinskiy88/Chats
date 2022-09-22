package ru.netology


object ChatService {
    private val chats = mutableMapOf<Int, Chat>() //Int - id пользователя

    fun getChats(): MutableMap<Int, Chat> {
        return chats
    }

    fun size(): Int {
        return chats.values.size
    }

//todo++    //todo 2. Удаление чата (целиком удаляется вся переписка)
    fun deleteChat(userId: Int) = chats.remove(userId)

    //todo 3. Получение списка чатов //Получить весь список чатов, посмотреть в прошлой работе
    fun getListChat() = chats.forEach { (println(it)) }


//todo+++    //todo 4. Получение количества непрочитанных чатов
    fun getUnreadChatCount(): Int {
        return chats.values.count { chat: Chat -> chat.messages.any { !it.read } }
    }


    //todo 5. Получение списка чатов, где есть последнее сообщение, не пустых// Посмотреть еще, коряво как-то
    fun getNotEmptyChat() {
        if (chats.isNotEmpty()) return chats.forEach { println(it) }
    }

    //todo 6. Получение списка сообщений из чата
    fun getMessages(userId: Int, count: Int): List<Message> {  //count - количество сообщений,
        // которое мы хотим увидеть. count можно заменить на другой параметр, messageId возможно
        val chat = chats[userId] ?: throw NoChatException()
        return chat.messages.takeLast(count).onEach { it.read = true }
    }

    //
//Функции Мессадж:
//todo 1. Создание сообщения
    fun addMessage(userId: Int, message: Message) {
        chats.getOrPut(userId) { Chat() }.messages.add(message)
//        if (chats[userId] != null) {
//            chats[userId]?.messages?.add(message)
//        } else {
//            val chat = Chat()
//            chat.messages += message
//            chats[userId] = chat
//        }
    }

    fun printChats() {
        println(chats)
    }

    //todo 2. Удаление сообщения (при удалении последнего сообщения в чате весь чат удаляется)
    fun deleteMessage(userId: Int, message: Message)  { //Удалить сообщение из чата,
        // если удаляешь единственное, удаляется весь чат
        //todo Нужно ли что-то возвращать? Наверное нет
//        val clear = ::deleteChat
        chats[userId]?.messages?.remove(message)
        if (chats[userId]?.messages?.isEmpty() == true) {chats.remove(userId)}
      //  val clear = ::deleteChat
    }

    //todo 3. Редактирование сообщения Корявенько вышло
    fun updateMessage(userId: Int, message: Message, newMessage: Message) {

//        chats[userId]?.messages = newMessage.copy(messageId = newMessage.messageId, text = newMessage.text,
//        date = newMessage.date, time = newMessage.time, read = newMessage.read)

        chats[userId]?.messages?.remove(message)
        chats[userId]?.messages?.add(newMessage)

//        val newChat = chats[userId]
//      //  val newMessage = Message(1)
//
//        if (newChat != null) {
//            chats[userId] = newChat.copy(messages = newChat.messages)
//        }
//
//        return newMessage
        //Использовать функцию put
        //      message.messageId.
        //       chats.getOrPut(messageId) { Chat(mutableListOf()) }.messages = newMessage
        //       if (newMessage.messageId == messageId) newMessage.copy()
 //       chat.messages.removeAt(messageId)
 //       chats[userId] = Chat()

 //       chats.values.removeAt(message) //{ chat: Chat -> chat.messages.remove(newMessage) }
//        return chat.messages.filter { message: Message -> message.messageId == newMessage.messageId }
 //       chats.remove(message) { message: Message -> message.messageId == newMessage.messageId }
//        chat.messages == newMessage { message: Message -> message.messageId == messageId }

    }

    fun clear() {
        chats.clear()

    }

}



