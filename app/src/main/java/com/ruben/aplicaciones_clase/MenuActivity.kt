package com.ruben.aplicaciones_clase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.aplicaciones_clase.BoardgamesApp.BoardgamesActivity
import com.ruben.aplicaciones_clase.Examen2024Dual.MemoryActivity
import com.ruben.aplicaciones_clase.HelloApp.MainActivity
import com.ruben.aplicaciones_clase.ImcApp.ImcActivity
import com.ruben.aplicaciones_clase.MessageApp.MessageActivity
import com.ruben.aplicaciones_clase.ReviewApp.ReviewActivity
import com.ruben.aplicaciones_clase.SuperheroApp.SuperheroListActivity
import kotlin.jvm.java

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        btnHelloApp.setOnClickListener { navigateToHelloApp() }

        val btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        btnMessageApp.setOnClickListener { navigateToMessageApp() }

        val btnImcApp = findViewById<Button>(R.id.btnImcApp)
        btnImcApp.setOnClickListener { navigateToImcApp() }

        val btnBoardgamesApp = findViewById<Button>(R.id.btnBoardgamesApp)
        btnBoardgamesApp.setOnClickListener { navigateToBoardgamesApp() }

        val btnSuperheroApp = findViewById<Button>(R.id.btnSuperheroApp)
        btnSuperheroApp.setOnClickListener { navigateToSuperheroApp() }

        val btnReviewApp = findViewById<Button>(R.id.btnReviewApp)
        btnReviewApp.setOnClickListener { navigateToReviewApp() }

        val btnMemoryApp = findViewById<Button>(R.id.btnMemory)
        btnMemoryApp.setOnClickListener { navigateToMemoryApp() }
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

    private fun navigateToSuperheroApp() {
        val intent = Intent(this, SuperheroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToReviewApp() {
        val intent = Intent(this, ReviewActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToMemoryApp() {
        val intent = Intent(this, MemoryActivity::class.java)
        startActivity(intent)
    }
}