package com.example.simplecrm.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplecrm.R
import com.example.simplecrm.data.DbAdapter
import kotlinx.android.synthetic.main.activity_contact.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quote.*
import kotlinx.android.synthetic.main.activity_quote.saveBtn

class QuoteActivity : AppCompatActivity() {
    private var mDbAdapter: DbAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)
        initializeViews()
        initializeDatabase()


        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Quote Info"
        actionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FDB716")))


    }

    private fun initializeViews () {
        saveBtn.setOnClickListener {
            mDbAdapter?.insertQuote(
                quote_name.text.toString(),
                product_name.text.toString(),
                cost.text.toString()
            )

            val intent = Intent(this, QuoteListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initializeDatabase() {
        mDbAdapter = DbAdapter(this@QuoteActivity)
        mDbAdapter?.open()
    }
}