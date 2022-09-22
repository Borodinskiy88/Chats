package ru.netology

import junit.framework.TestCase.assertEquals
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

    @Test
    fun getListChatTest() {
        val chat = ChatService.getListChat()
        ChatService.addMessage(1, Message(1, "Hello", 1.23, 11.11))
        ChatService.getListChat()
        val result = ChatService.getChats()
        assertEquals(chat[0], result)

    }
}