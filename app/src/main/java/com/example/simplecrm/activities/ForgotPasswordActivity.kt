package com.example.simplecrm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplecrm.R
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        supportActionBar?.hide()

        forgotUsername.setOnClickListener {
            val intent = Intent(this, ForgotUsernameActivity::class.java)
            startActivity(intent)
        }

    }
}