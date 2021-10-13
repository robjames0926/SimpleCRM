package com.example.simplecrm.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.simplecrm.R
import com.example.simplecrm.data.DbAdapter
import kotlinx.android.synthetic.main.activity_account_list.*

class AccountListActivity : AppCompatActivity() {
    private var mDbAdapter: DbAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_list)

        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Accounts"
        actionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FDB716")))

        add_new.setOnClickListener {
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
        }

        initializeDatabase()
        loadList()

    }

    private fun initializeDatabase() {
        mDbAdapter = DbAdapter(this@AccountListActivity)
        mDbAdapter?.open()
    }

    private fun loadList(){
        val allAccounts: List<String>? = mDbAdapter?.selectAllAccounts()
        val adapter = ArrayAdapter(
            this@AccountListActivity,
           android.R.layout.simple_list_item_1,
           allAccounts?: emptyList()
        )
        account_list.adapter = adapter
    }
}