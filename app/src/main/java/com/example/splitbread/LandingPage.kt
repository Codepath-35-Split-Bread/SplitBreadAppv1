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
/*
        val btnLgn = findViewById<Button>(R.id.btnLgn)
        val btnSign = findViewById<Button>(R.id.btnSign)*/

        findViewById<Button>(R.id.btnLgn).setOnClickListener{
            goLoginActivity()
        }

        findViewById<Button>(R.id.btnSign).setOnClickListener{
            goSignupActivity()
        }
    }

    private fun goLoginActivity() {
        val intent = Intent(this@LandingPage, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goSignupActivity() {
        val intent = Intent(this@LandingPage, SignupActivity::class.java)
        startActivity(intent)
        finish()
    }
}

