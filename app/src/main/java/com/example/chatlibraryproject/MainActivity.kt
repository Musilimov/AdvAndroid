package com.example.testapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.chatlibrary.ChatLibrary
import missing.namespace.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openChatButton: Button = findViewById(R.id.openChatButton)
        openChatButton.setOnClickListener {
            // Открыть чат
            ChatLibrary.start(this)
        }
    }
}
