package com.example.simplecrm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplecrm.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        signUpBtn.setOnClickListener {
            val intent = Intent( this, SignUpActivity::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener {
            val intent = Intent( this, MainActivity::class.java)
            startActivity(intent)
        }

        /**forgotPassBtn.setOnClickListener{
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }*/
    }
}