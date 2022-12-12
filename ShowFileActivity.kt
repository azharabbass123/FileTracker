package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.com.example.myapplication2.FileModel
import com.example.com.example.myapplication2.FilesAdapter
import kotlinx.android.synthetic.main.activity_show_file.*

class ShowFileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_file)

        var url:String="http://"+GVar.myipaddress+"/FTPHP/ShowFiles.php"


        val recyclerView = findViewById(R.id.rwshowFiles) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this)



        var list=ArrayList<FileModel>()
        var rq: RequestQueue = Volley.newRequestQueue(this)
        var jar= JsonArrayRequest(
            Request.Method.GET,url,null, Response.Listener { response ->

                for (x in 0..response.length()-1)
                    list.add(
                        FileModel(

                        response.getJSONObject(x).getString("filenumber"),
                        response.getJSONObject(x).getString("usernameholdingfile"),
                        response.getJSONObject(x).getString("fileopendate"),
                        response.getJSONObject(x).getString("filesubject"),

                    )
                    )


                var adp= FilesAdapter(this,list)
                recyclerView.layoutManager= LinearLayoutManager(this)
                recyclerView.adapter=adp

            },
            Response.ErrorListener { error ->

            })



        rq.add(jar)


    }

}