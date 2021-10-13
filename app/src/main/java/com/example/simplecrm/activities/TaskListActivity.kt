package com.example.simplecrm.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.simplecrm.R
import com.example.simplecrm.data.DbAdapter
import kotlinx.android.synthetic.main.activity_quote_list.*
import kotlinx.android.synthetic.main.activity_task_list.*
import kotlinx.android.synthetic.main.activity_task_list.add_new

class TaskListActivity : AppCompatActivity() {
    private var mDbAdapter: DbAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)
        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Task"
        actionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FDB716")))

        add_new.setOnClickListener {
            val intent = Intent(this, TaskActivity::class.java)
            startActivity(intent)
        }

        initializeDatabase()
        loadList()

    }

    private fun initializeDatabase() {
        mDbAdapter = DbAdapter(this@TaskListActivity)
        mDbAdapter?.open()
    }

    private fun loadList(){
        val allTask: List<String>? = mDbAdapter?.selectALLTask()
        val adapter = ArrayAdapter(
            this@TaskListActivity,
            android.R.layout.simple_list_item_1,
            allTask?: emptyList()
        )
        task_list.adapter = adapter
    }
}