package com.example.simplecrm.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplecrm.R
import com.example.simplecrm.data.DbAdapter
import kotlinx.android.synthetic.main.activity_contact.*
import kotlinx.android.synthetic.main.activity_contact.saveBtn

class ContactActivity : AppCompatActivity() {
    private var mDbAdapter: DbAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        initializeViews()
        initializeDatabase()


        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Contact Info"
        actionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FDB716")))


    }

    private fun initializeViews () {
        saveBtn.setOnClickListener {
            mDbAdapter?.insertContact(
                contact_name.text.toString(),
                email.text.toString(),
                phone.text.toString(),
                city.text.toString(),
                state.text.toString(),
                zip.text.toString()
            )

            val intent = Intent(this, ContactListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initializeDatabase() {
        mDbAdapter = DbAdapter(this@ContactActivity)
        mDbAdapter?.open()
    }
}