package com.example.splitbread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        val btnAddFriends = findViewById<Button>(R.id.addFriends)

        btnAddFriends.setOnClickListener{
            startActivity(Intent(this,AddFriendsActivity::class.java))
        }


    }
}