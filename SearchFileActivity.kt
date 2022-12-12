package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_search_file.*
class SearchFileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_file)

        btnSearchFile.setOnClickListener{
            searchFile()
        }
    }

    private fun searchFile() {

                        val IntentFile = Intent(this, ShowFileActivity::class.java)
                        Toast.makeText(this, "Fils are ready", Toast.LENGTH_SHORT).show()
                        startActivity(IntentFile)


    }
}