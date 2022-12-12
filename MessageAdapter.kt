package com.example.myapplication2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.com.example.myapplication2.FileModel
import kotlinx.android.synthetic.main.cardview.view.*
import kotlinx.android.synthetic.main.messageview.view.*

class MessageAdapter (var context: Context, var list:ArrayList<MessageModel>):  RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v: View = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false)
        return MessageHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MessageHolder).bind(list[position].message)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind( message:String) {
            itemView.tvmessage.text =message;


        }
    }
}

