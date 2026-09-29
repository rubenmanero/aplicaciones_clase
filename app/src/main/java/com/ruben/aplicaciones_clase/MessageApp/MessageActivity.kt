package com.ruben.aplicaciones_clase.MessageApp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.aplicaciones_clase.R

class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_message)

        val rootView = findViewById<View>(R.id.main) // tu ConstraintLayout raíz

        ViewCompat.setOnApplyWindowInsetsListener(rootView) { view, insets ->
            val imeHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            val navBarHeight = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom

            // Sube el contenedor del EditText la altura del teclado
            view.setPadding(
                view.paddingLeft,
                view.paddingTop,
                view.paddingRight,
                maxOf(imeHeight, navBarHeight)
            )
            insets
        }

        // Necesario para que el listener reciba los insets del teclado
        WindowCompat.setDecorFitsSystemWindows(window, false)

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