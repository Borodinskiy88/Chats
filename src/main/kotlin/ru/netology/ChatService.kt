package ru.netology

//import com.sun.org.apache.xml.internal.serializer.utils.Utils.messages


object ChatService {
    private val chats = mutableMapOf<Int, Chat>() //Int - id пользователя

    fun size(): Int {
        return chats.values.size
    }

    //Функции Чатс:
//todo 1. Создание чата (автоматически, после отправки первого сообщения)
    fun createChat() {

    }

    //todo 2. Удаление чата (целиком удаляется вся переписка)
    fun deleteChat(userId: Int) = chats.remove(userId)

    //todo 3. Получение списка чатов //Получить весь список чатов, посмотреть в прошлой работе
    fun getListChat() = chats.forEach { (println(it)) }


    //todo 4. Получение количества непрочитанных чатов
    fun getUnreadChatCount(): Int {
        return chats.values.count { chat: Chat -> chat.messages.any { !it.read } }
    }


    //todo 5. Получение списка чатов, где есть последнее сообщение, не пустых// Посмотреть еще, коряво как-то
    fun getNotEmptyChat() { //Получить список чатов, из нот эмпти использовать
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

    //2. Удаление сообщения (при удалении последнего сообщения в чате весь чат удаляется)
    fun deleteMessage(){ //Удалить сообщение из чата,
        // если удаляешь единственное, удаляется весь чат
     //   Chat().messages.removeAt(messageId)
//        val chat = 1 to message
//        val mes = messageId to message
 //       return chat.messages.remove(mes) { message.messageId == messageId}
 //       return chat.messages.removeIf { message.messageId == messageId}
 //       println(Chat().messages.size)
        val chat = Chat()
        chats.keys.size
//        chats.values-=(Message(1))
      //  Chat().messages.size
      // chats.values.remove(userId, message)
      //  Chat().messages.removeAt(userId)

//        val chat = Chat().messages
//        chat.removeAt(messageId)
 //       val del = deleteChat()

    }

    fun size2() = Chat().messages.size > 0



    //3. Редактирование сообщения
    fun updateMessage(userId: Int, newMessage: Message): Message {
        val newChat = chats[userId]
      //  val newMessage = Message(1)

        if (newChat != null) {
            chats[userId] = newChat.copy(messages = newChat.messages)
        }

        return newMessage
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

}


