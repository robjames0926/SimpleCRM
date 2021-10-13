package com.example.simplecrm.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplecrm.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Home"
        actionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FDB716")))

        accountsBtn.setOnClickListener {
            val intent = Intent( this, AccountListActivity::class.java)
            startActivity(intent)
        }

        contactsBtn.setOnClickListener {
            val intent = Intent( this, ContactListActivity::class.java)
            startActivity(intent)
        }

        quotesBtn.setOnClickListener {
            val intent = Intent( this, QuoteListActivity::class.java)
            startActivity(intent)
        }

        taskBtn.setOnClickListener {
            val intent = Intent( this, TaskListActivity::class.java)
            startActivity(intent)
        }

        settingsBtn.setOnClickListener {
            val intent = Intent( this, PreferencesActivity::class.java)
            startActivity(intent)
        }

        helpBtn.setOnClickListener {
            val intent = Intent( this, HelpActivity::class.java)
            startActivity(intent)
        }
    }
}