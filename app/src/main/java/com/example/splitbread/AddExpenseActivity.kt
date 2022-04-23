package com.example.splitbread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class AddExpenseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        findViewById<Button>(R.id.donebutton).setOnClickListener{
            val description = findViewById<EditText>(R.id.expense_description).text.toString()
            val value = findViewById<EditText>(R.id.expense_amount).toString()
            val amount = value.toInt()

            addExpense(description, amount)
        }
    }

    // add expense for friends??

    private fun addExpense(description: String, amount: Int){
        val group = Groups()

        group.setDescription(description)
        group.setExpense(amount)

        Log.i(SignupActivity.TAG, "Expense Added")
        goToMainActivity()
    }

    private fun goToMainActivity() {
        val intent = Intent(this@AddExpenseActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}