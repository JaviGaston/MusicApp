package com.example.musicapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonPause: ImageButton = findViewById(R.id.imageButtonPause)
        val buttonPlay: ImageButton = findViewById(R.id.imageButtonplay)
        buttonPlay.setOnClickListener {
            buttonPlay.visibility = View.INVISIBLE
            buttonPause.visibility = View.VISIBLE
        }
        buttonPause.setOnClickListener {
            buttonPause.visibility = View.GONE
            buttonPlay.visibility = View.VISIBLE
        }
    }
}