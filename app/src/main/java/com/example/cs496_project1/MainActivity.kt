package com.example.cs496_project1

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleCursorAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        read()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

    fun read(){
        val listview = findViewById<ListView>(R.id.listview)
        var cursor: Cursor? = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null)
        startManagingCursor(cursor)

        var from = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone._ID)

        var to = intArrayOf(android.R.id.text1, android.R.id.text2)
        var simple: SimpleCursorAdapter = SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to)

        listview.adapter = simple
    }
}