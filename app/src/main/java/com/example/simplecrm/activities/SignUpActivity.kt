package com.example.simplecrm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.simplecrm.R
import com.example.simplecrm.data.DbAdapter
import kotlinx.android.synthetic.main.activity_contact.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_signup.email

class SignUpActivity : AppCompatActivity() {
    private var mDbAdapter: DbAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()



        initializeDatabase()
        initializeViews()

    }

    private fun initializeViews () {
        val password1: TextView = findViewById (R.id.password)
        val password2: TextView = findViewById (R.id.confirm_password)


        signUpBtn.setOnClickListener {
            if (password1 === password2) {
                mDbAdapter?.insertUser(
                    firstName.text.toString(),
                    lastName.text.toString(),
                    email.text.toString(),
                    username.text.toString(),
                    password.text.toString(),
                )
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    applicationContext,
                    "The passwords entered did not match, please try again!",
                    Toast.LENGTH_SHORT
                )
            }
        }
    }

    private fun initializeDatabase() {
        mDbAdapter = DbAdapter(this@SignUpActivity)
        mDbAdapter?.open()
    }
}