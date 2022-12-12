package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.com.example.myapplication2.FileModel
import com.example.com.example.myapplication2.FilesAdapter
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_registration.*

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        imgsend.setOnClickListener(){
            sendMessage()
        }
        var url:String="http://"+GVar.myipaddress+"/FTPHP/ShowMessage.php"


        val recyclerView = findViewById(R.id.rwChat) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this)



        var list=ArrayList<MessageModel>()
        var rq: RequestQueue = Volley.newRequestQueue(this)
        var jar= JsonArrayRequest(
            Request.Method.GET,url,null, Response.Listener { response ->

                for (x in 0..response.length()-1)
                    list.add(
                        MessageModel(

                            response.getJSONObject(x).getString("message"),

                            )
                    )


                var adp= MessageAdapter(this,list)
                recyclerView.layoutManager= LinearLayoutManager(this)
                recyclerView.adapter=adp

            },
            Response.ErrorListener { error ->

            })



        rq.add(jar)


    }

    private fun sendMessage() {
        var url: String =
            "http://" + GVar.myipaddress + "/FTPHP/SendMessage.php?message=" + etEnterMessage.text.toString()
        var rq: RequestQueue = Volley.newRequestQueue(this)

        var sr = StringRequest(
            Request.Method.GET, url, { response ->
                if (response.trim() == "Success") {


                    Toast.makeText(this, "Message sent successfuly", Toast.LENGTH_LONG)
                        .show()
                    etEnterMessage.setText("")

                } else {
                    Toast.makeText(this, "Failed", Toast.LENGTH_LONG)
                        .show()

                }

            },
            { error ->
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()

            })

        rq.add(sr)
    }
}