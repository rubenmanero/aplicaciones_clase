package com.ruben.aplicaciones_clase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_message)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var tvTitle = findViewById<TextView>(R.id.tvTitle)
        var tvMessage = findViewById<TextView>(R.id.tvMessage)
        var etMessage = findViewById<EditText>(R.id.etMessage)
        var btnSend = findViewById<Button>(R.id.btnSend)

        var received: String = intent.extras?.getString("message").orEmpty()
        tvMessage.text = received

        if(received.isNotEmpty()) tvTitle.text = "Reply received!"

        btnSend.setOnClickListener{
            var message = etMessage.text.toString()
            if (message.isNotBlank()){
                var intent = Intent(this, ReplyActivity::class.java)
                intent.putExtra("message",message)
                startActivity(intent)
            }
        }
    }
}