package com.example.splitbread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class AddFriendsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_friends)

        findViewById<ImageView>(R.id.addfriend_button).setOnClickListener {

            val friendName = findViewById<EditText>(R.id.friendinput).text.toString()

            addFriend(friendName)
        }
    }

    fun addFriend(friendName: String) {
        val friend = Friends()

        friend.setFriendsName(friendName)

        friend.saveInBackground { exception ->
            if (exception != null) {
                Log.e(StartGroupActivity.TAG, "Error while saving")
                exception.printStackTrace()
                Toast.makeText(this, "Error saving", Toast.LENGTH_SHORT).show()
            } else {
                Log.i(StartGroupActivity.TAG, "Successfully saved")
                goToAddExpenseActivity()
            }
        }
    }

    private fun goToAddExpenseActivity() {
        val intent = Intent(this@AddFriendsActivity, AddExpenseActivity::class.java)
        startActivity(intent)
        finish()
    }

}