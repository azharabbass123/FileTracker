package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_insert_file.*
import kotlinx.android.synthetic.main.activity_registration.*

class InsertFileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_file)

        btnaddfile.setOnClickListener() {

            addFile()

        }

        btnlogout.setOnClickListener() {
            val intentUser = Intent(this, LoginActivity::class.java)
            //starting the activity
            startActivity(intentUser)
        }
    }
    private fun addFile() {
            var url: String =
                "http://" + GVar.myipaddress + "/FTPHP/addNewFile.php?filenumber=" +etfilenumber.text.toString() +"&usernameholdingfile="+etusernameholdingfile.text.toString()+"&fileopendate="+etfileopendate.text.toString()+"&filesubject="+etfilesubject.text.toString()
            var rq: RequestQueue = Volley.newRequestQueue(this)

            var sr = StringRequest(
                Request.Method.GET, url, { response ->
                    if (response.trim() == "Success") {

                        Toast.makeText(this, "File added successfully", Toast.LENGTH_LONG)
                            .show()
                        etfilenumber.setText("")
                        etusernameholdingfile.setText("")
                        etfileopendate.setText("")
                        etfilesubject.setText("")
                        etfilenumber.requestFocus()


                    } else {
                        Toast.makeText(this, "Process failed", Toast.LENGTH_LONG)
                            .show()
                    }

                },
                { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()

                })

            rq.add(sr)
        }


    }



