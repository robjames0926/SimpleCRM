package com.example.simplecrm.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class DbAdapter (_context: Context) {

    private val DATABASE_NAME: String = "SimpleCRM"
    private var mContext: Context? = null
    private var mDbHelper: MyDBHelper? = null
    private var mSqLiteDatabase: SQLiteDatabase? = null
    private val DATABASE_VERSION = 1

    init {
        this.mContext = _context
        mDbHelper = MyDBHelper(_context, DATABASE_NAME, null, DATABASE_VERSION)
    }

    public fun open() {
        mSqLiteDatabase = mDbHelper?.writableDatabase
    }

    inner class MyDBHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
        SQLiteOpenHelper(context, name, factory, version) {

        override fun onCreate(_db: SQLiteDatabase?) {
            val accountTable = "CREATE TABLE account(id integer primary key autoincrement, name text, accounttype integer, email text, phone text, city text, state text, zip text);"
            val contactTable = "CREATE TABLE contact(id integer primary key autoincrement, name text, email text, phone text, city text, state text, zip text);"
            val quotesTable = "CREATE TABLE quote(id integer primary key autoincrement, name text, product text, cost text);"
            val taskTable = "CREATE TABLE task(id integer primary key autoincrement, name text, date text, description text);"
            val userTable = "CREATE TABLE user(id integer primary key autoincrement, firstname text, lastname text, email text, username text, password text);"
            _db?.execSQL(accountTable)
            _db?.execSQL(contactTable)
            _db?.execSQL(quotesTable)
            _db?.execSQL(taskTable)
            _db?.execSQL(userTable)
        }

        override fun onUpgrade(_db: SQLiteDatabase?, _oldVersion: Int, _newVersion: Int) {
            val accountTable = "DROP TABLE IF EXISTS account;"
            val contactTable= "DROP TABLE IF EXISTS contact;"
            val quoteTable = "DROP TABLE IF EXISTS quote;"
            val taskTable= "DROP TABLE IF EXISTS task;"
            val userTable= "DROP TABLE IF EXISTS user;"
            _db?.execSQL(accountTable)
            _db?.execSQL(contactTable)
            _db?.execSQL(quoteTable)
            _db?.execSQL(taskTable)
            _db?.execSQL(userTable)
            onCreate(_db)
        }
    }

    public fun insertAccount (name: String, accounttype: Int, email: String, phone: String, city: String, state: String, zip: String ){
        val cv: ContentValues = ContentValues()
        cv.put("name", name)
        cv.put("accounttype", accounttype)
        cv.put("email", email)
        cv.put("phone", phone)
        cv.put("city", city)
        cv.put("state", state)
        cv.put("zip", zip)
        mSqLiteDatabase?.insert("account", null, cv)
    }

    public fun insertContact (name: String, email: String, phone: String, city: String, state: String, zip: String ){
        val cv: ContentValues = ContentValues()
        cv.put("name", name)
        cv.put("email", email)
        cv.put("phone", phone)
        cv.put("city", city)
        cv.put("state", state)
        cv.put("zip", zip)
        mSqLiteDatabase?.insert("contact", null, cv)
    }

    public fun insertUser (firstname: String, lastname: String, email: String, username: String, pasword: String ){
        val cv: ContentValues = ContentValues()
        cv.put("firstname", firstname)
        cv.put("lastname", lastname)
        cv.put("email", email)
        cv.put("username", username)
        cv.put("pasword", pasword)
        mSqLiteDatabase?.insert("user", null, cv)
    }

    public fun insertQuote (name: String, product: String, cost: String ){
        val cv: ContentValues = ContentValues()
        cv.put("name", name)
        cv.put("product", product)
        cv.put("cost", cost)
        mSqLiteDatabase?.insert("quote", null, cv)
    }

    public fun insertTask (name: String, date: String, description: String ){
        val cv: ContentValues = ContentValues()
        cv.put("name", name)
        cv.put("date", date)
        cv.put("description", description)
        mSqLiteDatabase?.insert("task", null, cv)
    }

    public fun selectAllAccounts(): List<String> {
        var allAccounts: MutableList<String> = ArrayList();
        var cursor: Cursor = mSqLiteDatabase?.query("account",
            null, null, null,
            null, null, null)!!
        if (cursor.moveToFirst()) {
            do {
                allAccounts.add(cursor.getString(1) + " - " + (cursor.getString(3)))
            } while (cursor.moveToNext());
        }
        return allAccounts;
    }

    public fun selectAllContacts(): List<String> {
        var allContacts: MutableList<String> = ArrayList();
        var cursor: Cursor = mSqLiteDatabase?.query("contact",
            null, null, null,
            null, null, null)!!
        if (cursor.moveToFirst()){
            do{
                allContacts.add(cursor.getString(1) + " - " + (cursor.getString(2)))
            }while (cursor.moveToNext());
        }
        return allContacts
    }

    public fun selectALLQuotes(): List<String> {
        var allQuotes: MutableList<String> = ArrayList();
        var cursor: Cursor = mSqLiteDatabase?.query("quote",
            null, null, null,
            null, null, null
        )!!
        if (cursor.moveToFirst()) {
            do {
                allQuotes.add(cursor.getString(1) + " - " + (cursor.getString(2)) + " - " + (cursor.getString(3)))
            } while (cursor.moveToNext());
        }
        return allQuotes
    }

    public fun selectALLTask(): List<String> {
        var allTask: MutableList<String> = ArrayList();
        var cursor: Cursor = mSqLiteDatabase?.query("task",
            null, null, null,
            null, null, null
        )!!
        if (cursor.moveToFirst()) {
            do {
                allTask.add(cursor.getString(1) + " - " + (cursor.getString(2)) + " - " + (cursor.getString(3)))
            } while (cursor.moveToNext());
        }
        return allTask
    }

    public  fun deleteAllAccount() {
        mSqLiteDatabase?.delete("account", null, null)
    }

    public fun deleteAccount(accountId: Int?) {
        mSqLiteDatabase?.delete("account", "id = $accountId", null)
    }
}