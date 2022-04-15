package com.example.splitbread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.parse.ParseUser

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

/*        if(ParseUser.getCurrentUser() != null){
            goToMainActivity()
        }*/

        findViewById<Button>(R.id.done_button).setOnClickListener{
            val name = findViewById<EditText>(R.id.name_Input).text.toString()
            val email = findViewById<EditText>(R.id.email_Input).text.toString()
            val phone = findViewById<EditText>(R.id.phone_Input).text.toString()
            val password = findViewById<EditText>(R.id.password_Input).text.toString()
            signUpUser(name, email, phone, password)
        }

        findViewById<Button>(R.id.done_button).setOnClickListener{
            val name = findViewById<EditText>(R.id.name_Input).text.toString()
            val email = findViewById<EditText>(R.id.email_Input).text.toString()
            val password = findViewById<EditText>(R.id.password_Input).text.toString()
            signUpUser(name, email, password)
        }
    }

    private fun signUpUser(name: String, email: String, phone: String, password: String){
        // Create the ParseUser
        val user = ParseUser()

        // Set fields for the user to be created
        user.setUsername(name)
        user.setEmail(email)
        user.put("phone", phone)
        user.setPassword(password)

        user.signUpInBackground { e ->
            if (e == null) {
                // Successful signup
                Log.i(TAG, "Successfully Signed up user.")
                goToMainActivity()
                Toast.makeText(this, "Successfully signed up", Toast.LENGTH_SHORT).show()
            } else {
                e.printStackTrace()
                Toast.makeText(this, "Error signing up", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signUpUser(name: String, email: String, password: String){
        // Create the ParseUser
        val user = ParseUser()

        // Set fields for the user to be created
        user.setUsername(name)
        user.setEmail(email)
        user.setPassword(password)

        user.signUpInBackground { e ->
            if (e == null) {
                // Successful signup
                Log.i(TAG, "Successfully Signed up user.")
                goToMainActivity()
                Toast.makeText(this, "Successfully signed up", Toast.LENGTH_SHORT).show()
            } else {
                e.printStackTrace()
                Toast.makeText(this, "Error signing up", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(this@SignupActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


    companion object{
        const val TAG = "SignupActivity"
    }
}