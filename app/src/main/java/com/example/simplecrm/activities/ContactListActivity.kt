package com.example.simplecrm.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.simplecrm.R
import com.example.simplecrm.data.DbAdapter
import kotlinx.android.synthetic.main.activity_contact_list.*

class ContactListActivity : AppCompatActivity() {
    private var mDbAdapter: DbAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Contacts"
        actionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FDB716")))

        add_new.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }

        initializeDatabase()
        loadList()

    }

    private fun initializeDatabase() {
        mDbAdapter = DbAdapter(this@ContactListActivity)
        mDbAdapter?.open()
    }

    private fun loadList(){
        val allContacts: List<String>? = mDbAdapter?.selectAllContacts()
        val adapter = ArrayAdapter(
            this@ContactListActivity,
            android.R.layout.simple_list_item_1,
            allContacts?: emptyList()
        )
        contact_list.adapter = adapter
    }
}