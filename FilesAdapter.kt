package com.example.com.example.myapplication2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.R
import kotlinx.android.synthetic.main.cardview.view.*


class FilesAdapter (var context: Context, var list:ArrayList<FileModel>):  RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v: View = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false)
        return FileHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FileHolder).bind(list[position].filenumber,list[position].PersonName,list[position].OpenDate,list[position].FileSubject )

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class FileHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind( filenumber:String, PersonName:String,  OpenDate:String,  FileSubject:String) {
            itemView.tvFileNumber.text =filenumber;
            itemView.tvPersonNameHoldingFile.text = PersonName;
            itemView.tvFileOpenDate.text = OpenDate;
            itemView.tvFileSubject.text = FileSubject;

        }
    }
}
