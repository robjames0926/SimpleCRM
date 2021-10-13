package com.example.simplecrm.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.simplecrm.R
import kotlinx.android.synthetic.main.activity_preferences.*
import org.w3c.dom.Text

class PreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Preferences"
        actionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FDB716")))

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        val isGPS = sharedPref.getBoolean("isGps", false)
        val isContact = sharedPref.getBoolean("isContact", false)
        val dataLimit = sharedPref.getString("dataLimit", null)
        val rowLimit = sharedPref.getString("rowLimit", null)

        set_gps.isChecked = isGPS
        set_contacts.isChecked = isContact
        data_limit.setText(dataLimit)
        row_limit.setText(rowLimit)



        saveBtn.setOnClickListener {
            val isGps = set_gps.isChecked
            val isContact = set_contacts.isChecked
            val dataLimit = data_limit.text.toString()
            val rowLimit = row_limit.text.toString()

            editor.apply {
                putBoolean("isGps", isGps)
                putBoolean("isContact", isContact)
                putString("dataLimit", dataLimit)
                putString("rowLimit", rowLimit)
                apply()
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}