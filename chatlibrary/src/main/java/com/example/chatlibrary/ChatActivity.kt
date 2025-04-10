package com.example.chatlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatlibrary.databinding.ActivityChatBinding
import okhttp3.*
import okio.ByteString

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    private lateinit var adapter: ChatAdapter
    private lateinit var webSocket: WebSocket

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ChatAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        initWebSocket()

        binding.sendButton.setOnClickListener {
            val msg = binding.messageInput.text.toString()
            if (msg.isNotBlank()) {
                adapter.addMessage(ChatMessage(msg, isSentByUser = true))
                webSocket.send(msg)
                binding.messageInput.text.clear()
            }
        }
    }

    private fun initWebSocket() {
        val client = OkHttpClient()
        val request = Request.Builder().url("wss://echo.websocket.org").build()
        webSocket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onMessage(webSocket: WebSocket, text: String) {
                runOnUiThread {
                    val message = if (text == "203 = 0xcb") "📡 Специальное сообщение от сервера" else text
                    adapter.addMessage(ChatMessage(message, isSentByUser = false))
                }
            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                runOnUiThread {
                    adapter.addMessage(ChatMessage("📡 Специальные байты: $bytes", isSentByUser = false))
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        webSocket.close(1000, "Activity closed")
    }
}
