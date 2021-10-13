package com.example.simplecrm.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.simplecrm.R
import com.example.simplecrm.data.DbAdapter
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_account_list.*

class AccountActivity : AppCompatActivity() {
    private var mDbAdapter: DbAdapter? = null
    private val mAllAccounttypes = arrayOf("Commercial", "Residental")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        initializeViews()
        initializeDatabase()


        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Account Info"
        actionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FDB716")))


    }

    private fun initializeViews () {
        account_type.adapter = ArrayAdapter(this@AccountActivity, android.R.layout.simple_list_item_1, mAllAccounttypes)

        saveBtn.setOnClickListener {
            mDbAdapter?.insertAccount(
                account_name.text.toString(),
                account_type.selectedItemPosition + 1,
                email.text.toString(),
                phone.text.toString(),
                city.text.toString(),
                state.text.toString(),
                zip.text.toString()
            )

            val intent = Intent(this, AccountListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initializeDatabase() {
        mDbAdapter = DbAdapter(this@AccountActivity)
        mDbAdapter?.open()
    }
}