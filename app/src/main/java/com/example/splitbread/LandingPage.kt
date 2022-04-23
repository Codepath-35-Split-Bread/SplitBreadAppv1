package com.example.splitbread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class LandingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        val btnLgn = findViewById<Button>(R.id.btnLgn)
        val btnSign = findViewById<Button>(R.id.btnSign)

        btnLgn.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }

        btnSign.setOnClickListener{
            startActivity(Intent(this,SignupActivity::class.java))
        }
    }
}


