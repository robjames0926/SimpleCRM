package com.example.simplecrm.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplecrm.R
import com.example.simplecrm.data.DbAdapter
import kotlinx.android.synthetic.main.activity_quote.*
import kotlinx.android.synthetic.main.activity_task.*
import kotlinx.android.synthetic.main.activity_task.saveBtn

class TaskActivity : AppCompatActivity() {
    private var mDbAdapter: DbAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        initializeViews()
        initializeDatabase()


        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Task Info"
        actionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FDB716")))


    }

    private fun initializeViews () {
        saveBtn.setOnClickListener {
            mDbAdapter?.insertTask(
                task_name.text.toString(),
                task_date.text.toString(),
                description.text.toString()
            )

            val intent = Intent(this, TaskListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initializeDatabase() {
        mDbAdapter = DbAdapter(this@TaskActivity)
        mDbAdapter?.open()
    }
}