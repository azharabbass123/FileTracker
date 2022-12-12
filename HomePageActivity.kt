package com.example.myapplication2


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.IntentCompat
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
        // get refrencde to image view
        val add_file = findViewById (R.id.AddNewFileimg) as ImageView
        // Now set on click listner
        AddNewFileimg.setOnClickListener{
            val intentAddFile = Intent(this, InsertFileActivity::class.java)
            startActivity(intentAddFile)
        }
        SearchFileimg.setOnClickListener{
            val intentSearchFile = Intent(this, SearchFileActivity::class.java)
            startActivity(intentSearchFile)
        }
        ChatWithOtherUsersimg.setOnClickListener {
            val intentChat = Intent(this, ChatActivity::class.java)
            startActivity(intentChat)
        }


    }
}