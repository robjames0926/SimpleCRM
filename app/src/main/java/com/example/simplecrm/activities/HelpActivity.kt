package com.example.simplecrm.activities

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplecrm.R
import kotlinx.android.synthetic.main.activity_help.*


class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Help"
        actionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FDB716")))

        var accountLabel: String = "New Account Creation:"
        var accountHelp: String = "To create a new account, return to the main screen and click the account icon, the app will re-directed you to the account list page. At the bottom of the list page, you will find an \"Add\" button, click the button. After clicking add, you will be directed to the account info page. Fill in the fields and then hit the \"Save\" button at the bottom of the form. After saving the app will take you back to the account list page and your record will be displayed. Congrats, you just created your first account record."

        var contactLabel: String = "New Contact Creation:"
        var contactHelp: String = "To create a new contact, return to the main screen and click the contact icon, the app will re-directed you to the contact list page. At the bottom of the list page, you will find an \"Add\" button, click the button. After clicking add, you will be directed to the contact info page. Fill in the fields and then hit the \"Save\" button at the bottom of the form. After saving the app will take you back to the contact list page and your record will be displayed. Congrats, you just created your first contact record."

        var quoteLabel: String = "New Quote Creation:"
        var quoteHelp: String = "To create a new quote, return to the main screen and click the quote icon, the app will re-directed you to the quote list page. At the bottom of the list page, you will find an \"Add\" button, click the button. After clicking add, you will be directed to the quote info page. Fill in the fields and then hit the \"Save\" button at the bottom of the form. After saving the app will take you back to the quote list page and your record will be displayed. Congrats, you just created your first quote record."

        var taskLabel: String = "New Task Creation:"
        var taskHelp: String = "To create a new task, return to the main screen and click the task icon, the app will re-directed you to the task list page. At the bottom of the list page, you will find an \"Add\" button, click the button. After clicking add, you will be directed to the task info page. Fill in the fields and then hit the \"Save\" button at the bottom of the form. After saving the app will take you back to the task list page and your record will be displayed. Congrats, you just created your first task record."

        accountBtn.setOnClickListener {
            label.setText(accountLabel)
            help_text.setText(accountHelp)
        }

        contactBtn.setOnClickListener {
            label.setText(contactLabel)
            help_text.setText(contactHelp)
        }

        quoteBtn.setOnClickListener {
            label.setText(quoteLabel)
            help_text.setText(quoteHelp)
        }

        taskbtn.setOnClickListener {
            label.setText(taskLabel)
            help_text.setText(taskHelp)
        }



    }
}