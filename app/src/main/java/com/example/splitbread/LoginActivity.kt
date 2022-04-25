package com.example.splitbread

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.parse.*
import java.security.AccessController.getContext

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

/*        if(ParseUser.getCurrentUser() != null){
            goToMainActivity()
        }*/

        findViewById<Button>(R.id.loginbutton).setOnClickListener{
            val email = findViewById<EditText>(R.id.emailInput).text.toString()
            val password = findViewById<EditText>(R.id.passwordInput).text.toString()
            loginUser(email, password)
        }
    }

    private fun loginUser(email: String, password: String) {
        ParseUser.logInInBackground(email, password, ({user, e ->
            if (user != null) {
                Log.i(TAG, "Successfully logged in user.")
                goToMainActivity()
            } else {
                e.printStackTrace()
                Toast.makeText(this, "Error logging in", Toast.LENGTH_SHORT).show()
            }})
        )
    }

    private fun goToMainActivity() {
        val move = Intent(this@LoginActivity,MainActivity::class.java)
        startActivity(move)
        finish()

       /* val intent = Intent(getContext(), IsActive::class.java)
        startActivity(intent)
        getActivity().finish() */

    }

    companion object{
        const val TAG = "LoginActivity"
    }

}