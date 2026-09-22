package com.example.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
    }
}