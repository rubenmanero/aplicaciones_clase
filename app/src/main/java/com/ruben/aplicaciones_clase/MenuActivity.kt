package com.ruben.aplicaciones_clase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.aplicaciones_clase.BoardgamesApp.BoardgamesActivity
import com.ruben.aplicaciones_clase.HelloApp.MainActivity
import com.ruben.aplicaciones_clase.ImcApp.ImcActivity
import com.ruben.aplicaciones_clase.MessageApp.MessageActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        btnHelloApp.setOnClickListener { navigateToHelloApp() }

        val btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        btnMessageApp.setOnClickListener { navigateToMessageApp() }

        val btnImcApp = findViewById<Button>(R.id.btnImcApp)
        btnImcApp.setOnClickListener { navigateToImcApp() }

        val btnBoardgamesApp = findViewById<Button>(R.id.btnBoardgamesApp)
        btnBoardgamesApp.setOnClickListener { navigateToBoardgamesApp() }
    }

    private fun navigateToHelloApp() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToMessageApp() {
        val intent = Intent(this, MessageActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToImcApp() {
        val intent = Intent(this, ImcActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToBoardgamesApp() {
        val intent = Intent(this, BoardgamesActivity::class.java)
        startActivity(intent)
    }
}