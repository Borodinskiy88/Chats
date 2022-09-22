package ru.netology

import junit.framework.TestCase.*
import org.junit.Before
import org.junit.Test

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
//todo придумать тест
    @Test
    fun getListChatTest() {
        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11))
        val result = ChatService.getListChat()

    }

    @Test
    fun getChatsTest() {
        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11))
        val result = ChatService.getChats()
        assertTrue(result.isNotEmpty())
    }

//    @Test
//    fun getNotEmptyChatTest() {
//        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11))
//        ChatService.addMessage(2, Message(1, "Hello", 1.23, 11.11))
//        val chat: String = ChatService.getNotEmptyChat().toString()
//        assertEquals(2, chat)
//
//    }

    @Test
    fun getNotEmptyChatTest() {
        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11))
        ChatService.addMessage(2, Message(1, "Hello", 1.23, 11.11))
        val chat = ChatService.getNotEmptyChat().size
        assertEquals(2, chat)

    }

}


