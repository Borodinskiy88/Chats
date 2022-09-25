package ru.netology

import junit.framework.TestCase.*
import org.junit.Before
import org.junit.Test
import kotlin.reflect.KClass

class NoteTest {
    @Before
    fun clearBeforeTest() {
        ChatService.clear()
    }

    @Test
    fun getUnreadChatCountTest() {
        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11))
        val result = ChatService.getUnreadChatCount()
        assertEquals(1, result)
    }

    @Test
    fun deleteChatTest() {
        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11))
        ChatService.deleteChat(1)
        val result = ChatService.getChats()
        assertEquals(emptyMap<Int, Chat>(), result)
    }

    @Test
    fun getChatsTest() {
        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11))
        val result = ChatService.getChats()
        assertTrue(result.isNotEmpty())
    }

    @Test
    fun getNotEmptyChatTest() {
        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11))
        ChatService.addMessage(2, Message(2, "Hi", 2.23, 22.22))
        val chat = ChatService.getNotEmptyChat().size
        assertEquals(2, chat)
    }

    @Test
    fun getMessagesTest() {
        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11, true))
        ChatService.addMessage(2, Message(2, "Hi", 2.23, 22.22, true))
        ChatService.addMessage(2, Message(3, "Bye", 0.23, 00.11, false))
        val list = listOf<Message>(Message(1, "Hello", 1.23, 11.11, true))
        val chat = ChatService.getMessages(1, 10)
        val result = list == chat
        assertEquals(true, result)
    }

    @Test
    fun addMessageTest() {
        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11, true))
        ChatService.addMessage(2, Message(2, "Hi", 2.23, 22.22, true))
        val result = ChatService.getChats()
        assertTrue(result.isNotEmpty())
    }

    @Test
    fun deleteMessageTest() {
        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11, true))
        ChatService.deleteMessage(1, Message(1, "Hello", 1.23, 11.11, true))
        val result = ChatService.getChats()
        assertTrue(result.isEmpty())
    }

    @Test
    fun updateMessageTest() {
        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11, true))
        val newMessage = Message(111, "NewMessage", 31.12, 22.22, false)
        val update = ChatService.updateMessage(
            1, message = Message(1, "Hello", 1.23, 11.11, true),
            newMessage = Message(111, "NewMessage", 31.12, 22.22, false)
        )
        val result = newMessage == update
        assertEquals(true, result)
    }

    @Test
    fun sizeTest() {
        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11, true))
        val result = ChatService.size()
        assertEquals(1, result)
    }

}

