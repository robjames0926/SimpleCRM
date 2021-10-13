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
import kotlinx.android.synthetic.main.activity_quote_list.*
import kotlinx.android.synthetic.main.activity_quote_list.add_new

class QuoteListActivity : AppCompatActivity() {
    private var mDbAdapter: DbAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_list)
        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Quotes"
        actionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FDB716")))

        add_new.setOnClickListener {
            val intent = Intent(this, QuoteActivity::class.java)
            startActivity(intent)
        }

        initializeDatabase()
        loadList()

    }

    private fun initializeDatabase() {
        mDbAdapter = DbAdapter(this@QuoteListActivity)
        mDbAdapter?.open()
    }

    private fun loadList(){
        val allQuotes: List<String>? = mDbAdapter?.selectALLQuotes()
        val adapter = ArrayAdapter(
            this@QuoteListActivity,
            android.R.layout.simple_list_item_1,
            allQuotes?: emptyList()
        )
        quote_list.adapter = adapter
    }
}